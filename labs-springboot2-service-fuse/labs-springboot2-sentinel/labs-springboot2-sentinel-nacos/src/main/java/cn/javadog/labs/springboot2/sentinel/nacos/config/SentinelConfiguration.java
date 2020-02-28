package cn.javadog.labs.springboot2.sentinel.nacos.config;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 余勇
 * @date 2020年02月28日 11:59:00
 */
@Configuration
public class SentinelConfiguration {

	@Bean
	public SentinelResourceAspect sentinelResourceAspect() {
		return new SentinelResourceAspect();
	}

	@Bean
	public NacosDataSource nacosDataSource(ObjectMapper objectMapper) {
		// <1> Nacos 配置。这里先写死，推荐后面写到 application.yaml 配置文件中。
		String serverAddress = "127.0.0.1:18848"; // Nacos 服务器地址
		String namespace = ""; // Nacos 命名空间
		String dataId = "demo-application-flow-rule"; // Nacos 配置集编号
//        String dataId = "example-sentinel"; // Nacos 配置集编号
		String group = "DEFAULT_GROUP"; // Nacos 配置分组

		// <2> 创建 NacosDataSource 对象
		Properties properties = new Properties();
		properties.setProperty(PropertyKeyConst.SERVER_ADDR, serverAddress);
		properties.setProperty(PropertyKeyConst.NAMESPACE, namespace);
		NacosDataSource<List<FlowRule>> nacosDataSource = new NacosDataSource<>(properties, group, dataId,
			// <X> 转换器，将读取的 Nacos 配置，转换成 FlowRule 数组
			value -> {
				try {
					return Arrays.asList(objectMapper.readValue(value, FlowRule[].class));
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			});

		// 注册到 FlowRuleManager 中
		FlowRuleManager.register2Property(nacosDataSource.getProperty());
		return nacosDataSource;
	}
}
