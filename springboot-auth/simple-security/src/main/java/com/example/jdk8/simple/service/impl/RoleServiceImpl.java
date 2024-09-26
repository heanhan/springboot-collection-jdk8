package com.example.jdk8.simple.service.impl;

import com.example.jdk8.simple.dao.RoleDao;
import com.example.jdk8.simple.entity.Role;
import com.example.jdk8.simple.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhaojh
 * @description: TODO
 * @date 2024-09-24
 */
@Slf4j
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;
    /**
     * 根据用户获取角色
     *
     * @param userInfoId 用户id
     * @return
     */
    @Override
    public List<Role> findRolesByUserInfoId(Integer userInfoId) {
        List<Role> rolesByUserInfoId = roleDao.findRolesByUserInfoId(userInfoId);
        return roleDao.findRolesByUserInfoId(userInfoId);
    }
}