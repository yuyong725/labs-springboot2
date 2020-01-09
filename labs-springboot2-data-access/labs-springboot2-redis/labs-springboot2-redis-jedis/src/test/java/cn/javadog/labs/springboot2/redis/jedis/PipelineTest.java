package cn.javadog.labs.springboot2.redis.jedis;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PipelineTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test01() {
        List<Object> results = stringRedisTemplate.executePipelined((RedisCallback<Object>) connection -> {
            // set 写入
            for (int i = 0; i < 3; i++) {
                connection.set(String.format("calm:%d", i).getBytes(), "handsome".getBytes());
            }

            // get
            for (int i = 0; i < 3; i++) {
                connection.get(String.format("calm:%d", i).getBytes());
            }

            // 返回 null 即可
            return null;
        });

        // 打印结果
        System.out.println(results);
    }

}
