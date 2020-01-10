package cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.one;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 余勇
 * @date 2020-01-10 21:31
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.one.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class Application {
}
