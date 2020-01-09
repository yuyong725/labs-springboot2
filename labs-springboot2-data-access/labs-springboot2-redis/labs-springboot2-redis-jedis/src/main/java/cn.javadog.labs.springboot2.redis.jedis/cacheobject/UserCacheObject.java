package cn.javadog.labs.springboot2.redis.jedis.cacheobject;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-09 16:45
 * 用户缓存对象
 */
@Data
@Accessors(chain = true)
public class UserCacheObject {

    /**
     * 用户编号
     */
    private Integer id;

    /**
     * 昵称
     */
    private String name;

    /**
     * 性别
     */
    private Integer gender;

    @Override
    public String toString() {
        return "UserCacheObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

}
