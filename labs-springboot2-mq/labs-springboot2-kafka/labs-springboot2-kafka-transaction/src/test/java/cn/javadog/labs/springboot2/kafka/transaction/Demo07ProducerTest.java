package cn.javadog.labs.springboot2.kafka.transaction;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import cn.javadog.labs.springboot2.kafka.transaction.producer.Demo07Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo07ProducerTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Demo07Producer producer;

    @Test
    @Transactional
    public void testSyncSend() throws ExecutionException, InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        SendResult result = producer.syncSend(id);
        logger.info("[testSyncSend][发送编号：[{}] 发送结果：[{}]]", id, result);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testSyncSendInTransaction() throws ExecutionException, InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        producer.syncSendInTransaction(id, () -> {
            logger.info("[run][我要开始睡觉了]");
            try {
                Thread.sleep(10 * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logger.info("[run][我睡醒了]");
        });

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

}
