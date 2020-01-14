package cn.javadog.labs.springboot2.rocketmq.simple.producer;

import cn.javadog.labs.springboot2.rocketmq.simple.message.Demo05Message;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 余勇
 * @date 2020-01-14 09:56
 */
@Component
public class Demo05Producer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public SendResult syncSend(Integer id) {
        // 创建 Demo05Message 消息
        Demo05Message message = new Demo05Message();
        message.setId(id);
        // 同步发送消息
        return rocketMQTemplate.syncSend(Demo05Message.TOPIC, message);
    }

}
