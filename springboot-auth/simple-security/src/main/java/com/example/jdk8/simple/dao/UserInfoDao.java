package com.example.jdk8.simple.dao;


import com.example.jdk8.simple.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.annotation.Resource;

/**
 * @author zhaojh
 * @description: TODO
 * @date 2024-09-24
 */
@Resource
public interface UserInfoDao extends JpaRepository<UserInfo, Integer>, JpaSpecificationExecutor<UserInfo> {


}
