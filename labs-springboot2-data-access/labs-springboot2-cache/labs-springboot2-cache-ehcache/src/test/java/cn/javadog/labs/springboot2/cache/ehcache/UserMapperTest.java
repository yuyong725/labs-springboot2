package cn.javadog.labs.springboot2.cache.ehcache;

import java.util.Date;
import java.util.UUID;

import cn.javadog.labs.springboot2.cache.ehcache.dataobject.UserDO;
import cn.javadog.labs.springboot2.cache.ehcache.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    private static final String CACHE_NAME_USER = "users";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void testCacheManager() {
        System.out.println(cacheManager);
    }

    @Test
    public void testSelectById() {
        // userMapper 启动时已经放进去了一条ID为1的数据
        Integer id = 1;
        // 查询 id = 1 的记录
        UserDO user = userMapper.selectById(id);
        System.out.println("user：" + user);
        // 判断缓存中，是不是存在
        Assert.assertNotNull("缓存为空", cacheManager.getCache(CACHE_NAME_USER).get(user.getId(), UserDO.class));

        // 查询 id = 1 的记录
        user = userMapper.selectById(id);
        System.out.println("user：" + user);
    }

    @Test
    public void testInsert() {
        // 插入记录
        UserDO user = new UserDO()
            .setId(2)
            .setUsername(UUID.randomUUID().toString())
            .setPassword("pwd")
            .setCreateTime(new Date())
            .setDeleted(0);
        userMapper.insert(user);

        // 判断缓存中，是不是存在
        Assert.assertNotNull("缓存为空", cacheManager.getCache(CACHE_NAME_USER).get(user.getId(), UserDO.class));
    }

    @Test
    public void testDeleteById() {
        // 插入记录，为了让缓存里有记录
        testInsert();
        // 删除记录，为了让缓存被删除
        userMapper.deleteById(2);
        // 判断缓存中，是不是存在
        Assert.assertNull("缓存不为空", cacheManager.getCache(CACHE_NAME_USER).get(2, UserDO.class));
    }

}
