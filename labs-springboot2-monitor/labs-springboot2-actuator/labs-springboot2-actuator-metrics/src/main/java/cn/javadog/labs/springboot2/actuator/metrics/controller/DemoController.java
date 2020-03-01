package cn.javadog.labs.springboot2.actuator.metrics.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 余勇
 * @date 2020年03月01日 14:12:00
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

	/**
	 * DEMO 访问次数 Metrics
	 */
	private static final Counter METRICS_DEMO_COUNT = Counter
		// 指标的名字
		.builder("demo.visit.count")
		// 指标的描述
		.description("demo 访问次数")
		// 指标的单位
		.baseUnit("次")
		// 自定义标签
		.tag("test", "udf")
		// 注册到全局 MeterRegistry 指标注册表
		.register(Metrics.globalRegistry);

	@GetMapping("/visit")
	public String visit() {
		// 增加次数
		METRICS_DEMO_COUNT.increment();
		return "Demo 示例";
	}

}
