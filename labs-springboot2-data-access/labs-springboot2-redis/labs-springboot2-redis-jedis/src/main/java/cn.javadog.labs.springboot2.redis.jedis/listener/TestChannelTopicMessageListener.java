package cn.javadog.labs.springboot2.redis.jedis.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * @author 余勇
 * @date 2020-01-09 19:15
 * ChannelTopic，对应 SUBSCRIBE命令， 订阅指定频道的信息
 */
@Slf4j
public class TestChannelTopicMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("收到 ChannelTopic 消息：");
        log.info("线程编号：{}, message：{}, pattern：{}", Thread.currentThread().getName(), message, new String(pattern));
    }

}
