package com.iot.sale.Base.dao;

import com.iot.sale.Base.util.Pager;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.io.Serializable;

/**
 * 直接使用JDBC模板的DAO封装类
 */
public interface BaseJdbcDao<T> {

    /**
     * 根据TID查询映对象,如果查询不到，则返回null
     *
     * @param id
     * @return T
     */
    public T findById(String TID);

    /**
     * 查询所有数据<br/>
     * 查询不到数据，则返回长度为0的List。
     *
     * @return List<Map<String, Object>>
     */
    public List<T> findAllObjs();

    /**
     * 查询所有数据<br/>
     * 如果查询不到，则返回长度为0的List。
     *
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> findAll();

    /**
     * 分页查询该对象所有数据
     *
     * @param Pager<Map<String, Object>>，如果为null，则从第一页开始查询。
     * @return Pager<Map<String, Object>>
     */
    public Pager<T> findAllPage(Pager<T> page);

    /**
     * 分页查询该对象所有数据
     *
     * @param page       如果为null，则从第一页开始查询。
     * @param orderColum 排序的字段名称，数据库中字段名称
     * @param isASC      是否升序，true：按照升序排列；fasle：按照降序排列
     * @return
     */
    public Pager<T> findAllPage(Pager<T> page, String orderColum, Boolean isASC);

    /**
     * 分页查询该对象所有数据
     *
     * @param page
     * @param map        查询参数
     * @param orderColum 排序字段
     * @param isASC      是否升序
     * @return
     */
    public Pager<T> findAllPage(Pager<T> page, Map<String, Object> map, String orderColum, Boolean isASC);

    /**
     * 根据数据库字段名值对来获取数据，多个字段之间采用and关系处理。
     *
     * @param map
     * @return List<Map<String, Object>>
     */
    public List<T> findObjsByFields(Map<String, Object> map);

    /**
     * 根据数据库字段名值对来获取数据，且只返回第一条数据，多个字段之间采用and关系处理。
     *
     * @param map
     * @return
     */
    public T findObjByFields(Map<String, Object> map);

    /**
     * 根据数据库字段名值对来获取数据，多个字段之间采用and关系处理。
     *
     * @param map
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> findByFields(Map<String, Object> map);

    /**
     * 根据数据库字段名值对来获取分页数据，多个字段之间采用and关系处理。
     *
     * @param page ,如果为null，则从第一页开始查询。
     * @param map  封装了参数的map
     * @return page
     */
    public Pager<T> findObjsByFieldsPage(Pager<T> page, Map<String, Object> map);

    /**
     * 根据数据库字段名值对来获取分页数据，多个字段之间采用and关系处理。
     *
     * @param page ,如果为null，则从第一页开始查询。
     * @param map  封装了参数的map
     * @return page
     */
    public Pager<Map<String, Object>> findByFieldsPage(Pager<Map<String, Object>> page, Map<String, Object> map);

    /**
     * 查询数据条数<br/>
     *
     * @param sql  查询的sql语句
     * @param list 参数对象，必须和sql语句中的占位符“？”顺序一一对应。
     * @return 查询总条数
     */
    public int queryCount(String sql, List<Object> list);

    /**
     * 查询数据条数，查询语句不能是select count(*) ... ，而是正常的查询语句，可自动统计查询条数。<br/>
     *
     * @param sql  查询的sql语句
     * @param list 参数对象，必须和sql语句中的占位符“？”顺序一一对应。
     * @return 查询总条数
     */
    public int queryCount(String sql, Object... values);

    /**
     * 根据参数查询该对象的条数
     *
     * @param map
     * @return
     */
    public int queryCount(Map<String, Object> map);

    /**
     * 查询单个整数，一般用于查询数据条数。
     *
     * @param sql
     * @param list 参数对象，必须和sql语句中的占位符“？”顺序一一对应。
     * @return Integer 值
     */
    public int queryInteger(String sql, Object... values);

    /**
     * 根据SQL语句和参数对象来查询数据，可查询任意表。
     * TODO未测试
     *
     * @param sql
     * @param Object... objs 可以为null or new Object[]{"p1","p2"}
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> findBySQL(String sql, Object... objs);

    /**
     * 根据SQL语句和参数对象来查询数据，只可查询当前对象映射表。
     *
     * @param sql
     * @param objs 查询参数:可以为null or new Object[]{"p1","p2"}
     * @return
     */
    public List<T> findObjsBySQL(String sql, Object... objs);

    /**
     * 根据SQL语句和参数对象来查询数据，且只返回第一条数据，只可查询当前对象映射表。
     *
     * @param sql
     * @param objs:可以为null or new Object[]{"p1","p2"}
     * @return
     */
    public T findObjBySQL(String sql, Object... objs);

    /**
     * 根据SQL语句和参数查询数据，并分页。<br/>
     * 可查询任意表
     *
     * @param sql    查询使用的sql语句。sql不能包含limit语句。
     * @param values 参数对象
     * @param page   分页信息
     * @return 分页数据
     */
    public Pager<Map<String, Object>> findBySQLPage(final String sql, List<Object> values, Pager<Map<String, Object>> page);

    /**
     * 根据SQL语句和参数查询数据，并分页。<br/>
     * 注意：只能查询当前对象映射的表。
     *
     * @param sql
     * @param page
     * @param values
     * @return
     */
    public Pager<T> findObjsBySQLPage(final String sql, Pager<T> page, Object... values);

    /**
     * 根据主键获取一组对象。<br/>
     *
     * @param ids 主键集合
     * @return List<T>
     * 注意：返回对象的顺序和参数的顺序无关。
     */
    public List<T> findObjsByIds(Collection<? extends Object> ids);


    /**
     * 增加一个对象，并把增加后的对象返回，这样是要主键信息
     * @param t
     * @return
     */
    T saveReturnEntity(T t);

    /**
     * 返回插入数据的主键值toString后的值
     * @param map
     * @return
     */
    String saveReturnPrimary(Map<String, Object> map);

    /**
     * 保存实体，参数为对象
     * 要求被保存对象T 值为“TID”的属性，对应的值不能为null。否则会报异常。
     *
     * @param t
     * @return void
     */
    public void save(T t);

    /**
     * 保存实体<br/>
     * 要求被保存对象T 值为“TID”的属性，对应的值不能为null。否则会报异常。
     *
     * @param map
     * @return
     */
    public void save(Map<String, Object> map);

    /**
     * 批量保存数据，要求所有数据都是同一张表数据。
     *
     * @param listMap
     */
    public void saveList(List<Map<String, Object>> listMap);

    /**
     * 批量保存实体
     *
     * @param Collection
     */
    public void saveList(Collection<T> coll);

    /**
     * 保存或者更新实体，根据Tid主键值在数据库里是否存在相应数据来选择保存还是更新。<br/>
     * 如果不存在以tid值为主键的数据，则执行增加，否则执行更新
     *
     * @param t
     */
    public void saveOrUpdate(T t);

    /**
     * 更新实体，要求更新的map参数中必须携带键位“TID”的值，否则无法更新。
     *
     * @param map
     * @throws RuntimeExcepiton 如果不map中无“TID”键值对，则会抛出该异常
     */
    public void update(Map<String, Object> map);

    /**
     * 更新实体，要求更新的实体属性TID不能为空，否则无法更新。
     * 默认不更新null值。
     *
     * @param t
     * @throws RuntimeExcepiton 如果实体中无“TID”属性值，则会抛出该异常
     */
    public void update(T t);

    /**
     * 更新实体，要求更新的实体属性TID不能为空，否则无法更新。
     *
     * @param t                                                   需要更新的实体。
     * @param isUpdateNull，是否更新null值。true，更新null值；false，不更新null值。
     * @throws RuntimeExcepiton 如果map中无“TID”键值对，则会抛出该异常
     */
    public void update(T t, Boolean isUpdateNull);

    /**
     * 根据TID删除实体
     *
     * @param TID
     */
    public int deleteById(String TID);

    /**
     * 根据键值对删除数据，如果键值对中包含以“tid”为键的键值对，则直接根据该tid删除数据
     *
     * @param map
     */
    public int delete(Map<String, Object> map);

    /**
     * 执行更新或者删除等非查询sql语句,
     *
     * @param sql   sql语句
     * @param param 参数
     * @return 影响的数据库行数
     */
    public int executeUpdate(String sql, Object... param);

    /**
     * 对象转换为Map函数。
     *
     * @param t
     * @return
     */
    public Map<String, Object> object2Map(T t);

    /**
     * map转换为object bo类实例
     *
     * @param map
     * @return
     */
    public T map2Object(Map<String, Object> map);

    /**
     * 获取主键在数据库表中的字段名
     *
     * @return
     */
    public String getPrimary();

    /**
     * 获取该实体对应的表名称
     *
     * @return
     */
    public String getTableName();
}