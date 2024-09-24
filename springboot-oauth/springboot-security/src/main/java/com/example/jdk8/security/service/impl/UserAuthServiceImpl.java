package com.example.jdk8.security.service.impl;

import com.example.jdk8.security.dao.UserAuthDao;
import com.example.jdk8.security.entity.UserAuth;
import com.example.jdk8.security.service.UserAuthService;
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
public class UserAuthServiceImpl implements UserAuthService {

    @Resource
    private UserAuthDao userAuthDao;

    /**
     * 通过用户名查询库中的用户
     *
     * @param username 用户名/用户帐号
     * @return
     */
    @Override
    public UserAuth findByUsername(String username) {
        UserAuth byUsername = userAuthDao.findByUsername(username);
        return byUsername;
    }
}
