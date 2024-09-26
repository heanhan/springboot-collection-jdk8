package com.example.jdk8.jwt.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description : 用户注册
 * @Author : zhaojh
 * @Date : 2024/9/24 22:34
 */
@Data
public class RegisterUserVo implements Serializable {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
