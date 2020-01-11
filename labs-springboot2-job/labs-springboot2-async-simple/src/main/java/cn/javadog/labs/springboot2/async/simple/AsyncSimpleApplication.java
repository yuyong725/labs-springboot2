package cn.javadog.labs.springboot2.async.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author 余勇
 * @date 2020-01-11 19:39
 * 开启 @Async 的支持
 */
@SpringBootApplication
public class AsyncSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncSimpleApplication.class, args);
    }

}
