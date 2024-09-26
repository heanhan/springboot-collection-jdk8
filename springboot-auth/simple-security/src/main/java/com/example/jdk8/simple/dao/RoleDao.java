package com.example.jdk8.simple.dao;


import com.example.jdk8.simple.entity.Role;
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
public interface RoleDao extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {

    /**
     * 根据用户id 查询角色菜单
     * @param userInfoId user_info 表中的id
     * @return
     */
    @Query(value = " select r* " +
            " from role r "+
            " left join  user_role ur on r.id=ur.role_id " +
            " left join user_info u on u.id=ur.user_id " +
            " left join role_menu rm on rm.role_id=r.id " +
            " left join menu m on m.id=rm.menu_id " +
            " where u.id=?1" )
    List<Role> findRolesByUserInfoId(Integer userInfoId);
}
