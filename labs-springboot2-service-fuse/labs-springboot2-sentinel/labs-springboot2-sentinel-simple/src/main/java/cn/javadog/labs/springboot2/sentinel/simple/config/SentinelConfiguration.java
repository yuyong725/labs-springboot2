package cn.javadog.labs.springboot2.sentinel.simple.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;

/**
 * @author 余勇
 * @date 2020年02月28日 11:59:00
 */
@Configuration
public class SentinelConfiguration {

	@Bean
	public SentinelResourceAspect sentinelResourceAspect() {
		return new SentinelResourceAspect();
	}

}
