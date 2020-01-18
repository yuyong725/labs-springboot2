package cn.javadog.labs.springboot2.rabbitmq.demo.producer;

import cn.javadog.labs.springboot2.rabbitmq.demo.message.Demo04Message;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 余勇
 * @date 2020-01-18 22:45
 */
@Component
public class Demo04Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id, String headerValue) {
        // 创建 MessageProperties 属性
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader(Demo04Message.HEADER_KEY, headerValue); // 设置 header
        // 创建 Message 消息
        Message message = rabbitTemplate.getMessageConverter().toMessage(
                new Demo04Message().setId(id), messageProperties);
        // 同步发送消息
        rabbitTemplate.send(Demo04Message.EXCHANGE, null, message);
    }

}
