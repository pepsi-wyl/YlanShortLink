package org.ylan.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * @author ylan
 *
 * 数据源配置类
 */

@Configuration
public class DataSourceConfiguration {

    /**
     * 创建 quartz 数据源的配置对象
     */
    @Bean(name = "quartzDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.quartz")
    public DataSourceProperties quartzDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * 创建 MP 数据源的配置对象
     */
    @Bean(name = "mybatisplusDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.mybatisplus")
    public DataSourceProperties mybatisplusDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * 创建 quartz 数据源
     */
    @QuartzDataSource // Quartz数据源
    @Bean(name = "quartzDataSource")
    public DataSource quartzDataSource() {
        DataSourceProperties properties = this.quartzDataSourceProperties();
        return createHikariDataSource(properties);
    }

    /**
     * 创建 MP 数据源
     */
    @Primary         // 主数据源
    @Bean(name = "mybatisPlusDataSource")
    public DataSource mybatisPlusDataSource() {
        DataSourceProperties properties = this.mybatisplusDataSourceProperties();
        return createHikariDataSource(properties);
    }

    /**
     * 创建 HikariDataSource
     */
    private static HikariDataSource createHikariDataSource(DataSourceProperties properties) {
        // 创建 HikariDataSource 对象
        HikariDataSource dataSource = properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
        // 设置数据库连接池名
        if (StringUtils.hasText(properties.getName())) {
            dataSource.setPoolName(properties.getName());
        }
        return dataSource;
    }

}