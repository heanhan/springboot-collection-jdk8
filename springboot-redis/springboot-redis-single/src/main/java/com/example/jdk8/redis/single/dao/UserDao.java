package com.example.jdk8.redis.single.dao;


import com.example.jdk8.redis.single.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/2/26 下午2:18
 */

@Repository
public interface UserDao extends JpaRepository<User,Long> , JpaSpecificationExecutor<User> {
}
