package cn.javadog.labs.springboot2.nacos.multi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author 余勇
 * @date 2020年02月23日 12:38:00
 */
@SpringBootApplication
public class NacosMultiApplication {

	public static void main(String[] args) {
		// 启动 Spring Boot 应用
		ConfigurableApplicationContext context = SpringApplication.run(NacosMultiApplication.class, args);

		// 查看 Environment
		Environment environment = context.getEnvironment();
		System.out.println(environment);
	}

}
