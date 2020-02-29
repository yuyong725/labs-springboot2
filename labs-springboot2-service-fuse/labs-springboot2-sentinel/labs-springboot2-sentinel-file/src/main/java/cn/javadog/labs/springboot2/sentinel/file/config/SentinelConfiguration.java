package cn.javadog.labs.springboot2.sentinel.file.config;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.datasource.FileRefreshableDataSource;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
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
	public FileRefreshableDataSource<List<FlowRule>> refreshableDataSource(ObjectMapper objectMapper) throws IOException {
		// File 配置。这里先写死，推荐后面写到 application.yaml 配置文件中。
		ClassPathResource resource = new ClassPathResource("/flow-rule.json");

		// 创建 FileRefreshableDataSource 对象
		// <X> 转换器，将读取的文本配置，转换成 FlowRule 数组
		FileRefreshableDataSource<List<FlowRule>> refreshableDataSource = new FileRefreshableDataSource<>(resource.getFile(),
			value -> {
				try {
					return Arrays.asList(objectMapper.readValue(value, FlowRule[].class));
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			});

		// 注册到 FlowRuleManager 中
		FlowRuleManager.register2Property(refreshableDataSource.getProperty());
		return refreshableDataSource;
	}

}
