package com.example.jdk8.tenant.mybatis.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.jdk8.tenant.mybatis.system.entity.SysTenantData;
import com.example.jdk8.tenant.mybatis.system.mapper.SysTenantDataMapper;
import com.example.jdk8.tenant.mybatis.system.service.SysTenantDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SysTenantDataServiceImpl extends ServiceImpl<SysTenantDataMapper, SysTenantData> implements SysTenantDataService {

}