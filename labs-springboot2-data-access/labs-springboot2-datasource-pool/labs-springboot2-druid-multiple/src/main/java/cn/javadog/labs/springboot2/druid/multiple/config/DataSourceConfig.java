package cn.javadog.labs.springboot2.druid.multiple.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
 * @author 余勇
 * @date 2020-01-07 21:26
 * 多数据源配置
 */
@Configuration
public class DataSourceConfig {

    /**
     * 创建 orders 数据源
     * 读取 spring.datasource.orders 配置到 HikariDataSource 对象
     */
    @Primary
    @Bean(name = "ordersDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.orders")
    public DataSource ordersDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 创建 users 数据源
     */
    @Bean(name = "usersDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.users")
    public DataSource usersDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

}
