package com.example.jdk8.jwt.service.impl;

import com.example.jdk8.jwt.entity.UserAuth;
import com.example.jdk8.jwt.service.UserAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @author zhaojh
 * @description: 实现security的UserDetailService接口实现通过用户名查询用户
 * @date 2024-09-24
 */
@Slf4j
@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private BCryptPasswordEncoder encoderPassword;

    @Resource
    private UserAuthService userAuthService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("账号：{} ->开始认证",username);
        UserAuth userAuth = userAuthService.findByUsername(username);
        // 查询不到用户信息则抛出异常
        if (ObjectUtils.isEmpty(userAuth)) {
            throw new RuntimeException("用户名或密码有误");
        }
        // TODO 在授权时返回此处。 根据用户查询权限信息，再添加到 LoginUser 中。
        return userAuth;
    }
}
