package cn.javadog.labs.springboot2.logging.multi.env.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 余勇
 * @date 2020年03月11日 15:45:00
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping("/debug")
	public void debug() {
		logger.debug("debug");
	}

	@GetMapping("/info")
	public void info() {
		logger.info("info");
	}

	@GetMapping("/error")
	public void error() {
		logger.error("error");
	}

}
