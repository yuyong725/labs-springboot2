package cn.javadog.labs.springboot2.datasource.dynamic.baomidou.one;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 余勇
 * @date 2020-01-10 15:04
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.javadog.labs.springboot2.datasource.dynamic.baomidou.one.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class BaomidouApplication {
}
