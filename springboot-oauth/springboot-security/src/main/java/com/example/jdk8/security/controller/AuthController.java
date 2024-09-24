package com.example.jdk8.security.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.jdk8.security.common.result.ResultBody;
import com.example.jdk8.security.entity.UserAuth;
import com.example.jdk8.security.model.vo.UserLoginVo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhaojh
 * @description: 认证控制器
 * @date 2024-09-24
 */

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 用户登录
     *
     * @param loginVo 表单的参数
     * @return 用户的令牌
     */
    @PostMapping(value = "/login")
    public ResultBody<Object> login(@RequestBody UserLoginVo loginVo) {
        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(loginVo.getUsernanme(), loginVo.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        UserAuth userAuth = (UserAuth) authenticate.getPrincipal();
        String jwt = JwtUtil.createJWT(String.valueOf(userAuth.getId()));
        //用户信息
        redisTemplate.opsForValue().set("userId" + userAuth.getId(), JSONObject.toJSONString(userAuth));
        return ResultBody.success(jwt);
    }

    /**
     * 用户注销
     *
     * @return
     */
    @PostMapping(value = "/logout")
    public ResultBody<Object> logout() {
        return ResultBody.success();
    }
}
