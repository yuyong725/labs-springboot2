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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author 余勇
 * @date 2020-01-10 20:12
 *
 */
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = DBConstants.ENTITY_MANAGER_FACTORY_USERS,
        transactionManagerRef = DBConstants.TX_MANAGER_USERS,
        basePackages = {"cn.javadog.labs.springboot2.datasource.dynamic.jpa.repository.users"})
public class JpaUsersConfig {

    @Resource(name = "hibernateVendorProperties")
    private Map<String, Object> hibernateVendorProperties;

    /**
     * 创建 users 数据源
     */
    @Bean(name = "usersDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.users")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 创建 LocalContainerEntityManagerFactoryBean
     */
    @Bean(name = DBConstants.ENTITY_MANAGER_FACTORY_USERS)
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
            // 数据源
            .dataSource(this.dataSource())
            // 获取并注入 Hibernate Vendor 相关配置
            .properties(hibernateVendorProperties)
            // 数据库实体 entity 所在包
            .packages("cn.javadog.labs.springboot2.datasource.dynamic.jpa.dataobject")
            // 设置持久单元的名字，需要唯一
            .persistenceUnit("usersPersistenceUnit")
            .build();
    }

    /**
     * 创建 PlatformTransactionManager
     */
    @Bean(name = DBConstants.TX_MANAGER_USERS)
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactory(builder).getObject());
    }

}
