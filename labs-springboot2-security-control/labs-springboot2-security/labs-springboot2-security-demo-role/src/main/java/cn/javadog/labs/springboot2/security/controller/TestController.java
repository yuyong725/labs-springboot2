package cn.javadog.labs.springboot2.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 余勇
 * @date 2019年12月30日 12:11:00
 */
@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("/echo")
	public String demo() {
		return "示例返回";
	}

	@GetMapping("/home")
	public String home() {
		return "我是首页";
	}

	@GetMapping("/admin")
	public String admin() {
		return "我是管理员";
	}

	@GetMapping("/normal")
	public String normal() {
		return "我是普通用户";
	}

}
