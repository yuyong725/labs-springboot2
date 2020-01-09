package cn.javadog.labs.springboot2.redis.jedis;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScriptTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test01() throws IOException {
        // 读取 /resources/lua/compareAndSet.lua 脚本 。注意，需要引入下 commons-io 依赖。
        String scriptContents = IOUtils.toString(getClass().getResourceAsStream("/lua/compareAndSet.lua"), "UTF-8");
        // 创建 RedisScript 对象
        RedisScript<Long> script = new DefaultRedisScript<>(scriptContents, Long.class);
        // 执行 LUA 脚本
        Long result = stringRedisTemplate.execute(script, Collections.singletonList("calm:1"), "handsome", "so handsome!");
        log.info(result.toString());
    }

    @Test
    public void test02() throws IOException {
        // 读取 lua 脚本 。注意，需要引入下 commons-io 依赖。注意路径签名必须有/，代表绝对路径
        String scriptContents = IOUtils.toString(getClass().getResourceAsStream("/lua/test.lua"), "UTF-8");
        // 创建 RedisScript 对象
        RedisScript<List> script = new DefaultRedisScript<>(scriptContents, List.class);

        List<Object> result = stringRedisTemplate.execute(script, Arrays.asList("key1", "key2"), "first", "second");
        System.out.println(result);
    }

}
