package com.iot.sale.Base.dao.annotation;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 封装一个bo和表之间的映射关系
 */
public class BoTable {

    //表名
    private String name;
    //主键字段名称
    private String pk;
    //字段映射关系。键为BO属性名，值为数据库字段值
    private Map<String, BoColumn> columnMap;
    //属性对应的Field反射对象,一级缓存。键为BO属性名，值为反射后的Field对象。
    private Map<String, Field> fieldMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public Map<String, BoColumn> getColumnMap() {
        return columnMap;
    }

    public void setColumnMap(Map<String, BoColumn> columnMap) {
        this.columnMap = columnMap;
    }

    public Map<String, Field> getFieldMap() {
        return fieldMap;
    }

    public void setFieldMap(Map<String, Field> fieldMap) {
        this.fieldMap = fieldMap;
    }

}
