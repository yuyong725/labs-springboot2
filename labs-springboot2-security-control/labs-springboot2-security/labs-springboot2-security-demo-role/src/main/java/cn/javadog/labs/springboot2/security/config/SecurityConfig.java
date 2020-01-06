package cn.javadog.labs.springboot2.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * @author 余勇
 * @date 2019年12月30日 11:44:00
 * 安全配置
 *
 * @EnableGlobalMethodSecurity 注解作用看看下面：
 * https://www.cnblogs.com/520playboy/p/7286085.html
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	/**
	 * 实现 [AuthenticationManager] 认证管理器
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			// 使用内存中的 InMemoryUserDetailsManager
			.inMemoryAuthentication()
			// 不使用 PasswordEncoder 密码编码器
			.passwordEncoder(NoOpPasswordEncoder.getInstance())
			// 配置 admin 用户
			.withUser("admin").password("admin").roles("ADMIN")
			// 配置 normal 用户
			.and().withUser("normal").password("normal").roles("NORMAL");
	}

	/**
	 * 配置 URL 的权限控制
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			// 配置请求地址的权限
			.authorizeRequests()
				// 所有用户可访问
				.antMatchers("/test/echo").permitAll()
				// 需要 ADMIN 角色
				.antMatchers("/test/admin").hasRole("ADMIN")
				// 需要 NORMAL 角色。
				.antMatchers("/test/normal").access("hasRole('ROLE_NORMAL')")
				// 任何请求，访问的用户都需要经过认证
				.anyRequest().authenticated()
			.and()
			// 设置 Form 表单登陆
			.formLogin()
			// 登陆 URL 地址
			// .loginPage("/login")
			.permitAll() // 所有用户可访问
			.and()
			// 配置退出相关
			.logout()
			// 退出 URL 地址
			// .logoutUrl("/logout")
			// 所有用户可访问
			.permitAll();
	}

}
