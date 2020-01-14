package cn.javadog.labs.springboot2.rocketmq.simple.producer;

import cn.javadog.labs.springboot2.rocketmq.simple.message.Demo03Message;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author 余勇
 * @date 2020-01-14 09:56
 */
@Component
public class Demo03Producer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public SendResult syncSendDelay(Integer id, int delayLevel) {
        // 创建 Demo03Message 消息
        Message message = MessageBuilder.withPayload(new Demo03Message().setId(id))
                .build();
        // 同步发送消息
        return rocketMQTemplate.syncSend(Demo03Message.TOPIC, message, 30 * 1000,
                delayLevel);
    }

    public void asyncSendDelay(Integer id, int delayLevel, SendCallback callback) {
        // 创建 Demo03Message 消息
        Message message = MessageBuilder.withPayload(new Demo03Message().setId(id))
                .build();
        // 同步发送消息
        rocketMQTemplate.asyncSend(Demo03Message.TOPIC, message, callback, 30 * 1000,
                delayLevel);
    }

}
