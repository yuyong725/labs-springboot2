package cn.javadog.labs.springboot2.redis.jedis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionTest {

    @Autowired
    @Qualifier(value = "redisTransactionTemplate")
    private RedisTemplate redisTransactionTemplate;

    @Test
    public void test01() {
        // 执行想要的操作
        redisTransactionTemplate.opsForValue().set("calm:1", "handsome");
        redisTransactionTemplate.opsForValue().set("code:1", "hard");
    }

}
