package cn.javadog.labs.springboot2.sentinel.file.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 余勇
 * @date 2020年02月28日 11:36:00
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

	@GetMapping("/echo")
	public String echo() {
		return "echo";
	}

}
