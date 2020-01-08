package cn.javadog.labs.springboot2.cache.redis.mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import cn.javadog.labs.springboot2.cache.redis.dataobject.UserDO;
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
 * @Repository 只是为了避免IDEA飘红
 */
@Slf4j
@Component
@CacheConfig(cacheNames = "users")
public class UserMapper {

    Map<Integer, UserDO> CACHE_MAP = new HashMap<>();

    public UserMapper() {
        CACHE_MAP.put(1,
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
        return CACHE_MAP.get(id);
    }

    @CachePut(key = "#user.id")
    public UserDO insert(UserDO user) {
        // 插入记录
        CACHE_MAP.put(user.getId(), user);
        log.info("=====================> 插入id为[{}]的数据到数据库", user.getId());
        // 返回用户
        return user;
    }

    @CacheEvict(key = "#id")
    public int deleteById(Integer id){
        log.info("=====================> 从数据库删除id为[{}]的数据", id);
        return CACHE_MAP.remove(id) == null ? 0 : 1;
    }

}
