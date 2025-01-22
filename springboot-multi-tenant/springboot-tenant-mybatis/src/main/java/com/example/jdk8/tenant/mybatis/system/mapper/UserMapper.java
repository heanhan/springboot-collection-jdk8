package com.example.jdk8.tenant.mybatis.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.jdk8.tenant.mybatis.system.entity.User;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系統用戶表 Mapper 接口
 * </p>
 *
 * @author zhaojh
 * @since 2025-01-22
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 更加用户id获取用户详细信息
     *
     * @param userId id
     * @return java.util.Map<java.lang.String, java.lang.Object>
     */
    Map<String, Object> getUserDetailById(Integer userId);

    /**
     * 获取租户或经销商所有指定角色类型的用户数据
     *
     * @param tenantId   租户id
     * @param operatorId 经销商ID
     * @param roleType   角色类型
     * @return java.util.List<cn.greenbon.api.business.system.bean.User>
     */
    List<User> listUserByRoleType(Integer tenantId, Integer operatorId, Integer roleType);

    /**
     * 获取租户或经销商所有指定用户类型的用户数据
     *
     * @param tenantId   租户id
     * @param operatorId 经销商ID
     * @param userType   用户类型
     * @return java.util.List<cn.greenbon.api.business.system.bean.User>
     */
    List<User> listUserByType(Integer tenantId, Integer operatorId, Integer userType);
}
