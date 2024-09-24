package com.example.jdk8.security.service.impl;

import com.example.jdk8.security.dao.UserInfoDao;
import com.example.jdk8.security.entity.UserInfo;
import com.example.jdk8.security.service.UserInfoService;
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

}
