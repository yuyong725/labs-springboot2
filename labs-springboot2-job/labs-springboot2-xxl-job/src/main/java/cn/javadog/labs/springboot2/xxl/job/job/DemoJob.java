package cn.javadog.labs.springboot2.xxl.job.job;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;

/**
 * @author 余勇
 * @date 2020-01-11 16:28
 */
@Component
@JobHandler("demoJob")
public class DemoJob extends IJobHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final AtomicInteger counts = new AtomicInteger();

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        // 打印日志
        logger.info("[execute][定时第 ({}) 次执行]", counts.incrementAndGet());
        // 返回执行成功
        return ReturnT.SUCCESS;
    }

}
