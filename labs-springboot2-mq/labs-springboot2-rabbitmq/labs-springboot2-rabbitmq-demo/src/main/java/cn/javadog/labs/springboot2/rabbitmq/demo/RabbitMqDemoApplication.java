package cn.javadog.labs.springboot2.rabbitmq.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author 余勇
 * @date 2020-01-18 22:44
 * 开启异步
 */
@SpringBootApplication
@EnableAsync
public class RabbitMqDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqDemoApplication.class, args);
    }

}
