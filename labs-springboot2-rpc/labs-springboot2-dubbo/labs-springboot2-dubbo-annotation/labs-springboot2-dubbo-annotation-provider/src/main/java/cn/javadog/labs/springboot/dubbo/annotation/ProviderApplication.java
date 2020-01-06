package cn.javadog.labs.springboot.dubbo.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 余勇
 * @date 2020-01-06 22:16
 * 启动类
 */
@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args) {
        // 启动 Spring Boot 应用
        SpringApplication.run(ProviderApplication.class, args);
    }

}
