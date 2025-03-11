package com.example.jdk8.oauth2.service;

import com.example.jdk8.oauth2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description : 用户的实现层
 * @Author : zhaojh
 * @Date : 2025/3/11 14:30
 */


public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    User findByUsername(String username);
}