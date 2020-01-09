package cn.javadog.labs.springboot2.cache.ehcache.mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import cn.javadog.labs.springboot2.cache.ehcache.dataobject.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author 余勇
 * @date 2020-01-08 21:24
 * 数据mapper，这里拿的假数据
 */
@Slf4j
@Component
@CacheConfig(cacheNames = "users")
public class UserMapper {

    Map<Integer, UserDO> FAKE_DB = new HashMap<>();

    public UserMapper() {
        FAKE_DB.put(1,
            new UserDO()
                .setId(1)
                .setUsername(UUID.randomUUID().toString())
                .setPassword("pwd")
                .setCreateTime(new Date())
                .setDeleted(0));
    }

    @Cacheable(key = "#id")
    public UserDO selectById(Integer id){
        log.info("=====================> 查询id为[{}]的数据，走的数据库", id);
        return FAKE_DB.get(id);
    }

    @CachePut(key = "#user.id")
    public UserDO insert(UserDO user) {
        // 插入记录
        FAKE_DB.put(user.getId(), user);
        log.info("=====================> 插入id为[{}]的数据到数据库", user.getId());
        // 返回用户
        return user;
    }

    @CacheEvict(key = "#id")
    public int deleteById(Integer id){
        log.info("=====================> 从数据库删除id为[{}]的数据", id);
        return FAKE_DB.remove(id) == null ? 0 : 1;
    }

}
