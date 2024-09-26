package com.example.jdk8.simple.service.impl;

import com.example.jdk8.simple.dao.UserInfoDao;
import com.example.jdk8.simple.entity.UserInfo;
import com.example.jdk8.simple.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author zhaojh
 * @description: TODO
 * @date 2024-09-24
 */
@Slf4j
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    /**
     * 根据id 查询用户的详情
     *
     * @param userInfoId
     * @return
     */
    @Override
    public UserInfo findUserInfoById(Integer userInfoId) {
        return userInfoDao.findById(userInfoId).orElse(null);
    }
}
