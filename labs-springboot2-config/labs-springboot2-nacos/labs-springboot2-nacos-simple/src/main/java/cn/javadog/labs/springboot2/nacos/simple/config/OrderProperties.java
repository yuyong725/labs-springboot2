package cn.javadog.labs.springboot2.nacos.simple.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 余勇
 * @date 2020年02月22日 12:29:00
 */
@Data
@Component
@ConfigurationProperties(prefix = "order")
public class OrderProperties {

	/**
	 * 订单支付超时时长，单位：秒。
	 */
	private Integer payTimeoutSeconds;

	/**
	 * 订单创建频率，单位：秒
	 */
	private Integer createFrequencySeconds;

}
