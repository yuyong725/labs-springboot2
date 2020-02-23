package cn.javadog.labs.springboot2.registry.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 余勇
 * @date 2020年02月23日 12:49:00
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {

	@GetMapping("/demo")
	public String provider() {
		return "echo";
	}

}
