package cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.two;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 余勇
 * @date 2020-01-10 22:31
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.two.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class Application {
}
