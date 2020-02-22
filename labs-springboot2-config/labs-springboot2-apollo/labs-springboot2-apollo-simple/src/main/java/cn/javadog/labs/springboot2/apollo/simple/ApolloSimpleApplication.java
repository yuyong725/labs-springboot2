package cn.javadog.labs.springboot2.apollo.simple;

import cn.javadog.labs.springboot2.apollo.simple.config.OrderProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * @author 余勇
 * @date 2020年02月22日 12:28:00
 */
@SpringBootApplication
public class ApolloSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApolloSimpleApplication.class, args);
	}

	@Component
	public class OrderPropertiesCommandLineRunner implements CommandLineRunner {

		private final Logger logger = LoggerFactory.getLogger(getClass());

		@Autowired
		private OrderProperties orderProperties;

		@Override
		public void run(String... args) {
			logger.info("payTimeoutSeconds:" + orderProperties.getPayTimeoutSeconds());
			logger.info("createFrequencySeconds:" + orderProperties.getCreateFrequencySeconds());
		}

	}

	@Component
	public class ValueCommandLineRunner implements CommandLineRunner {

		private final Logger logger = LoggerFactory.getLogger(getClass());

		@Value(value = "${order.pay-timeout-seconds}")
		private Integer payTimeoutSeconds;

		@Value(value = "${order.create-frequency-seconds}")
		private Integer createFrequencySeconds;

		@Override
		public void run(String... args) {
			logger.info("payTimeoutSeconds:" + payTimeoutSeconds);
			logger.info("createFrequencySeconds:" + createFrequencySeconds);
		}
	}

}
