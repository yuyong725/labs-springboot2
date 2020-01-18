package cn.javadog.labs.springboot2.kafka.ack.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-18 11:07
 * 示例 08 的 Message 消息
 */
@Data
@Accessors(chain = true)
public class Demo08Message {

    public static final String TOPIC = "DEMO_08";

    /**
     * 编号
     */
    private Integer id;

}
