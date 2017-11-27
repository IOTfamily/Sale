package com.iot.sale.Base.dao.annotation;

/**
 * 封装一个javaBo属性和列之间的映射关系
 */
public class BoColumn {

    //数据库字段名
    private String name;

    //被映射的java类型
    private int javaType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJavaType() {
        return javaType;
    }

    public void setJavaType(int javaType) {
        this.javaType = javaType;
    }

}
