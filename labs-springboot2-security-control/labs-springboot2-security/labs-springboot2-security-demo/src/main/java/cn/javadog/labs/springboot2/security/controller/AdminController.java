package cn.javadog.labs.springboot2.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 余勇
 * @date 2019年12月29日 23:38:00
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/demo")
	public String demo() {
		return "示例返回";
	}

}
