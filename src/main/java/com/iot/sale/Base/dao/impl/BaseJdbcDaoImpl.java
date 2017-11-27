package com.iot.sale.Base.dao.impl;

import com.iot.sale.Base.dao.BaseJdbcDao;
import com.iot.sale.Base.dao.annotation.BoColumn;
import com.iot.sale.Base.dao.annotation.BoTable;
import com.iot.sale.Base.dao.annotation.Column;
import com.iot.sale.Base.dao.annotation.Table;
import com.iot.sale.Base.util.Pager;
import com.iot.sale.Base.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.*;


/**
 * 直接使用JDBC模板的DAO封装类
 */
public abstract class BaseJdbcDaoImpl<T> implements BaseJdbcDao<T> {
    private static final Logger log = LoggerFactory.getLogger(BaseJdbcDaoImpl.class);

    private String FIELD_PRIMARY;// bo对象在MySQL中映射的主键字段
    private String tableName;// 映射的表名
    private String boClassName;//bo类的全包名

    //bo和db之间的映射关系，键为类名，值为映射关系
    private static final Map<String, BoTable> boMap = new HashMap<>();

    @SuppressWarnings("unchecked")
    public BaseJdbcDaoImpl() {
        Type type = this.getClass().getGenericSuperclass();
        Class<T> clazz;
        if (type instanceof ParameterizedType) {
            clazz = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
        } else {
            throw new RuntimeException(this.getClass().getName() + "没有指定bo泛型");
        }
        boClassName = clazz.getName();//获取bo的className
        if (boMap.containsKey(boClassName)) {
            tableName = boMap.get(boClassName).getName();//获取表名
            FIELD_PRIMARY = boMap.get(boClassName).getPk();//获取主键名称
        } else {
            try {
                Table table = clazz.getAnnotation(Table.class);
                if (null == table) {
                    throw new RuntimeException("baseDao出错：" + boClassName + " 没有注解!");
                }
                BoTable boTable = new BoTable();
                tableName = table.name();//获取表名
                FIELD_PRIMARY = table.pk();//获取主键名称

                boTable.setName(tableName);
                boTable.setPk(FIELD_PRIMARY);
                Field[] fields = clazz.getDeclaredFields();//获取所有属性
                Map<String, BoColumn> columnMap = new HashMap<>();
                Map<String, Field> fieldMap = new HashMap<>();
                for (Field field : fields) {
                    Column column = field.getAnnotation(Column.class);//获取属性的注解
                    if (null != column) {
                        BoColumn boColumn = new BoColumn();
                        boColumn.setName(column.name());
                        boColumn.setJavaType(column.type());

                        if (!field.isAccessible()) {
                            field.setAccessible(true);
                        }
                        columnMap.put(field.getName(), boColumn);
                        fieldMap.put(field.getName(), field);
                    }
                }
                boTable.setColumnMap(columnMap);
                boTable.setFieldMap(fieldMap);
                boMap.put(boClassName, boTable);
            } catch (Exception e) {
                log.error(boClassName + "和数据库之间的映射处理出错！", e);
            }
        }
    }

    /**
     * 根据TID查询映对象,如果查询不到，则返回null
     *
     * @param id
     * @return T
     */
    public T findById(String TID) {
        Map<String, Object> map = findMapById(TID);
        return map2Object(map);
    }

    /**
     * 根据TID查询映射后的map对象，如果查询不到，则返回null
     *
     * @param id
     * @return Map<String, Object>
     */
    private Map<String, Object> findMapById(String TID) {
        long start = System.nanoTime();
        if (StringUtil.isNull(TID)) {
            return null;
        }
        String sql = "select * from " + tableName + " where " + FIELD_PRIMARY + " = ?";
        List<Object> list = new ArrayList<Object>();
        list.add(TID);
        final Map<String, Object> map = new HashMap<String, Object>();
        getJDBCTemplate().query(sql, list.toArray(), new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    if (metaData.getColumnTypeName(i).startsWith("TINYINT")) {
                        map.put(columnName, rs.getInt(i));
                    } else if (metaData.getColumnTypeName(i).startsWith("BLOB")) {
                        map.put(columnName, getBlob(rs.getBlob(i)));
                    } else if (metaData.getColumnTypeName(i).startsWith("INT UNSIGNED")) {
                        map.put(columnName, rs.getInt(i));
                    } else if (metaData.getColumnTypeName(i).startsWith("DECIMAL")) {
                        map.put(columnName, rs.getDouble(i));
                    } else {
                        map.put(columnName, rs.getObject(i));
                    }
                }
            }
        });
        long end = System.nanoTime();
        log.debug("【BaseDao中findById方法sql】" + (end - start) / 1000000 + "ms：" + sql);
        if (map.size() == 0) {
            return null;
        }
        return map;
    }

    /**
     * 查询所有数据<br/>
     * 查询不到数据，则返回长度为0的List。
     *
     * @return List<Map<String, Object>>
     */
    public List<T> findAllObjs() {
        final List<T> list = new ArrayList<T>();
        List<Map<String, Object>> listMap = findAll();
        for (Map<String, Object> map : listMap) {
            list.add(map2Object(map));
        }
        return list;
    }

    /**
     * 查询所有数据<br/>
     * 如果查询不到，则返回长度为0的List。
     *
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> findAll() {
        long start = System.nanoTime();
        String sql = "select * from " + tableName;
        final List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        getJDBCTemplate().query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                Map<String, Object> map = new HashMap<String, Object>(columnCount);
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    if (metaData.getColumnTypeName(i).startsWith("TINYINT")) {
                        map.put(columnName, rs.getInt(i));
                    } else if (metaData.getColumnTypeName(i).startsWith("BLOB")) {
                        map.put(columnName, getBlob(rs.getBlob(i)));
                    } else if (metaData.getColumnTypeName(i).startsWith("INT UNSIGNED")) {
                        map.put(columnName, rs.getInt(i));
                    } else if (metaData.getColumnTypeName(i).startsWith("DECIMAL")) {
                        map.put(columnName, rs.getDouble(i));
                    } else {
                        map.put(columnName, rs.getObject(i));
                    }
                }
                list.add(map);
            }
        });
        long end = System.nanoTime();
        log.debug("【BaseDao中findAll方法sql】" + (end - start) / 1000000 + "ms：" + sql);
        return list;
    }

    /**
     * 分页查询该对象所有数据
     *
     * @param Pager<Map<String, Object>>，如果为null，则从第一页开始查询。
     * @return Pager<Map<String, Object>>
     */
    public Pager<T> findAllPage(Pager<T> page) {
        return findAllPage(page, null, null);
    }

    /**
     * 分页查询该对象所有数据
     *
     * @param page       如果为null，则从第一页开始查询。
     * @param orderColum 排序的字段名称，数据库中字段名称
     * @param isASC      是否升序，true：按照升序排列；fasle：按照降序排列
     * @return
     */
    public Pager<T> findAllPage(Pager<T> page, String orderColum, Boolean isASC) {
        long start = System.nanoTime();
        if (page == null) {
            page = new Pager<T>();
        }
        String limitSql = " limit " + page.getStart() + "," + page.getPageSize();
        String querySql = "select * from " + tableName;

        if (!StringUtil.isNull(orderColum)) {
            if (isASC) {
                querySql = querySql + " order by " + orderColum + " asc";
            } else {
                querySql = querySql + " order by " + orderColum + " desc";
            }
        }

        String sql = querySql + limitSql;
        final List<T> list = new ArrayList<T>();
        getJDBCTemplate().query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                Map<String, Object> map = new HashMap<String, Object>(columnCount);
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    if (metaData.getColumnTypeName(i).startsWith("TINYINT")) {
                        map.put(columnName, rs.getInt(i));
                    } else if (metaData.getColumnTypeName(i).startsWith("INT UNSIGNED")) {
                        map.put(columnName, rs.getInt(i));
                    } else if (metaData.getColumnTypeName(i).startsWith("DECIMAL")) {
                        map.put(columnName, rs.getDouble(i));
                    } else {
                        map.put(columnName, rs.getObject(i));
                    }
                }
                list.add(map2Object(map));
            }
        });
        int queryCount = this.queryCount(querySql);
        page.setTotalCount(queryCount);
        page.setDataList(list);
        long end = System.nanoTime();
        log.debug("【BaseDao中findAllPage方法sql】" + (end - start) / 1000000 + "ms：" + sql);
        return page;
    }

    /**
     * 分页查询该对象所有数据
     *
     * @param page
     * @param map        查询参数
     * @param orderColum 排序字段
     * @param isASC      是否升序
     * @return
     */
    public Pager<T> findAllPage(Pager<T> page, Map<String, Object> map, String orderColum, Boolean isASC) {
        long start = System.nanoTime();
        if (page == null) {
            page = new Pager<T>();
        }

        if (null == map || map.size() == 0) {
            map = new HashMap<String, Object>(1);
            map.put("1", "1");
        }

        List<Object> values = new ArrayList<>(map.size() + 1);
        String limitSql = " limit " + page.getStart() + "," + page.getPageSize();
        StringBuilder querySql = new StringBuilder("select * from " + tableName + " where ");
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            querySql.append(key + "=? and ");
            values.add(map.get(key));
        }

        querySql.delete(querySql.length() - 4, querySql.length());

        if (!StringUtil.isNull(orderColum)) {
            if (isASC) {
                querySql = querySql.append(" order by ").append(orderColum).append(" asc");
            } else {
                querySql = querySql.append(" order by ").append(orderColum).append(" desc");
            }
            // values.add(orderColum);
        }

        String sql = querySql.append(limitSql).toString();
        final List<T> list = new ArrayList<T>();
        getJDBCTemplate().query(sql, values.toArray(), new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                Map<String, Object> map = new HashMap<String, Object>(columnCount);
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    if (metaData.getColumnTypeName(i).startsWith("TINYINT")) {
                        map.put(columnName, rs.getInt(i));
                    } else if (metaData.getColumnTypeName(i).startsWith("INT UNSIGNED")) {
                        map.put(columnName, rs.getInt(i));
                    } else if (metaData.getColumnTypeName(i).startsWith("DECIMAL")) {
                        map.put(columnName, rs.getDouble(i));
                    } else {
                        map.put(columnName, rs.getObject(i));
                    }
                }
                list.add(map2Object(map));
            }
        });
        int queryCount = this.queryCount(querySql.toString(), values);
        page.setTotalCount(queryCount);
        page.setDataList(list);
        long end = System.nanoTime();
        log.debug("【BaseDao中findAllPage方法sql】" + (end - start) / 1000000 + "ms：" + sql);
        return page;
    }

    /**
     * 根据数据库字段名值对来获取数据，多个字段之间采用and关系处理。
     *
     * @param map
     * @return List<Map<String, Object>>
     */
    public List<T> findObjsByFields(Map<String, Object> map) {
        final List<T> list = new ArrayList<T>();
        List<Map<String, Object>> listMap = findByFields(map);
        for (Map<String, Object> resultMap : listMap) {
            list.add(map2Object(resultMap));
        }
        return list;
    }

    /**
     * 根据数据库字段名值对来获取数据，且只返回第一条数据，多个字段之间采用and关系处理。
     *
     * @param map
     * @return
     */
    public T findObjByFields(Map<String, Object> map) {
        List<T> list = findObjsByFields(map);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 根据数据库字段名值对来获取数据，多个字段之间采用and关系处理。
     *
     * @param map
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> findByFields(Map<String, Object> map) {
        long start = System.nanoTime();
        if (null == map || map.size() == 0) {
            map = new HashMap<String, Object>(1);
            map.put("1", "1");
        }
        final List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        final List<Object> values = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder("select * from " + tableName + " where ");
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            sql.append(key + "=? and ");
            values.add(map.get(key));
        }

        sql.delete(sql.length() - 4, sql.length());
        getJDBCTemplate().query(sql.toString(), values.toArray(), new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                Map<String, Object> map = new HashMap<String, Object>(columnCount);
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    if (metaData.getColumnTypeName(i).startsWith("TINYINT")) {
                        map.put(columnName, rs.getInt(i));
                    } else if (metaData.getColumnTypeName(i).startsWith("INT UNSIGNED")) {
                        map.put(columnName, rs.getInt(i));
                    } else if (metaData.getColumnTypeName(i).startsWith("DECIMAL")) {
                        map.put(columnName, rs.getDouble(i));
                    } else {
                        map.put(columnName, rs.getObject(i));
                    }
                }
                list.add(map);
            }
        });
        long end = System.nanoTime();
        log.debug("【BaseDao中findByFields方法sql】" + (end - start) / 1000000 + "ms：" + sql.toString());
        return list;
    }

    /**
     * 根据数据库字段名值对来获取分页数据，多个字段之间采用and关系处理。
     *
     * @param page ,如果为null，则从第一页开始查询。
     * @param map  封装了参数的map
     * @return page
     */
    public Pager<T> findObjsByFieldsPage(Pager<T> page, Map<String, Object> map) {
        Pager<Map<String, Object>> pageTem = new Pager<Map<String, Object>>();
        pageTem.setCurrentPage(page.getCurrentPage());
        pageTem.setPageSize(page.getPageSize());
        pageTem = this.findByFieldsPage(pageTem, map);
        List<Map<String, Object>> listMap = pageTem.getDataList();
        final List<T> listt = new ArrayList<T>();
        for (Map<String, Object> resultMap : listMap) {
            listt.add(map2Object(resultMap));
        }
        page.setDataList(listt);
        copyPage(pageTem, page);
        return page;
    }

    /**
     * 根据数据库字段名值对来获取分页数据，多个字段之间采用and关系处理。
     *
     * @param page ,如果为null，则从第一页开始查询。
     * @param map  封装了参数的map
     * @return page
     */
    public Pager<Map<String, Object>> findByFieldsPage(Pager<Map<String, Object>> page, Map<String, Object> map) {
        long start = System.nanoTime();
        if (page == null) {
            page = new Pager<Map<String, Object>>();
        }
        final List<Object> values = new ArrayList<Object>();
        StringBuilder sql = null;
        String limitSql = " limit " + page.getStart() + "," + page.getPageSize();
        String queryCountSql = null;// 查询总条数使用的sql语句
        final List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        if (null != map && map.size() != 0) {
            sql = new StringBuilder("select * from " + tableName + " where ");
            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                sql.append(key + " = ? and ");
                values.add(map.get(key));
            }
            sql.delete(sql.length() - 4, sql.length());// 去掉最后的 " and"。
        } else {
            sql = new StringBuilder("select * from " + tableName);
        }
        queryCountSql = sql.toString();// 构建查询总条数的SQL语句。
        sql.append(limitSql);// sql语句加上limit语句。

        getJDBCTemplate().query(sql.toString(), values.toArray(), new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                Map<String, Object> map = new HashMap<String, Object>(columnCount);
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    if (metaData.getColumnTypeName(i).startsWith("TINYINT")) {
                        map.put(columnName, rs.getInt(i));
                    } else if (metaData.getColumnTypeName(i).startsWith("INT UNSIGNED")) {
                        map.put(columnName, rs.getInt(i));
                    } else if (metaData.getColumnTypeName(i).startsWith("DECIMAL")) {
                        map.put(columnName, rs.getDouble(i));
                    } else {
                        map.put(columnName, rs.getObject(i));
                    }
                }
                list.add(map);
            }
        });

        int queryCount = queryCount(queryCountSql, values);
        page.setTotalCount(queryCount);
        page.setDataList(list);
        long end = System.nanoTime();
        log.debug("【BaseDao中findByFieldsPage方法sql】" + (end - start) / 1000000 + "ms：" + sql.toString());
        return page;
    }

    /**
     * 查询数据条数<br/>
     *
     * @param sql  查询的sql语句
     * @param list 参数对象，必须和sql语句中的占位符“？”顺序一一对应。
     * @return 查询总条数
     */
    public int queryCount(String sql, List<Object> list) {
        if (list == null || list.size() == 0) {
            return queryCount(sql);
        } else {
            return queryCount(sql, list.toArray());
        }
    }

    /**
     * 查询数据条数，查询语句不能是select count(*) ... ，而是正常的查询语句，可自动统计查询条数。<br/>
     *
     * @param sql  查询的sql语句
     * @param list 参数对象，必须和sql语句中的占位符“？”顺序一一对应。
     * @return 查询总条数
     */
    public int queryCount(String sql, Object... values) {
        RowCountCallbackHandler rch = new RowCountCallbackHandler();// Spring内部提供的回调函数实现。
        if (values == null || values.length == 0) {
            getJDBCTemplate().query(sql, rch);
        } else {
            getJDBCTemplate().query(sql, values, rch);// 将结果封装在回调对象的属性里。
        }
        int rowCount = rch.getRowCount();
        return rowCount;
    }

    /**
     * 根据参数查询该对象的条数
     *
     * @param map
     * @return
     */
    public int queryCount(Map<String, Object> map) {
        long start = System.nanoTime();
        final int[] intArray = {0};
        if (null == map || map.size() == 0) {
            return intArray[0];
        }
        final List<Object> values = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder("select count(*) from " + tableName + " where ");
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            sql.append(key + "=? and ");
            values.add(map.get(key));
        }

        sql.delete(sql.length() - 4, sql.length());
        getJDBCTemplate().query(sql.toString(), values.toArray(), new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                intArray[0] = rs.getInt(1);
            }
        });
        long end = System.nanoTime();
        log.debug("【BaseDao中queryCount方法sql】" + (end - start) / 1000000 + "ms：" + sql.toString());
        return intArray[0];
    }

    /**
     * 查询单个整数，一般用于查询数据条数。
     *
     * @param sql
     * @param list 参数对象，必须和sql语句中的占位符“？”顺序一一对应。
     * @return Integer 值
     */
    public int queryInteger(String sql, Object... values) {
        long start = System.nanoTime();
        int num = 0;
        if (null == values || values.length == 0) {
            num = getJDBCTemplate().queryForObject(sql, Integer.class);
        } else {
            num = getJDBCTemplate().queryForObject(sql, values, Integer.class);
        }
        long end = System.nanoTime();
        log.debug("【BaseDao中queryInteger方法sql】" + (end - start) / 1000000 + "ms：" + sql);
        return num;
    }

    /**
     * 根据SQL语句和参数对象来查询数据，可查询任意表。
     * TODO未测试
     *
     * @param sql
     * @param list<Object> 可以为null
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> findBySQL(String sql, Object... objs) {
        long start = System.nanoTime();
        final List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        if (null == objs) {
            objs = new Object[0];
        }
        getJDBCTemplate().query(sql, objs, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                Map<String, Object> map = new HashMap<String, Object>(columnCount);
                for (int i = 1; i <= columnCount; i++) {
                    //String columnName = metaData.getColumnName(i);
                    String columnName = metaData.getColumnLabel(i);
                    if (metaData.getColumnTypeName(i).startsWith("TINYINT")) {
                        map.put(columnName, rs.getInt(i));
                    } else if (metaData.getColumnTypeName(i).startsWith("INT UNSIGNED")) {
                        map.put(columnName, rs.getInt(i));
                    } else if (metaData.getColumnTypeName(i).startsWith("DECIMAL")) {
                        map.put(columnName, rs.getDouble(i));
                    } else {
                        map.put(columnName, rs.getObject(i));
                    }
                }
                list.add(map);
            }
        });
        long end = System.nanoTime();
        log.debug("【BaseDao中findBySQL方法sql】" + (end - start) / 1000000 + "ms：" + sql);
        return list;
    }

    /**
     * 根据SQL语句和参数对象来查询数据，只可查询当前对象映射表。
     *
     * @param sql
     * @param objs 查询参数
     * @return
     */
    public List<T> findObjsBySQL(String sql, Object... objs) {
        List<T> list = new ArrayList<T>(10);
        List<Map<String, Object>> listMap = findBySQL(sql, objs);
        for (Map<String, Object> map : listMap) {
            list.add(map2Object(map));
        }
        return list;
    }

    /**
     * 根据SQL语句和参数对象来查询数据，且只返回第一条数据，只可查询当前对象映射表。
     *
     * @param sql
     * @param objs
     * @return
     */
    public T findObjBySQL(String sql, Object... objs) {
        List<T> list = findObjsBySQL(sql, objs);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 根据SQL语句和参数查询数据，并分页。<br/>
     * 可查询任意表
     *
     * @param sql    查询使用的sql语句。sql不能包含limit语句。
     * @param values 参数对象
     * @param page   分页信息
     * @return 分页数据
     */
    public Pager<Map<String, Object>> findBySQLPage(final String sql, List<Object> values, Pager<Map<String, Object>> page) {
        long start = System.nanoTime();
        final List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        if (null == values) {
            values = new ArrayList<Object>();
        }
        if (page == null) {
            page = new Pager<Map<String, Object>>();
        }
        String limitSql = " limit " + page.getStart() + "," + page.getPageSize();
        String querySql = sql + limitSql;

        getJDBCTemplate().query(querySql, values.toArray(), new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                Map<String, Object> map = new HashMap<String, Object>(columnCount);
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    if (metaData.getColumnTypeName(i).startsWith("TINYINT")) {
                        map.put(columnName, rs.getInt(i));
                    } else if (metaData.getColumnTypeName(i).startsWith("INT UNSIGNED")) {
                        map.put(columnName, rs.getInt(i));
                    } else if (metaData.getColumnTypeName(i).startsWith("DECIMAL")) {
                        map.put(columnName, rs.getDouble(i));
                    } else {
                        map.put(columnName, rs.getObject(i));
                    }
                }
                list.add(map);
            }
        });
        int queryCount = queryCount(sql, values);
        page.setTotalCount(queryCount);
        page.setDataList(list);
        long end = System.nanoTime();
        log.debug("【BaseDao中findBySQLPage方法sql】" + (end - start) / 1000000 + "ms：" + querySql);
        return page;
    }

    /**
     * 根据SQL语句和参数查询数据，并分页。<br/>
     * 注意：只能查询当前对象映射的表。
     *
     * @param sql
     * @param page
     * @param values
     * @return
     */
    public Pager<T> findObjsBySQLPage(final String sql, Pager<T> page, Object... values) {
        long start = System.nanoTime();
        final List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        List<T> list = new ArrayList<T>();
        if (null == values) {
            values = new Object[0];
        }
        if (page == null) {
            page = new Pager<T>();
        }
        String limitSql = " limit " + page.getStart() + "," + page.getPageSize();
        String querySql = sql + limitSql;

        getJDBCTemplate().query(querySql, values, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                Map<String, Object> map = new HashMap<String, Object>(columnCount);
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    if (metaData.getColumnTypeName(i).startsWith("TINYINT")) {
                        map.put(columnName, rs.getInt(i));
                    } else if (metaData.getColumnTypeName(i).startsWith("INT UNSIGNED")) {
                        map.put(columnName, rs.getInt(i));
                    } else if (metaData.getColumnTypeName(i).startsWith("DECIMAL")) {
                        map.put(columnName, rs.getDouble(i));
                    } else {
                        map.put(columnName, rs.getObject(i));
                    }
                }
                listMap.add(map);
            }
        });
        for (Map<String, Object> map : listMap) {
            list.add(map2Object(map));
        }

        int queryCount = queryCount(sql, values);
        page.setTotalCount(queryCount);
        page.setDataList(list);
        long end = System.nanoTime();
        log.debug("【BaseDao中findBySQLPage方法sql】" + (end - start) / 1000000 + "ms：" + querySql);
        return page;
    }

    @Override
    public List<T> findObjsByIds(Collection<? extends Object> ids) {
        if (ids != null && ids.size() > 0) {
            StringBuffer buffer = new StringBuffer("?");
            for (int i = 1; i < ids.size(); i++) {
                buffer.append(",?");
            }
            String sql = "select * from " + getTableName() + " where " + getPrimary() + " in (" + buffer.toString() + ")";
            List<T> resultList = findObjsBySQL(sql, ids.toArray());
            return resultList;
        } else {
            return null;
        }
    }

    /**
     * 保存实体，参数为对象
     * 要求被保存对象T 值为“TID”的属性，对应的值不能为null。否则会报异常。
     *
     * @param t
     * @return void
     */
    public void save(T t) {
        if (null == t) {
            log.warn("需要保存的实体为null ！");
            return;
        }
        Map<String, Object> map = object2Map(t);
        save(map);
    }

    /**
     * 保存实体<br/>
     * 要求被保存对象T 值为“TID”的属性，对应的值不能为null。否则会报异常。
     *
     * @param map
     * @return
     */
    public void save(Map<String, Object> map) {
        long start = System.nanoTime();
        if (null == map || map.size() == 0) {
            log.warn("需要保存的实体为null，或者map的长度为0 ！");
            return;
        }

        //uuid做主键可以打开;自增主键需要注释掉
//        if (StringUtil.isNull((String) map.get(FIELD_PRIMARY))) {
//            String errorMessage = "保存的实体主键为空，请检查主键值！";
//            log.error(errorMessage);
//            throw new RuntimeException(errorMessage);
//        }

        List<Object> list = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder("insert into " + tableName + " (");
        StringBuilder values = new StringBuilder("");
        Set<String> keySet = map.keySet();

        for (String colum : keySet) {
            if (null == map.get(colum)) {
                continue;
            }
            sql.append(colum + ",");
            values.append("?,");
            list.add(map.get(colum));
        }

        sql.deleteCharAt(sql.length() - 1);// 去掉最后一个","符号
        values.deleteCharAt(values.length() - 1);// 去掉最后一个","符号
        sql.append(") values(" + values.toString() + ")");
        getJDBCTemplate().update(sql.toString(), list.toArray());
        long end = System.nanoTime();
        log.debug("【BaseDao中save方法sql】" + (end - start) / 1000000 + "ms：" + sql);
    }

    /**
     * 保存实体，参数为对象
     * 要求被保存对象T 值为“TID”的属性，对应的值不能为null。否则会报异常。
     *
     * @param t
     * @return 返回插入记录
     */
    @Override
    public T saveReturnEntity(T t) {
        if (null == t) {
            log.warn("需要保存的实体为null ！");
            return null;
        }
        Map<String, Object> map = object2Map(t);
        //插入表，返回主键的值
        String priVal = saveReturnPrimary(map);
        t = findById(priVal.toString());
        return t;
    }

    /**
     * 保存实体<br/>
     * 要求被保存对象T 值为“TID”的属性，对应的值不能为null。否则会报异常。
     *
     * @param map
     * @return 返回插入数据的主键值toString后的值
     */
    @Override
    public String saveReturnPrimary(Map<String, Object> map) {
        long start = System.nanoTime();
        if (null == map || map.size() == 0) {
            log.warn("需要保存的实体为null，或者map的长度为0 ！");
            return null;
        }

        List<Object> list = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder("insert into " + tableName + " (");
        StringBuilder values = new StringBuilder("");
        Set<String> keySet = map.keySet();

        for (String colum : keySet) {
            if (null == map.get(colum)) {
                continue;
            }
            sql.append(colum + ",");
            values.append("?,");
            list.add(map.get(colum));
        }

        sql.deleteCharAt(sql.length() - 1);// 去掉最后一个","符号
        values.deleteCharAt(values.length() - 1);// 去掉最后一个","符号
        sql.append(") values(" + values.toString() + ")");
        JdbcTemplate template = getJDBCTemplate();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
                int index = 1;
                for (Object object : list) {
                    ps.setObject(index++, object);
                }
                return ps;
            }
        }, keyHolder);
        return String.valueOf(keyHolder.getKey().intValue());
    }

    /**
     * 批量保存数据，要求所有数据都是同一张表数据。
     *
     * @param listMap
     */
    public void saveList(List<Map<String, Object>> listMap) {
        long start = System.nanoTime();
        if (null == listMap || listMap.size() == 0) {
            log.warn("需要保存的实体为null，或者map的长度为0 ！");
            return;
        }
        Set<String> columnSet = new HashSet<String>();
        List<Object[]> list = new ArrayList<Object[]>();

        for (Map<String, Object> map : listMap) {
            Set<String> keySet = map.keySet();
            columnSet.addAll(keySet);
        }
        int size = columnSet.size();
        if (size == 0) {
            return;
        }
        StringBuilder sql = new StringBuilder("insert into " + tableName + " (");
        StringBuilder sql_value = new StringBuilder("");
        for (String columnName : columnSet) {
            sql.append(columnName + ",");
            sql_value.append("?,");
        }
        sql.deleteCharAt(sql.length() - 1);// 去掉最后一个","符号
        sql.append(") values(");

        sql_value.deleteCharAt(sql_value.length() - 1);// 去掉最后一个","符号
        sql_value.append(")");// 添上最后的括号

        sql.append(sql_value);

        for (Map<String, Object> map : listMap) {
            Object[] values = new Object[size];
            int i = 0;
            for (String columnName : columnSet) {
                values[i] = map.get(columnName);
                i++;
            }
            list.add(values);
        }
        getJDBCTemplate().batchUpdate(sql.toString(), list);
        long end = System.nanoTime();
        log.debug("【BaseDao中saveList[保存 " + list.size() + " 条数]方法sql】" + (end - start) / 1000000 + "ms：" + sql);
    }

    /**
     * 批量保存实体
     *
     * @param Collection
     */
    public void saveList(Collection<T> coll) {
        if (null == coll || coll.size() == 0) {
            log.warn("需要保存的实体为null 或者 集合长度为0 ！");
            return;
        }
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        for (T t : coll) {
            listMap.add(object2Map(t));
        }
        saveList(listMap);
    }

    /**
     * 保存或者更新实体，根据Tid主键值在数据库里是否存在相应数据来选择保存还是更新。<br/>
     * 如果不存在以tid值为主键的数据，则执行增加，否则执行更新
     *
     * @param t
     */
    public void saveOrUpdate(T t) {
        if (null == t) {
            log.warn("需要保存或更新的实体为null ！");
            return;
        }
        Map<String, Object> map = object2Map(t);
        String tid = (map.get(FIELD_PRIMARY) != null) ? (String.valueOf(map.get(FIELD_PRIMARY))) : (null);
        if (tid == null) {
            save(t);
        } else {
            StringBuilder sql = new StringBuilder("select count(*) from " + tableName + " where " + FIELD_PRIMARY + " = ? ");
            int count = queryCount(sql.toString(), tid);
            if (count < 1) {
                save(t);
            } else {
                update(t);
            }
        }

    }

    /**
     * 更新实体，要求更新的map参数中必须携带键位“TID”的值，否则无法更新。
     *
     * @param map
     * @throws RuntimeExcepiton 如果不map中无“TID”键值对，则会抛出该异常
     */
    public void update(Map<String, Object> map) {
        update(map, Boolean.FALSE);
    }

    /**
     * 更新实体，要求更新的map参数中必须携带键位“TID”的值，否则无法更新。
     * 默认不更新null值。
     *
     * @param map
     * @throws RuntimeExcepiton 如果不map中无“TID”键值对，则会抛出该异常
     */
    private void update(final Map<String, Object> map, final Boolean isUpdateNull) {
        long start = System.nanoTime();
        if (null == map || map.size() == 0) {
            log.warn("更新的信息为null，无法更新，直接返回！");
            return;
        }
        // 判断是否携带了主键值
        String tid_value = (map.get(FIELD_PRIMARY) != null) ? (String.valueOf(map.get(FIELD_PRIMARY))) : (null);
        if (StringUtil.isNull(tid_value)) {
            log.error("更新的实体无主键值，请检查是否携带了TID值。");
            throw new RuntimeException("更新的实体无主键值，请检查是否携带了TID值。");
        }

        List<Object> list = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder("update " + tableName + " set ");
        Set<String> keySet = map.keySet();
        if (isUpdateNull) {// 更新null值
            for (String key : keySet) {
                sql.append(key + " = ?,");
                list.add(map.get(key));
            }
        } else {// 不更新null
            for (String key : keySet) {
                // 如果为null，则不处理。
                if (null == map.get(key)) {
                    continue;
                }
                sql.append(key + " = ?,");
                list.add(map.get(key));
            }
        }
        sql.deleteCharAt(sql.length() - 1).append(" where " + FIELD_PRIMARY + " = ?");// 去掉最后一个","符号，同时添加where条件
        list.add(tid_value);
        getJDBCTemplate().update(sql.toString(), list.toArray());
        long end = System.nanoTime();
        log.debug("【BaseDao中update方法sql】" + (end - start) / 1000000 + "ms：" + sql);
    }

    /**
     * 更新实体，要求更新的实体属性TID不能为空，否则无法更新。
     * 默认不更新null值。
     *
     * @param t
     * @throws RuntimeExcepiton 如果实体中无“TID”属性值，则会抛出该异常
     */
    public void update(T t) {
        // 默认不更新null值。
        update(t, Boolean.FALSE);
    }

    /**
     * 更新实体，要求更新的实体属性TID不能为空，否则无法更新。
     *
     * @param t                                                   需要更新的实体。
     * @param isUpdateNull，是否更新null值。true，更新null值；false，不更新null值。
     * @throws RuntimeExcepiton 如果map中无“TID”键值对，则会抛出该异常
     */
    public void update(T t, Boolean isUpdateNull) {
        if (null == t) {
            return;
        }
        Map<String, Object> map = object2Map(t);
        update(map, isUpdateNull);
    }

    /**
     * 根据TID删除实体
     *
     * @param TID
     */
    public int deleteById(String TID) {
        long start = System.nanoTime();
        int count = 0;
        if (StringUtil.isNull(TID)) {
            log.error("BaseDao中deleteById参数TID为空");
            return 0;
        }
        String sql = "delete from " + tableName + " where " + FIELD_PRIMARY + " = ?";
        List<Object> list = new ArrayList<Object>();
        list.add(TID);
        count = getJDBCTemplate().update(sql, list.toArray());
        long end = System.nanoTime();
        log.debug("【BaseDao中deleteById方法sql】" + (end - start) / 1000000 + "ms：" + sql);
        return count;
    }

    /**
     * 根据键值对删除数据，如果键值对中包含以“tid”为键的键值对，则直接根据该tid删除数据
     *
     * @param map
     */
    public int delete(Map<String, Object> map) {
        long start = System.nanoTime();
        int count = 0;
        if (null == map || map.size() == 0) {
            log.warn("删除的信息为null，无法删除，直接返回！");
            return count;
        }
        // 判断是否携带了主键值
        String tid_value = (map.get(FIELD_PRIMARY) != null) ? (String.valueOf(map.get(FIELD_PRIMARY))) : (null);
        if (StringUtil.isNotNull(tid_value)) {
            return deleteById(tid_value);
        }

        List<Object> list = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder("delete from " + tableName + " where ");
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            sql.append(key + " = ? and ");
            list.add(map.get(key));
        }
        String deleteSql = sql.substring(0, sql.length() - 4);// 删除最后4个字符："and ".
        count = getJDBCTemplate().update(deleteSql, list.toArray());
        long end = System.nanoTime();
        log.debug("【BaseDao中delete(Map)方法sql】" + (end - start) / 1000000 + "ms：" + deleteSql);
        return count;
    }

    /**
     * 执行更新或者删除等非查询sql语句,
     *
     * @param sql   sql语句
     * @param param 参数
     * @return 影响的数据库行数
     */
    public int executeUpdate(String sql, Object... param) {
        return getJDBCTemplate().update(sql, param);
    }

    /**
     * 获取主键在数据库表中的字段名
     *
     * @return
     */
    public String getPrimary() {
        return FIELD_PRIMARY;
    }

    ;

    /**
     * 获取映射的表名称
     *
     * @return
     */
    public String getTableName() {
        return tableName;
    }

    ;

    @SuppressWarnings("rawtypes")
    private static void copyPage(Pager pageSource, Pager pageDist) {
        if (null != pageSource && null != pageDist) {
            pageDist.setEnd(pageSource.getEnd());
            pageDist.setCurrentPage(pageSource.getCurrentPage());
            pageDist.setPageSize(pageSource.getPageSize());
            pageDist.setStart(pageSource.getStart());
            pageDist.setTotalCount(pageSource.getTotalCount());
            pageDist.setPageCount(pageSource.getPageCount());
        }
    }

    public Map<String, Object> object2Map(T t) {
        if (null == t) {
            return null;
        } else {
            Class<? extends Object> clazz = t.getClass();
            String clazzName = clazz.getName();
            BoTable boTable = boMap.get(clazzName);
            if (boTable == null) {
                throw new RuntimeException("baseDao出错： " + clazzName + " 没有映射或者没有加载！");
            }
            Map<String, BoColumn> columnMap = boTable.getColumnMap();
            Map<String, Object> resultMap = new HashMap<>(columnMap.size());
            Set<Map.Entry<String, BoColumn>> entrySet = columnMap.entrySet();
            try {
                for (Map.Entry<String, BoColumn> entry : entrySet) {//键为属性名，值为数据库字段值
                    String key = entry.getKey();
                    BoColumn colum = entry.getValue();
                    Field field = boTable.getFieldMap().get(key);
                    resultMap.put(colum.getName(), field.get(t));
                }
            } catch (Exception e) {
                throw new RuntimeException("baseDao出错：对象到map的转换。", e);
            }
            return resultMap;
        }
    }

    /**
     * map转换为object bo类实例
     *
     * @param map
     * @return
     */
    public T map2Object(Map<String, Object> map) {
        if (null == map || map.size() == 0) {
            return null;
        } else {
            BoTable boTable = boMap.get(boClassName);
            if (boTable == null) {
                throw new RuntimeException("baseDao出错： " + boClassName + " 没有映射或者没有加载！");
            }
            T bo = null;
            Map<String, BoColumn> columnMap = boTable.getColumnMap();
            try {
                @SuppressWarnings("unchecked")
                Class<T> clazz = (Class<T>) Class.forName(boClassName);
                bo = clazz.newInstance();
                Set<Map.Entry<String, BoColumn>> entrySet = columnMap.entrySet();
                for (Map.Entry<String, BoColumn> entry : entrySet) {//键为属性名，值为数据库字段值
                    String key = entry.getKey();
                    BoColumn colum = entry.getValue();
                    Field field = boTable.getFieldMap().get(key);

                    field.set(bo, map.get(colum.getName()));
                }
            } catch (Exception e) {
                throw new RuntimeException("baseDao出错：map到对象的转换。", e);
            }
            return bo;
        }
    }

    /**
     * 读取Blob字段内容
     *
     * @param blob
     * @return
     */
    private String getBlob(Blob blob) {
        String content = null;
        try {
            long blobLength = blob.length();

            if (blobLength > 0) {
                byte[] data = blob.getBytes(1, (int) blobLength);
                content = new String(data);
            }
        } catch (Exception e) {
            throw new RuntimeException("读取Blob字段异常！");
        }

        return content;
    }

    /**
     * 获取JDBCTemplate,因为不同的bo可能使用的是不同的数据库，所以数据源也可能不一样。所以不在统一的BaseDAO中设置
     *
     * @return
     */
    public abstract JdbcTemplate getJDBCTemplate();

}
