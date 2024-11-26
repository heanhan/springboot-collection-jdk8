package com.example.jdk8.oauth2.repository;

import com.example.jdk8.oauth2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description : TODO
 * @Author : zhaojh
 * @Date : 2024/11/23 09:17
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
