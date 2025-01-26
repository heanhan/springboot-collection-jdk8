package com.example.jdk8.tenant.mybatis.system.config;


import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.example.jdk8.tenant.mybatis.common.constants.SystemConstant;
import lombok.ToString;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author zhaojh
 * @version 1.0
 * @description 数据源的配置
 * @date 2025/1/24 下午2:58
 */
@ToString
@Configuration
@EnableConfigurationProperties(value=DynamicDatabaseProperties.class)
public class DynamicDatabaseConfiguration {

    //通过构造方法进行构建
    private static DynamicDatabaseProperties dynamicDatabaseProperties;

    private DynamicDatabaseConfiguration (DynamicDatabaseProperties dynamicDatabaseProperties){
        this.dynamicDatabaseProperties =dynamicDatabaseProperties;
    }

    /**
     * 设置数据源，默认一个系统数据源
     *
     * @return javax.sql.DataSource
     */
    @Bean
    @Primary
    public DataSource multipleDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = CollectionUtils.newHashMap(1);
        targetDataSources.put(SystemConstant.ROOT_PARENT_ID, systemDataSource());
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(systemDataSource());
        return dynamicDataSource;
    }

    /**
     * 系统数据源，也是默认数据源。连接的是系统数据库，系统数据源必须先加载，才能获取租户的连接信息
     *
     * @return javax.sql.DataSource
     */
    @Bean
    @Primary
    public DataSource systemDataSource() {
        return dynamicDatabaseProperties.getBaseDataSource(null, true);
    }

    /**
     * @description: 定义一个mybatis的SqlSessionFaction的工厂
     * @date: 2025/1/24
     **/
    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(multipleDataSource());
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        sqlSessionFactory.setConfiguration(configuration);
        return sqlSessionFactory.getObject();
    }

    /**
     * @description: 默认一个主数据源的事务管理器
     * @date: 2025/1/24
     * @param: dataSource
     **/
    @Bean(name = "multipleTransactionManager")
    @Primary
    public DataSourceTransactionManager multipleTransactionManager(@Qualifier("multipleDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    //
    public void initDatabase() {

    }
}
