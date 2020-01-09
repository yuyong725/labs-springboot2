package cn.javadog.labs.springboot2.redis.jedis.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * @author 余勇
 * @date 2020-01-09 19:17
 * PatternTopic 对应 PSUBSCRIBE 命令，订阅给定的模式(patterns)
 */
@Slf4j
public class TestPatternTopicMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("收到 PatternTopic 消息：");
        log.info("线程编号：{}, message：{}, pattern：{}", Thread.currentThread().getName(), message, new String(pattern));
    }

}
