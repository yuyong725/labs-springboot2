package cn.javadog.labs.springboot2.apollo.auto.refresh.listener;

import javax.annotation.Resource;
import java.util.Set;

import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.stereotype.Component;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;

/**
 * @author 余勇
 * @date 2020年02月22日 19:18:00
 */
@Component
public class LoggingSystemConfigListener {

	/**
	 * 日志配置项的前缀
	 */
	private static final String LOGGER_TAG = "logging.level.";

	@Resource
	private LoggingSystem loggingSystem;

	@ApolloConfig
	private Config config;

	@ApolloConfigChangeListener
	public void onChange(ConfigChangeEvent changeEvent) throws Exception {
		// <X> 获得 Apollo 所有配置项
		Set<String> keys = config.getPropertyNames();
		// <Y> 遍历配置集的每个配置项，判断是否是 logging.level 配置项
		for (String key : keys) {
			// 如果是 logging.level 配置项，则设置其对应的日志级别
			if (key.startsWith(LOGGER_TAG)) {
				// 获得日志级别
				String strLevel = config.getProperty(key, "info");
				LogLevel level = LogLevel.valueOf(strLevel.toUpperCase());
				// 设置日志级别到 LoggingSystem 中
				loggingSystem.setLogLevel(key.replace(LOGGER_TAG, ""), level);
			}
		}
	}

}
