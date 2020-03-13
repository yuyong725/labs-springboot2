package cn.javadog.labs.springboot2.skywalking.springmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 余勇
 * @date 2020年03月13日 12:18:00
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

	@GetMapping("/echo")
	public String echo() {
		return "echo";
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

}
