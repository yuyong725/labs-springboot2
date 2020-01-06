package cn.javadog.labs.springboot2.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author 余勇
 * @date 2020年01月05日 22:35:00
 * NOTE @ServletComponentScan 仅当使用内嵌的 Web Server 才会生效，想通用的话，请使用bean
 */
@SpringBootApplication
@ServletComponentScan
public class SpringMvcAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcAdvancedApplication.class, args);
	}

}
