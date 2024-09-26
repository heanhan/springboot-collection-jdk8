package com.example.jdk8.simple.service;

import com.example.jdk8.simple.entity.UserInfo;

/**
 * @author zhaojh
 * @description: TODO
 * @date 2024-09-24
 */
public interface UserInfoService {


    /**
     * 根据id 查询用户的详情
     * @param userInfoId
     * @return
     */
    UserInfo findUserInfoById(Integer userInfoId);
}
