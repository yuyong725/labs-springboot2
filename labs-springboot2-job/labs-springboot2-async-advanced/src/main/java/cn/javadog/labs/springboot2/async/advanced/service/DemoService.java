package cn.javadog.labs.springboot2.async.advanced.service;

import cn.javadog.labs.springboot2.async.advanced.config.AsyncConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author 余勇
 * @date 2020-01-11 19:57
 */
@Service
public class DemoService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Async(AsyncConfig.EXECUTOR_ONE_BEAN_NAME)
    public Integer execute01() {
        logger.info("[execute01]");
        return 1;
    }

    @Async(AsyncConfig.EXECUTOR_TWO_BEAN_NAME)
    public Integer execute02() {
        logger.info("[execute02]");
        return 2;
    }

}
