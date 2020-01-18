package cn.javadog.labs.springboot2.kafka.broadcast.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-17 23:17
 * 示例 05 的 Message 消息
 */
@Data
@Accessors(chain = true)
public class Demo05Message {

    public static final String TOPIC = "DEMO_05";

    /**
     * 编号
     */
    private Integer id;

}
