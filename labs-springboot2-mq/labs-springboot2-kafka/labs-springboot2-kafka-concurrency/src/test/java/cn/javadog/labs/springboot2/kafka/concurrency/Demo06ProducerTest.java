package cn.javadog.labs.springboot2.kafka.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import cn.javadog.labs.springboot2.kafka.concurrency.producer.Demo06Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo06ProducerTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Demo06Producer producer;

    @Test
    public void testSyncSend() throws ExecutionException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            int id = (int) (System.currentTimeMillis() / 1000);
            SendResult result = producer.syncSend(id);
//            logger.info("[testSyncSend][发送编号：[{}] 发送结果：[{}]]", id, result);
            logger.info("[testSyncSend][发送编号：[{}] 发送队列：[{}]]", id, result.getRecordMetadata().partition());
        }

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testSyncSendOrderly() throws ExecutionException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            int id = i;
//            int id = 1;
            SendResult result = producer.syncSendOrderly(id);
            logger.info("[testSyncSend][发送编号：[{}] 发送队列：[{}]]", id, result.getRecordMetadata().partition());
        }

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

}
