package cn.javadog.labs.springboot2.logging.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 余勇
 * @date 2020年03月11日 15:39:00
 */
@SpringBootApplication
public class LoggingAopApplication {

	private static Logger logger = LoggerFactory.getLogger(LoggingAopApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LoggingAopApplication.class, args);

		// <X> 打印日志
		logger.debug("just do it");
	}

}
