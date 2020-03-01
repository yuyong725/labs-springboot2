package cn.javadog.labs.springboot2.actuator.info.config;

import java.util.Collections;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/**
 * @author 余勇
 * @date 2020年03月01日 14:03:00
 */
@Component
public class DemoInfoContributor implements InfoContributor {

	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("demo", Collections.singletonMap("key", "value"));
	}

}
