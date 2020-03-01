package cn.javadog.labs.springboot2.actuator.info.config;

import java.util.Collections;

import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.actuate.info.SimpleInfoContributor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 余勇
 * @date 2020年03月01日 14:01:00
 */
@Configuration
public class ActuateConfig {

	@Bean
	public InfoContributor exampleInfo() {
		return new SimpleInfoContributor("example",
			Collections.singletonMap("key", "value"));
	}

}