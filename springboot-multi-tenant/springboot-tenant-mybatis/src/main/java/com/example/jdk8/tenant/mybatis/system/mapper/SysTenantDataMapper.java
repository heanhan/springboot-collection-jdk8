package com.example.jdk8.tenant.mybatis.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.jdk8.tenant.mybatis.system.entity.SysTenantData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysTenantDataMapper extends BaseMapper<SysTenantData> {
    int deleteByPrimaryKey(Integer id);

    int insert(SysTenantData record);

    int insertSelective(SysTenantData record);

    SysTenantData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysTenantData record);

    int updateByPrimaryKey(SysTenantData record);
}