package com.example.jdk8.simple.service.impl;

import com.example.jdk8.simple.entity.Role;
import com.example.jdk8.simple.entity.UserAuth;
import com.example.jdk8.simple.entity.UserInfo;
import com.example.jdk8.simple.service.RoleService;
import com.example.jdk8.simple.service.UserAuthService;
import com.example.jdk8.simple.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private UserAuthService userAuthService;

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("账号：{} ->开始认证",username);
        UserAuth userAuth = userAuthService.findByUsername(username);
        // 查询不到用户信息则抛出异常
        if (ObjectUtils.isEmpty(userAuth)) {
            throw new RuntimeException("用户名或密码有误");
        }
        // TODO 在授权时返回此处。 根据用户查询权限信息，再添加到 LoginUser 中。
        //查询用户信息  user_info
        UserInfo userInfo = userInfoService.findUserInfoById(userAuth.getUserInfoId());
        if (ObjectUtils.isEmpty(userInfo)) {
            throw new RuntimeException("用户名信息不存在");
        }
        // 查询账号角色和菜单
        List<Role> roleList = roleService.findRolesByUserInfoId(userInfo.getId());
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : roleList) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            role.setMenuList();
        }
        userAuth.setAthorities(grantedAuthorities);
        return userAuth;
    }

}
