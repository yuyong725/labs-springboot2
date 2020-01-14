package cn.javadog.labs.springboot2.rocketmq.simple.consumer;

import cn.javadog.labs.springboot2.rocketmq.simple.message.Demo07Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author 余勇
 * @date 2020-01-14 09:46
 */
@Component
@RocketMQMessageListener(
        topic = Demo07Message.TOPIC,
        consumerGroup = "demo07-consumer-group-" + Demo07Message.TOPIC
)
public class Demo07Consumer implements RocketMQListener<Demo07Message> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onMessage(Demo07Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }

}
