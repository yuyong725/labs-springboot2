package cn.javadog.labs.springboot2.sentinel.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

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
