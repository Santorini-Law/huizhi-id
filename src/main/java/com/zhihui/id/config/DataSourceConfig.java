package com.zhihui.id.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author LDZ
 * @date 2020-03-08 10:42
 */
@Configuration
public class DataSourceConfig {


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource mySqlDataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}
