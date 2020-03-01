package cn.javadog.labs.springboot2.actuator.httptrace.config;

import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 余勇
 * @date 2020年03月01日 14:37:00
 */
@Configuration
public class ActuateConfig {

	@Bean
	public HttpTraceRepository httpTraceRepository() {
		return new InMemoryHttpTraceRepository();
	}

}