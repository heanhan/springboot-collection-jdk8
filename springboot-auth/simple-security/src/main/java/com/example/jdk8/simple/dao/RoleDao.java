package com.example.jdk8.simple.dao;


import com.example.jdk8.simple.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaojh
 * @description: 角色持久层
 * @date 2024-09-24
 */
@Repository
public interface RoleDao extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {

    /**
     * 根据用户id 查询角色菜单
     * @param userInfoId user_info 表中的id
     * @return
     */
    @Query(value = " select  r from Role r "+
            " left join  UserRole ur on r.id=ur.roleId " +
            " left join UserInfo u on u.id=ur.userId " +
            " where u.id=?1" )
    List<Role> findRolesByUserInfoId(Integer userInfoId);
}
