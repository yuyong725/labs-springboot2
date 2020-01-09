package cn.javadog.labs.springboot2.redis.jedis;

import cn.javadog.labs.springboot2.redis.jedis.cacheobject.UserCacheObject;
import cn.javadog.labs.springboot2.redis.jedis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 余勇
 * @date 2020年01月09日 16:16:00
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class JedisTest {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private UserService userService;

	@Test
	public void testStringSetKey() {
		stringRedisTemplate.opsForValue().set("string-calm", "handsome");
	}

	@Test
	public void testSetKey() {
		redisTemplate.opsForValue().set("calm", "handsome");
	}

	@Test
	public void testStringSetKeyUserCache() {
		UserCacheObject object = new UserCacheObject()
			.setId(1)
			.setName("calm springboot2")
			.setGender(1); // 男
		String key = String.format("user:%d", object.getId());
		redisTemplate.opsForValue().set(key, object);
	}

	@Test
	public void testStringGetKeyUserCache() {
		String key = String.format("user:%d", 1);
		Object value = redisTemplate.opsForValue().get(key);
		System.out.println(value);
	}

	@Test
	public void testServiceSet() {
		UserCacheObject object = new UserCacheObject()
			.setId(1)
			.setName("calm testServiceSet")
			.setGender(1);
		userService.set(object.getId(), object);
	}

	@Test
	public void testServiceGet() {
		userService.get(1);
	}

}
