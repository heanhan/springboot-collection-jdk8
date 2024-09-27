package com.example.jdk8.simple.service.impl;

import com.example.jdk8.simple.dao.MenuDao;
import com.example.jdk8.simple.entity.Menu;
import com.example.jdk8.simple.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author zhaojh
 * @description: 菜单的实现层
 * @date 2024-09-24
 */

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDao menuDao;
    /**
     * 根据角色id 查询关联的用户菜单
     *
     * @param id 角色id
     * @return 菜单列表
     */
    @Override
    public List<Menu> findMenuByRoleId(Integer id) {
        List<Menu> menus = menuDao.findMenuByRoleId(id);
        return Optional.of(menus).orElse(null);
    }
}
