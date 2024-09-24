package com.example.jdk8.security.controller;

import com.example.jdk8.security.common.result.ResultBody;
import com.example.jdk8.security.model.vo.UserLoginVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaojh
 * @description: TODO
 * @date 2024-09-24
 */

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    /**
     * 用户登录
     * @param loginVo 表单的参数
     * @return 用户的令牌
     */
    @PostMapping(value = "/login")
    public ResultBody<Object> login(@RequestBody UserLoginVo loginVo) {
        return ResultBody.success();
    }

    /**
     * 用户注销
     * @return
     */
    @PostMapping(value = "/logout")
    public ResultBody<Object> logout() {
        return ResultBody.success();
    }
}
