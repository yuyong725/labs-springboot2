package cn.javadog.labs.springboot2.registry.nacos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;

/**
 * @author 余勇
 * @date 2020年02月23日 12:49:00
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

	@NacosInjected
	private NamingService namingService;

	@Value("${spring.application.name}")
	private String applicationName;

	private RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/demo")
	public String consumer() throws IllegalStateException, NacosException {
		// <1> 获得实例
		Instance instance = namingService.selectOneHealthyInstance(applicationName);
		// <2> 执行请求
		return restTemplate.getForObject("http://" + instance.toInetAddr() + "/provider/demo", String.class);
	}

}
