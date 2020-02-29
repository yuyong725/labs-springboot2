package cn.javadog.labs.springboot2.sentinel.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 余勇
 * @date 2020年02月28日 11:14:00
 */
@SpringBootApplication
public class SentinelApolloApplication {

	public static void main(String[] args) {
		// <X> 设置系统属性 project.name，提供给 Sentinel 读取
		System.setProperty("project.name", "demo-sentinel-test");

		// 启动 Spring Boot 应用
		SpringApplication.run(SentinelApolloApplication.class, args);
	}

}
