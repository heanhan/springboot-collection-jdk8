package com.example.jdk8.simple.dao;


import com.example.jdk8.simple.entity.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author zhaojh
 * @description: TODO
 * @date 2024-09-24
 */
@Repository
public interface RoleMenuDao extends JpaRepository<RoleMenu, Integer>, JpaSpecificationExecutor<RoleMenu> {
}
