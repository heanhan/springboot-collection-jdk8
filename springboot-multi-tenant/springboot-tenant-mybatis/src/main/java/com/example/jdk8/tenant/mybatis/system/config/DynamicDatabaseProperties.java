package com.example.jdk8.tenant.mybatis.system.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.jdk8.tenant.mybatis.system.entity.SysTenantData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaojh
 * @version 1.0
 * @description 数据库的配置文件信息
 * @date 2025/1/24 下午2:38
 */
@Data
@Slf4j
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DynamicDatabaseProperties {

    private String driverClassName;

    private String url;

    private String username;

    private String password;

    private int initialSize;

    private int maxActive;

    private int maxWait;

    private int minIdle;

    private boolean poolPreparedStatements;

    private int maxPoolPreparedStatementPerConnectionSize;

    private String validationQuery;

    private boolean testOnBorrow;

    private boolean testOnReturn;

    private boolean testWhileIdle;

    private int timeBetweenEvictionRunsMillis;

    private String filters;

    private int minEvictableIdleTimeMillis;

    /**
     * 获取租户的数据源默认配置
     *
     * @param tenantDataInfo 租户信息
     * @param isSystem 是否是系统数据源
     * @return com.alibaba.druid.pool.DruidDataSource
     */
    public DruidDataSource getBaseDataSource(SysTenantData tenantDataInfo, boolean isSystem) {
        DruidDataSource dds = new DruidDataSource();
        //判断是不是管理员
        if (isSystem) {
            dds.setUrl(url);
            dds.setUsername(username);
            dds.setPassword(password);
        }else {
            dds.setUrl(tenantDataInfo.getUrl());
            dds.setUsername(tenantDataInfo.getUsername());
            dds.setPassword(tenantDataInfo.getPassword());
        }
        dds.setDriverClassName(driverClassName);
        dds.setInitialSize(initialSize);
        dds.setMaxActive(maxActive);
        dds.setMaxWait(maxWait);
        dds.setMinIdle(minIdle);
        dds.setPoolPreparedStatements(poolPreparedStatements);
        dds.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        dds.setValidationQuery(validationQuery);
        dds.setTestOnBorrow(testOnBorrow);
        dds.setTestOnReturn(testOnReturn);
        dds.setTestWhileIdle(testWhileIdle);
        dds.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        try {
            dds.setFilters(filters);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        dds.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        return dds;
    }

    /**
     * 用户项目启动时候初始化所有数据源
     *
     * @param tenantDataInfoList  所有租户信息
     * @param resolvedDataSources 数据源对象Map集合
     * @return java.util.Map<java.lang.Object, java.lang.Object>
     */
    public Map<Object, Object> initDataSource(List<SysTenantData> tenantDataInfoList, Map<Object, DataSource> resolvedDataSources) {
        Map<Object, Object> targetDataSources = new HashMap<>(resolvedDataSources);
        for (SysTenantData tenantDataInfo : tenantDataInfoList) {
            targetDataSources.put(tenantDataInfo.getTenantId(), getBaseDataSource(tenantDataInfo, false));
        }
        return targetDataSources;
    }
}