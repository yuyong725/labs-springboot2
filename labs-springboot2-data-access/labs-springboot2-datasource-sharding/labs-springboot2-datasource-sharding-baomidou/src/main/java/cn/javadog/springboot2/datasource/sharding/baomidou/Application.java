package cn.javadog.springboot2.datasource.sharding.baomidou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 余勇
 * @date 2020-01-11 00:05
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.javadog.springboot2.datasource.sharding.baomidou.mapper")
public class Application {
}
