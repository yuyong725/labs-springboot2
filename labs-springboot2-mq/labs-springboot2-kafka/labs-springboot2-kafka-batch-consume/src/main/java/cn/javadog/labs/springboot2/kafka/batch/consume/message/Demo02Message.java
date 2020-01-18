package cn.javadog.labs.springboot2.kafka.batch.consume.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-17 22:26
 * 示例 01 的 Message 消息
 */
@Data
@Accessors(chain = true)
public class Demo02Message {

    public static final String TOPIC = "DEMO_02";

    /**
     * 编号
     */
    private Integer id;

}
