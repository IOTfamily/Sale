package com.iot.sale.Base.dao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表名注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Table {
    //表名，注意区分大小写
    String name() default "";

    //主键字段名,值为java中Entity的属性名称
    String pk() default "";
}

