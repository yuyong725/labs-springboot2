package cn.javadog.labs.springboot2.actuator.info.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

/**
 * @author 余勇
 * @date 2020年03月01日 16:07:00
 */
@Component
@Endpoint(id = "demo")
public class DemoEndPoint {

	@ReadOperation
	public Map<String, String> hello() {
		Map<String, String> result = new HashMap<>();
		result.put("作者", "calm");
		result.put("秃头", "false");
		return result;
	}

}