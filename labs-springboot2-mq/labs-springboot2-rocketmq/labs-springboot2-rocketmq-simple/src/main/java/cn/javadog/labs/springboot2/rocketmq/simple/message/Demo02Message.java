package cn.javadog.labs.springboot2.rocketmq.simple.message;

/**
 * @author 余勇
 * @date 2020-01-14 09:47
 * 示例 02 的 Message 消息
 */
public class Demo02Message {

    public static final String TOPIC = "DEMO_02";

    /**
     * 编号
     */
    private Integer id;

    public Demo02Message setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Demo02Message{" +
                "id=" + id +
                '}';
    }

}
