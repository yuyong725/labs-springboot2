package cn.javadog.labs.springboot2.kafka.concurrency.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-17 23:45
 * 示例 06 的 Message 消息
 */
@Data
@Accessors(chain = true)
public class Demo06Message {

    public static final String TOPIC = "DEMO_06";

    /**
     * 编号
     */
    private Integer id;

}
