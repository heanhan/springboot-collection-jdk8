package com.example.jdk8.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TestApplication
 *
 */
@SpringBootApplication
public class TestApplication implements CommandLineRunner {

    private final JdbcTemplate firstJdbcTemplate;
    private final JdbcTemplate secondJdbcTemplate;

    // Constructor injection to avoid field-based autowiring issues
    public TestApplication(
            @Qualifier("firstJdbcTemplate") JdbcTemplate firstJdbcTemplate,
            @Qualifier("secondJdbcTemplate") JdbcTemplate secondJdbcTemplate) {
        this.firstJdbcTemplate = firstJdbcTemplate;
        this.secondJdbcTemplate = secondJdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 获取第一个数据库的表名
        List<String> firstTables = firstJdbcTemplate.queryForList(
                "SELECT table_name FROM information_schema.tables WHERE table_schema = DATABASE()",
                String.class
        );

        // 获取第二个数据库的表名
        List<String> secondTables = secondJdbcTemplate.queryForList(
                "SELECT table_name FROM information_schema.tables WHERE table_schema = DATABASE()",
                String.class
        );

        // 转换为Set以便进行差集操作
        Set<String> firstTableSet = firstTables.stream().collect(Collectors.toSet());
        Set<String> secondTableSet = secondTables.stream().collect(Collectors.toSet());

        // 计算差集
        Set<String> onlyInFirst = firstTableSet.stream()
                .filter(table -> !secondTableSet.contains(table))
                .collect(Collectors.toSet());

        Set<String> onlyInSecond = secondTableSet.stream()
                .filter(table -> !firstTableSet.contains(table))
                .collect(Collectors.toSet());

        // 输出结果
        System.out.println("只存在于第一个数据库的表：");
        onlyInFirst.forEach(System.out::println);

        System.out.println("\n只存在于第二个数据库的表：");
        onlyInSecond.forEach(System.out::println);
    }

    @Configuration
    static class DataSourceConfig {

        @Bean
        @ConfigurationProperties("spring.datasource.first")
        public DataSourceProperties firstDataSourceProperties() {
            return new DataSourceProperties();
        }

        @Bean
        @ConfigurationProperties("spring.datasource.second")
        public DataSourceProperties secondDataSourceProperties() {
            return new DataSourceProperties();
        }

        @Bean
        public DataSource firstDataSource(DataSourceProperties firstDataSourceProperties) {
            return firstDataSourceProperties.initializeDataSourceBuilder().build();
        }

        @Bean
        public DataSource secondDataSource(DataSourceProperties secondDataSourceProperties) {
            return secondDataSourceProperties.initializeDataSourceBuilder().build();
        }

        @Bean
        public JdbcTemplate firstJdbcTemplate(@Qualifier("firstDataSource") DataSource firstDataSource) {
            return new JdbcTemplate(firstDataSource);
        }

        @Bean
        public JdbcTemplate secondJdbcTemplate(@Qualifier("secondDataSource") DataSource secondDataSource) {
            return new JdbcTemplate(secondDataSource);
        }
    }
}
