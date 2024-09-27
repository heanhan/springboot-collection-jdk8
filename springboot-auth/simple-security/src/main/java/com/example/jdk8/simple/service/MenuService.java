package com.example.jdk8.simple.service;

import com.example.jdk8.simple.entity.Menu;

import java.util.List;

/**
 * @author zhaojh
 * @description: TODO
 * @date 2024-09-24
 */
public interface MenuService {

    /**
     * 根据角色id 查询关联的用户菜单
     * @param id 角色id
     * @return 菜单列表
     */
    List<Menu> findMenuByRoleId(Integer id);
}
