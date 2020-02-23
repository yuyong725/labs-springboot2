package cn.javadog.labs.springboot2.nacos.actuator.config;

import org.springframework.stereotype.Component;
import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;

/**
 * @author 余勇
 * @date 2020年02月22日 19:10:00
 */
@Component
@NacosConfigurationProperties(prefix = "", dataId = "${nacos.config.data-id}", type = ConfigType.YAML, autoRefreshed = true)
//@ConfigurationProperties(prefix = "test")
public class TestProperties {

	/**
	 * 测试属性
	 */
	private String test;

	public String getTest() {
		return test;
	}

	public TestProperties setTest(String test) {
		this.test = test;
		return this;
	}

}
