package cn.javadog.labs.springboot2.actuator.simple.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 余勇
 * @date 2020年03月01日 15:42:00
 */
@RestController
@RequestMapping("demo")
public class DemoController {

	@GetMapping("sample")
	public String sample(){
		return "sample";
	}

}
