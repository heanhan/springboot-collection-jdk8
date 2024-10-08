package com.example.jdk8.jwt.dao;

import com.example.jdk8.jwt.entity.RoleResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author zhaojh
 * @description: TODO
 * @date 2024-09-24
 */
@Repository
public interface RoleResourceDao extends JpaRepository<RoleResource, Integer> , JpaSpecificationExecutor<RoleResource> {
}
