package cn.javadog.labs.springboot2.redis.jedis.config;

import cn.javadog.labs.springboot2.redis.jedis.listener.TestChannelTopicMessageListener;
import cn.javadog.labs.springboot2.redis.jedis.listener.TestPatternTopicMessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author 余勇
 * @date 2020-01-09 16:48
 * redis 配置
 */
@Configuration
public class RedisConfiguration {

    /**
     * 不支持事务的 RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {

        // 创建 RedisTemplate 对象
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        // 设置 RedisConnection 工厂。😈 它就是实现多种 Java Redis 客户端接入的秘密工厂。感兴趣的胖友，可以自己去撸下。
        template.setConnectionFactory(factory);

        // 使用 String 序列化方式，序列化 KEY 。
        template.setKeySerializer(RedisSerializer.string());

        // 使用 JSON 序列化方式（库是 Jackson ），序列化 VALUE 。
        template.setValueSerializer(RedisSerializer.json());
        return template;
    }

    /**
     * 支持事务的 RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Object> redisTransactionTemplate(RedisConnectionFactory factory) {

        // 创建 RedisTemplate 对象
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        // 设置开启事务支持
        template.setEnableTransactionSupport(true);

        // 设置 RedisConnection 工厂。😈 它就是实现多种 Java Redis 客户端接入的秘密工厂。感兴趣的胖友，可以自己去撸下。
        template.setConnectionFactory(factory);

        // 使用 String 序列化方式，序列化 KEY 。
        template.setKeySerializer(RedisSerializer.string());

        // 使用 JSON 序列化方式（库是 Jackson ），序列化 VALUE 。
        template.setValueSerializer(RedisSerializer.json());
        return template;
    }

    /**
     * PUB/SUB 使用的 Bean ，需要时打开。
     */
    @Bean
    public RedisMessageListenerContainer listenerContainer(RedisConnectionFactory factory) {
        // 创建 RedisMessageListenerContainer 对象
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();

        // 设置 RedisConnection 工厂。它就是实现多种 Java Redis 客户端接入的秘密工厂。感兴趣的胖友，可以自己去撸下。
        container.setConnectionFactory(factory);

        // 添加监听器
//        container.addMessageListener(new TestChannelTopicMessageListener(), new ChannelTopic("TEST_PUB_SUB"));
//        container.addMessageListener(new TestChannelTopicMessageListener(), new ChannelTopic("AOTEMAN"));
        container.addMessageListener(new TestPatternTopicMessageListener(), new PatternTopic("TEST*"));
        return container;
    }

}
