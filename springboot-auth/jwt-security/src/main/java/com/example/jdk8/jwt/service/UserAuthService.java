package com.example.jdk8.jwt.service;

import com.example.jdk8.jwt.entity.UserAuth;
import com.example.jdk8.jwt.model.vo.RegisterUserVo;

/**
 * @author zhaojh
 * @description: TODO
 * @date 2024-09-24
 */

public interface UserAuthService {

    /**
     * 通过用户名查询库中的用户
     * @param username 用户名/用户帐号
     * @return
     */
    UserAuth findByUsername(String username);

    /**
     * 用户注册
     * @param registerUserVo
     * @return
     */
    Boolean registerUser(RegisterUserVo registerUserVo);
}
