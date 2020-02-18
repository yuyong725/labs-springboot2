package cn.javadog.labs.springboot2.quartz.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuartzJdbcApplication2 {

    public static void main(String[] args) {
        // 设置 Tomcat 随机端口
        System.setProperty("server.port", "0");

        // 启动 Spring Boot 应用
        SpringApplication.run(QuartzJdbcApplication.class, args);
    }

}
