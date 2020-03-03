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
public class AdminEurekaClient01Application {

	public static void main(String[] args) {
		// 端口 18081
		System.setProperty("server.port", "18081");
		SpringApplication.run(AdminEurekaClient01Application.class, args);
	}

}
