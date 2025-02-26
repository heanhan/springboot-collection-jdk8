package com.example.jdk8.redis.single.service.impl;

import com.example.jdk8.redis.single.dao.UserDao;
import com.example.jdk8.redis.single.entity.User;
import com.example.jdk8.redis.single.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description : TODO
 * @Author : zhaojh
 * @Date : 2025/2/17 14:32
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    /**
     * 新增用户
     *
     * @return User
     */
    @Override
    public User addUser(User user) {
        User save = userDao.save(user);
        return save;
    }
}
