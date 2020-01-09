package cn.javadog.labs.springboot2.redis.redisson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 余勇
 * @date 2020年01月09日 19:55:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedissonTest {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void testStringSetKey() {
		stringRedisTemplate.opsForValue().set("calm:redisson:testStringSetKey", "handsome");
	}

}
