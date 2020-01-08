package cn.javadog.labs.springboot2.mybatis.tk;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 余勇
 * @date 2020-01-08 13:32
 * 启动类
 * 注意，要换成 tk 提供的 @MapperScan 注解
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.javadog.labs.springboot2.mybatis.tk.mapper")
public class MyBatisTkApplication {
}
