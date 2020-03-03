package cn.javadog.labs.springboot2.admin.alert;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 余勇
 * @date 2020年03月03日 14:58:00
 */
@EnableAdminServer
@SpringBootApplication
public class AdminAlertApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminAlertApplication.class, args);
	}

}
