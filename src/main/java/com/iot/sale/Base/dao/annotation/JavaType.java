package com.iot.sale.Base.dao.annotation;

/**
 * 定义了和数据库之间映射的java类型
 */
public class JavaType {

    //字符类型 char vchar text
    public static final int STRING = 1;
    //int类型 int
    public static final int INTEGER = 2;
    //长整形 long
    public static final int LONG = 3;
    //浮点型
    public static final int DECIMAL = 4;
    //日期
    public static final int DATE = 5;
    //时间戳
    public static final int TIMESTAMP = 6;
    //布尔值类型
    public static final int BOOLEAN = 7;
}
