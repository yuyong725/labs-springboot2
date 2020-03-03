package cn.javadog.labs.springboot2.admin.alert.config;

import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import de.codecentric.boot.admin.server.notify.AbstractStatusChangeNotifier;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author 余勇
 * @date 2020年03月03日 16:35:00
 */
@Component
public class LoggerNotifier extends AbstractStatusChangeNotifier {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public LoggerNotifier(InstanceRepository repository) {
		super(repository);
	}

	@Override
	protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {
		return Mono.fromRunnable(() -> {
			if (event instanceof InstanceStatusChangedEvent) {
				logger.info("Instance {} ({}) is {}", instance.getRegistration().getName(), event.getInstance(),
					((InstanceStatusChangedEvent) event).getStatusInfo().getStatus());
			} else {
				logger.info("Instance {} ({}) {}", instance.getRegistration().getName(), event.getInstance(), event.getType());
			}
		});
	}

}
