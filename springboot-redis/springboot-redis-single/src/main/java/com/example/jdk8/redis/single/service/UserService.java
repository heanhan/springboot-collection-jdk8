package com.example.jdk8.redis.single.service;

import com.example.jdk8.redis.single.entity.User;

/**
 * @Description : 用户接口
 * @Author : zhaojh
 * @Date : 2025/2/17 14:32
 */

public interface UserService {

    /**
     * 新增用户
     * @return User
     */
    User addUser(User user );
}
