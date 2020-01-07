package cn.javadog.labs.springboot2.hikaricp.single;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 余勇
 * @date 2020-01-07 18:14
 * 启动类
 */
@SpringBootApplication
public class HikaricpSingleApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(HikaricpSingleApplication.class);

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        // 启动 Spring Boot 应用
        SpringApplication.run(HikaricpSingleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try (Connection conn = dataSource.getConnection()) {
            // 这里，可以做点什么
            logger.info("[run][获得连接：{}]", conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
