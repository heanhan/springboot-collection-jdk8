package com.example.jdk8.simple.service;

import com.example.jdk8.simple.entity.Role;

import java.util.List;

/**
 * @author zhaojh
 * @description: TODO
 * @date 2024-09-24
 */
public interface RoleService {

    /**
     * 根据用户获取角色
     * @param id 用户id
     * @return
     */
    List<Role> findRolesByUserInfoId(Integer id);
}
