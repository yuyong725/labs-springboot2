package cn.javadog.springboot2.datasource.sharding.mybatis;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 余勇
 * @date 2020-01-10 23:41
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.javadog.springboot2.datasource.sharding.mybatis.mapper")
public class Application {
}
