package cn.javadog.labs.springboot2.admin.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author 余勇
 * @date 2020年03月02日 15:33:00
 * 开启 Security 对 WebFlux 的安全功能
 */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

	@Bean
	public MapReactiveUserDetailsService userDetailsService() {
		// 创建一个用户
		UserDetails user = User.withDefaultPasswordEncoder()
			.username("user")
			.password("user")
			.roles("USER")
			.build();

		// 如果胖友有更多用户的诉求，这里可以继续创建

		// 创建 MapReactiveUserDetailsService
		return new MapReactiveUserDetailsService(user);
	}

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		// 设置权限配置
		http.authorizeExchange()
				// 静态资源，允许匿名访问
				.pathMatchers("/assets/**").permitAll()
				// 登陆接口，允许匿名访问
				.pathMatchers("/login").permitAll()
				.anyExchange().authenticated()
			.and()
			// 登陆页面
			.formLogin().loginPage("/login")
			// 登出界面
			.and().logout().logoutUrl("/logout")
			// HTTP Basic 认证方式
			.and().httpBasic()
			// csrf 禁用
			.and().csrf().disable();
		return http.build();
	}

}
