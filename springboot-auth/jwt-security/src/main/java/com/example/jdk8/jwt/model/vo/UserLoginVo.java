package com.example.jdk8.jwt.model.vo;

import lombok.Data;

/**
 * @author zhaojh
 * @description: 用户自定义的登录vo
 * @date 2024-09-24
 */
@Data
public class UserLoginVo {

    private String username;

    private String password;
}
