package com.example.jdk8.tenant.mybatis.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.jdk8.tenant.mybatis.system.entity.SysRole;
import com.example.jdk8.tenant.mybatis.system.mapper.SysRoleMapper;
import com.example.jdk8.tenant.mybatis.system.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper,SysRole> implements SysRoleService {

}