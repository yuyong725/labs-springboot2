package cn.javadog.labs.springboot2.rocketmq.simple.consumer;

import cn.javadog.labs.springboot2.rocketmq.simple.message.Demo03Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author 余勇
 * @date 2020-01-14 09:44
 */
@Component
@RocketMQMessageListener(
        topic = Demo03Message.TOPIC,
        consumerGroup = "demo03-consumer-group-" + Demo03Message.TOPIC
)
public class Demo03Consumer implements RocketMQListener<Demo03Message> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onMessage(Demo03Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }

}
