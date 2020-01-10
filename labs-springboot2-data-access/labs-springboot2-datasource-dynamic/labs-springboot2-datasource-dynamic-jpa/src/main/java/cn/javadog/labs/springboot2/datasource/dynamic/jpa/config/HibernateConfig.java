package cn.javadog.labs.springboot2.datasource.dynamic.jpa.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 余勇
 * @date 2020-01-10 20:05
 */
@Configuration
public class HibernateConfig {

    @Autowired
    private JpaProperties jpaProperties;
    @Autowired
    private HibernateProperties hibernateProperties;

    /**
     * 获取 Hibernate Vendor 相关配置
     */
    @Bean(name = "hibernateVendorProperties")
    public Map<String, Object> hibernateVendorProperties() {
        return hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(), new HibernateSettings());
    }

}
