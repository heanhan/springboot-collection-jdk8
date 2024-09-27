package com.example.jdk8.simple.dao;

import com.example.jdk8.simple.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaojh
 * @description: TODO
 * @date 2024-09-24
 */
@Repository
public interface MenuDao extends JpaRepository<Menu, Integer>, JpaSpecificationExecutor<Menu> {

    /**
     * 根据角色id 查询用户的菜单
     * @param id 角色id
     * @return 菜单列表
     */
    @Query(value = "select  m from Menu m " +
            " left join RoleMenu rm on m.id= rm.menuId " +
            " left join Role r on r.id = rm.roleId " +
            " where  r.id =?1 ")
    List<Menu> findMenuByRoleId(Integer id);
}
