package cn.javadog.labs.springboot2.kafka.transaction.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-18 00:45
 * 示例 07 的 Message 消息
 */
@Data
@Accessors(chain = true)
public class Demo07Message {

    public static final String TOPIC = "DEMO_07";

    /**
     * 编号
     */
    private Integer id;

}
