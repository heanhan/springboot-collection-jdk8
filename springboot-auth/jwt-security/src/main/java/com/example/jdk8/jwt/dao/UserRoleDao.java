package com.example.jdk8.jwt.dao;

import com.example.jdk8.jwt.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.annotation.Resource;

/**
 * @author zhaojh
 * @description: TODO
 * @date 2024-09-24
 */
@Resource
public interface UserRoleDao extends JpaRepository<UserRole, Long> , JpaSpecificationExecutor<UserRole> {
}
