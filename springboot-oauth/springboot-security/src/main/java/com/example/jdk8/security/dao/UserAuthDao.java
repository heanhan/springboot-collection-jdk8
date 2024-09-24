package com.example.jdk8.security.dao;

import com.example.jdk8.security.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author zhaojh
 * @description: TODO
 * @date 2024-09-24
 */
@Repository
public interface UserAuthDao extends JpaRepository<UserAuth, Integer> , JpaSpecificationExecutor<UserAuth> {

    /**
     * 通过用户名称查询用户信息
     * @param username 用户名即也是用户帐号 库中是唯一
     * @return 如果存在返回单个用户信息，否则返回null
     */
    @Query(value = "from UserAuth a where a.username =?1")
    UserAuth findByUsername(String username);

}
