package cn.javadog.labs.springboot2.redis.jedis.util;

import com.alibaba.fastjson.JSON;

/**
 * @author 余勇
 * @date 2020-01-09 17:13
 * JSON 工具类
 */
public class JSONUtil {

    public static  <T> T parseObject(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    public static String toJSONString(Object javaObject) {
        return JSON.toJSONString(javaObject);
    }

    public static byte[] toJSONBytes(Object javaObject) {
        return JSON.toJSONBytes(javaObject);
    }

}
