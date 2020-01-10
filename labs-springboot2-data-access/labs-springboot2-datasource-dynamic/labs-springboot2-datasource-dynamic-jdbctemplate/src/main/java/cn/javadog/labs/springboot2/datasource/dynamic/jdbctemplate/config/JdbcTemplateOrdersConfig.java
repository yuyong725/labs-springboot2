package cn.javadog.labs.springboot2.datasource.dynamic.jdbctemplate.config;

import javax.sql.DataSource;

import cn.javadog.labs.springboot2.datasource.dynamic.jdbctemplate.constant.DBConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author 余勇
 * @date 2020-01-10 20:53
 */
@Configuration
public class JdbcTemplateOrdersConfig {

    /**
     * 创建 orders 数据源
     */
    @Bean(name = "ordersDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.orders")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 创建 orders JdbcTemplate
     */
    @Bean(name = DBConstants.JDBC_TEMPLATE_ORDERS)
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(this.dataSource());
    }

    /**
     * 创建 orders 数据源的 TransactionManager 事务管理器
     */
    @Bean(name = DBConstants.TX_MANAGER_ORDERS)
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(this.dataSource());
    }

}
