package cn.javadog.labs.springboot2.druid.single;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 余勇
 * @date 2020-01-07 19:28
 * 启动类
 */
@SpringBootApplication
public class DruidSingleApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(DruidSingleApplication.class);

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        // 启动 Spring Boot 应用
        SpringApplication.run(DruidSingleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("[run][获得数据源：{}]", dataSource.getClass());
    }

}
