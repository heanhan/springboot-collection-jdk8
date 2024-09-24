package com.example.jdk8.security.service.impl;

import com.example.jdk8.security.entity.UserAuth;
import com.example.jdk8.security.service.UserAuthService;
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
        if(ObjectUtils.isEmpty(userAuth)){
            //如果用户存在且有效

        }
        return null;
    }
}
