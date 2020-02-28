package cn.javadog.labs.springboot2.sentinel.nacos.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author 余勇
 * @date 2020年02月28日 11:36:00
 */
@ControllerAdvice(basePackages = "cn.javadog.labs.springboot2.sentinel.nacos.controller")
public class GlobalExceptionHandler {

	@ResponseBody
	@ExceptionHandler(value = BlockException.class)
	public String blockExceptionHandler(BlockException blockException) {
		return "请求过于频繁";
	}

}
