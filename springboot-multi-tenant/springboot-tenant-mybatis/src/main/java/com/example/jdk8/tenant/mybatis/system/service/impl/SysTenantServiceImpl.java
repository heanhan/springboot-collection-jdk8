package com.example.jdk8.tenant.mybatis.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.jdk8.tenant.mybatis.system.entity.SysTenant;
import com.example.jdk8.tenant.mybatis.system.mapper.SysTenantMapper;
import com.example.jdk8.tenant.mybatis.system.service.SysTenantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SysTenantServiceImpl extends ServiceImpl<SysTenantMapper, SysTenant> implements SysTenantService {

}