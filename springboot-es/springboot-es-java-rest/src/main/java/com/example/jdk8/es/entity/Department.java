package com.example.jdk8.es.entity;


import lombok.Data;

import java.util.List;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/1/16 上午10:01
 */
@Data
public class Department {
    //名称
    private String name;

    private List<Employees> employees;

}
