package cn.javadog.labs.springboot2.actuator.health.indicator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * @author 余勇
 * @date 2020年02月29日 19:08:00
 */
@Component
public class DemoHealthIndicator extends AbstractHealthIndicator {

	@Override
	protected void doHealthCheck(Health.Builder builder) {
		// <1> 判断是否健康
		boolean success = checkSuccess();

		// <2> 如果健康，则标记状态为 UP
		if (success) {
			builder.up().build();
			return;
		}

		// <3> 如果不健康，则标记状态为 DOWN
		builder.down().withDetail("msg", "我就是做个示例而已");
	}

	private boolean checkSuccess() {
		return false;
	}

}
