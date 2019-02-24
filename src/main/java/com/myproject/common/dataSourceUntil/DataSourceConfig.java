package com.myproject.common.dataSourceUntil;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan("com.myproject.dao.mybatis")
public class DataSourceConfig {

    @Bean(name = "masterDataSource")
    @Qualifier("masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "readOnlyDataSource")
    @Qualifier("readOnlyDataSource")
    @ConfigurationProperties(prefix = "custom.datasource.readonly")
    public DataSource readOnlyDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource());
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap();
        dsMap.put("master", masterDataSource());
        dsMap.put("readonly", readOnlyDataSource());
        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }

    /**
     * 配置@Transactional注解事物
     * 使用dynamicDataSource作为transactionManager的入参来构造DataSourceTransactionManager
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }

}
