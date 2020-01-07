package cn.javadog.labs.springboot2.hikaricp.multiple;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 余勇
 * @date 2020-01-07 19:07
 * 多数据源 Hikaricp 启动类
 */
@SpringBootApplication
public class HikaricpMultipleApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(HikaricpMultipleApplication.class);

    @Resource(name = "ordersDataSource")
    private DataSource ordersDataSource;

    @Resource(name = "usersDataSource")
    private DataSource usersDataSource;

    public static void main(String[] args) {
        // 启动 Spring Boot 应用
        SpringApplication.run(HikaricpMultipleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // orders 数据源
        try (Connection conn = ordersDataSource.getConnection()) {
            // 这里，可以做点什么
            logger.info("[run][ordersDataSource 获得连接：{}]", conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // users 数据源
        try (Connection conn = usersDataSource.getConnection()) {
            // 这里，可以做点什么
            logger.info("[run][usersDataSource 获得连接：{}]", conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
