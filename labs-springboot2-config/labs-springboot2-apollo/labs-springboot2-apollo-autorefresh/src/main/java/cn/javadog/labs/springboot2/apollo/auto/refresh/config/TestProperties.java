package cn.javadog.labs.springboot2.apollo.auto.refresh.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 余勇
 * @date 2020年02月22日 19:10:00
 */
@Component
@ConfigurationProperties(prefix = "test")
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
