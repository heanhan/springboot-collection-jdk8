package com.example.jdk8.tenant.mybatis.system.config;

import com.example.jdk8.tenant.mybatis.system.vo.DataSourceType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义的一个注解  标志该类的租户属性
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyDataSource {

    /**
     * 数据源key
     */
    DataSourceType type() default DataSourceType.SYSTEM;

    int value() default 0;
}
