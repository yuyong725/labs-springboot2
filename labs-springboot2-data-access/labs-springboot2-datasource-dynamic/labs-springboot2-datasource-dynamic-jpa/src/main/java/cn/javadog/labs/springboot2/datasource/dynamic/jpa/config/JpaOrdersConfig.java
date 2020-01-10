package cn.javadog.labs.springboot2.datasource.dynamic.jpa.config;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Map;

import cn.javadog.labs.springboot2.datasource.dynamic.jpa.constant.DBConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author 余勇
 * @date 2020-01-10 20:05
 */
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = DBConstants.ENTITY_MANAGER_FACTORY_ORDERS,
        transactionManagerRef = DBConstants.TX_MANAGER_ORDERS,
        basePackages = {"cn.javadog.labs.springboot2.datasource.dynamic.jpa.repository.orders"})
public class JpaOrdersConfig {

    @Resource(name = "hibernateVendorProperties")
    private Map<String, Object> hibernateVendorProperties;

    /**
     * 创建 orders 数据源
     *  @Primary 需要特殊添加，否则初始化会有问题
     */
    @Bean(name = "ordersDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.orders")
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 创建 LocalContainerEntityManagerFactoryBean
     */
    @Bean(name = DBConstants.ENTITY_MANAGER_FACTORY_ORDERS)
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
            // 数据源
            .dataSource(this.dataSource())
            // 获取并注入 Hibernate Vendor 相关配置
            .properties(hibernateVendorProperties)
            // 数据库实体 entity 所在包
            .packages("cn.javadog.labs.springboot2.datasource.dynamic.jpa.dataobject")
            // 设置持久单元的名字，需要唯一
            .persistenceUnit("ordersPersistenceUnit")
            .build();
    }

    /**
     * 创建 PlatformTransactionManager
     */
    @Bean(name = DBConstants.TX_MANAGER_ORDERS)
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactory(builder).getObject());
    }

}
