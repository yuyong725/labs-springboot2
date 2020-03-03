package cn.javadog.labs.springboot2.admin.security;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 余勇
 * @date 2020年03月01日 17:45:00
 */
@EnableAdminServer
@SpringBootApplication
public class AdminSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminSecurityApplication.class, args);
	}

}
