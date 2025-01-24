package com.example.jdk8.tenant.mybatis.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.jdk8.tenant.mybatis.system.entity.SysUser;
import com.example.jdk8.tenant.mybatis.system.mapper.SysUserMapper;
import com.example.jdk8.tenant.mybatis.system.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements SysUserService {

    @Resource
    private SysUserMapper userMapper;


}