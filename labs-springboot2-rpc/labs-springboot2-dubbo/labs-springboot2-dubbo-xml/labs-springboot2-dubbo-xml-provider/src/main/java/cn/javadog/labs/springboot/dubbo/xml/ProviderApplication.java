package cn.javadog.labs.springboot.dubbo.xml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author 余勇
 * @date 2020-01-06 20:20
 * 生产者实现类
 */
@SpringBootApplication
@ImportResource("classpath:dubbo.xml")
public class ProviderApplication {

    public static void main(String[] args) {
        // 启动 Spring Boot 应用
        SpringApplication.run(ProviderApplication.class, args);
    }

}
