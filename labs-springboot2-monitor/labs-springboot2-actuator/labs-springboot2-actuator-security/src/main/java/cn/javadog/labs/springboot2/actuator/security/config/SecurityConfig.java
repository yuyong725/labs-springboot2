package cn.javadog.labs.springboot2.actuator.security.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author 余勇
 * @date 2020年03月01日 16:16:00
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// <1> 访问 EndPoint 地址，需要经过认证，并且拥有 ADMIN 角色
		http.requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests().anyRequest().hasRole("ADMIN");
		// <2> 开启 Basic Auth
		http.httpBasic();
	}

}
