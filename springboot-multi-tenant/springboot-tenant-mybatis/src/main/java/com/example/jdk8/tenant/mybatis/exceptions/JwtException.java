package com.example.jdk8.tenant.mybatis.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author : zhaojh
 * @Date: 2025-01-20
 * @Description : jwt异常
 */
public class JwtException extends AuthenticationException {

    private Integer code;

    public JwtException() {
        super("认证操作异常");
    }

    public JwtException(String message) {
        super(message);
        //todo 需要使用枚举进行修改
        this.code = 401;
    }

    public JwtException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
