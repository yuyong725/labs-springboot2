package cn.javadog.labs.springboot2.kafka.simple.message;

/**
 * @author 余勇
 * @date 2020-01-17 12:21
 * 示例 01 的 Message 消息
 */
public class Demo01Message {

    public static final String TOPIC = "DEMO_01";

    /**
     * 编号
     */
    private Integer id;

    public Demo01Message setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Demo01Message{" +
                "id=" + id +
                '}';
    }

}
