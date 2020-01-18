package cn.javadog.labs.springboot2.kafka.ack.producer;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

import cn.javadog.labs.springboot2.kafka.ack.message.Demo08Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

/**
 * @author 余勇
 * @date 2020-01-18 11:07
 */
@Component
public class Demo08Producer {

    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;

    public SendResult syncSend(Integer id) throws ExecutionException, InterruptedException {
        // 创建 Demo08Message 消息
        Demo08Message message = new Demo08Message();
        message.setId(id);
        // 同步发送消息
        return kafkaTemplate.send(Demo08Message.TOPIC, message).get();
    }
    
}
