package cn.javadog.labs.springboot2.actuator.auditevents.config;

import org.springframework.boot.actuate.audit.AuditEventRepository;
import org.springframework.boot.actuate.audit.InMemoryAuditEventRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 余勇
 * @date 2020年03月01日 15:12:00
 */
@Configuration
public class ActuateConfig {

	@Bean
	public AuditEventRepository auditEventRepository() {
		return new InMemoryAuditEventRepository();
	}

}
