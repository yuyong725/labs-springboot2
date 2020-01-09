package cn.javadog.labs.springboot2.redis.jedis.dao.redis;

import javax.annotation.Resource;

import cn.javadog.labs.springboot2.redis.jedis.cacheobject.UserCacheObject;
import cn.javadog.labs.springboot2.redis.jedis.util.JSONUtil;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * @author 余勇
 * @date 2020-01-09 17:14
 * 缓存dao
 */
@Repository
public class UserCacheDao {

    /**
     * user:用户编号
     */
    private static final String KEY_PATTERN = "user:%d";

    @Resource(name = "redisTemplate")
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private ValueOperations<String, String> operations;

    private static String buildKey(Integer id) {
        return String.format(KEY_PATTERN, id);
    }

    public UserCacheObject get(Integer id) {
        String key = buildKey(id);
        String value = operations.get(key);
        return JSONUtil.parseObject(value, UserCacheObject.class);
    }

    public void set(Integer id, UserCacheObject object) {
        String key = buildKey(id);
        String value = JSONUtil.toJSONString(object);
        operations.set(key, value);
    }

}
