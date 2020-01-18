package cn.javadog.labs.springboot2.kafka.simple.producer;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

import cn.javadog.labs.springboot2.kafka.simple.message.Demo04Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

/**
 * @author 余勇
 * @date 2020-01-17 12:23
 */
@Component
public class Demo04Producer {

    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;

    public SendResult syncSend(Integer id) throws ExecutionException, InterruptedException {
        // 创建 Demo04Message 消息
        Demo04Message message = new Demo04Message();
        message.setId(id);
        // 同步发送消息
        return kafkaTemplate.send(Demo04Message.TOPIC, message).get();
    }

}
