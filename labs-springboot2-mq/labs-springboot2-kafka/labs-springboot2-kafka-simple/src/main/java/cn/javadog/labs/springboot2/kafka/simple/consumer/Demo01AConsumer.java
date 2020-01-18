package cn.javadog.labs.springboot2.kafka.simple.consumer;

import cn.javadog.labs.springboot2.kafka.simple.message.Demo01Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author 余勇
 * @date 2020-01-17 12:23
 */
@Component
public class Demo01AConsumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @KafkaListener(topics = Demo01Message.TOPIC,
            groupId = "demo01-A-consumer-group-" + Demo01Message.TOPIC)
    public void onMessage(ConsumerRecord<Integer, String> record) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), record);
    }

//    @KafkaListener(topics = Demo01Message.TOPIC,
//            groupId = "demo01-B-consumer-group-" + Demo01Message.TOPIC)
//    public void onMessage(ConsumerRecord<Integer, String> record) throws InterruptedException {
//        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), record.partition());
//        Thread.sleep(10 * 1000L);
//        Thread.sleep(1L);
//        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), record.partition());
//    }

}
