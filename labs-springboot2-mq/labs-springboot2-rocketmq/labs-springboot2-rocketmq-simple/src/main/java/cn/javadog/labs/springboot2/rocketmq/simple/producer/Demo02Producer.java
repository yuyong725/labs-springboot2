package cn.javadog.labs.springboot2.rocketmq.simple.producer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.javadog.labs.springboot2.rocketmq.simple.message.Demo02Message;
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
public class Demo02Producer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public SendResult sendBatch(Collection<Integer> ids) {
        // 创建多条 Demo02Message 消息
        List<Message> messages = new ArrayList<>(ids.size());
        for (Integer id : ids) {
            // 创建 Demo02Message 消息
            Demo02Message message = new Demo02Message().setId(id);
            // 构建 Spring Messaging 定义的 Message 消息
            messages.add(MessageBuilder.withPayload(message).build());
        }
        // 同步批量发送消息
        return rocketMQTemplate.syncSend(Demo02Message.TOPIC, messages, 30 * 1000L);
    }

}
