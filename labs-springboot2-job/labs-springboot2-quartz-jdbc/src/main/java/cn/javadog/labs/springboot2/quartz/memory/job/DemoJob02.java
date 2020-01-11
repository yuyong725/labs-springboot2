package cn.javadog.labs.springboot2.quartz.memory.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author 余勇
 * @date 2020-01-11 14:26
 */
@DisallowConcurrentExecution
public class DemoJob02 extends QuartzJobBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void executeInternal(JobExecutionContext context) {
        logger.info("[executeInternal][我开始的执行了]");
    }

}
