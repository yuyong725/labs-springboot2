package cn.javadog.labs.springboot2.admin.eureka.server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 余勇
 * @date 2020年03月02日 14:44:00
 */
@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class AdminEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminEurekaServerApplication.class, args);
	}

}
