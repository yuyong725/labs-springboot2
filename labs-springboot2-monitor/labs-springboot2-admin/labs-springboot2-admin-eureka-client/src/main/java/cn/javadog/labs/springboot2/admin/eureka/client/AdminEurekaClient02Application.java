package cn.javadog.labs.springboot2.admin.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 余勇
 * @date 2020年03月02日 14:44:00
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AdminEurekaClient02Application {

	public static void main(String[] args) {
		// 端口 18082
		System.setProperty("server.port", "18082");
		SpringApplication.run(AdminEurekaClient02Application.class, args);
	}

}
