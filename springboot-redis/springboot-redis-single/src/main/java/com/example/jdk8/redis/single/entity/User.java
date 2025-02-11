package com.example.jdk8.redis.single.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description : TODO
 * @Author : zhaojh
 * @Date : 2025/2/11 17:26
 */

@Data
public class User implements Serializable {

    /**
     * id.
     */
    private Long id;

    /**
     * 姓名
     */
    private String userName;

    //性别
    private Boolean sex;

    //身高
    private Long height;

    //爱好
    private List<String> hobby;
}
