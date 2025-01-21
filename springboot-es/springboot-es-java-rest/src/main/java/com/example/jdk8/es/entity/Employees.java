package com.example.jdk8.es.entity;


import lombok.Data;

/**
 * @author zhaojh
 * @version 1.0
 * @description 雇员
 * @date 2025/1/16 上午10:02
 */
@Data
public class Employees {
    //姓名
    private String name;
    //年龄
    private Integer age;
    //性别
    private String gender;
    //职位
    private String position;
}
