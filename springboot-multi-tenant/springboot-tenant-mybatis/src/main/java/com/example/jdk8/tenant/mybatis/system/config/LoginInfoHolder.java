package com.example.jdk8.tenant.mybatis.system.config;


import com.example.jdk8.tenant.mybatis.system.vo.LoginInfo;

/**
 * @author zhaojh
 * @version 1.0
 * @description 存放用户登录标识信息 使用 ThreadLocal的方式实现
 * @date 2025/1/24 下午3:12
 */

public class LoginInfoHolder {

    private static final ThreadLocal<LoginInfo> CONTEXT = new ThreadLocal<>();

    public static void setTenant(LoginInfo loginInfo) {
        CONTEXT.set(loginInfo);
    }

    public static LoginInfo getTenant() {
        return CONTEXT.get();
    }

    /**
     * 使用ThreadLocal 的线程变量 需要用完后调用一次清理 防止内存溢出s
     */
    public static void clear() {
        CONTEXT.remove();
    }
}

