package cn.javadog.labs.springboot2.rocketmq.simple.message;

/**
 * @author 余勇
 * @date 2020-01-14 09:48
 * 示例 05 的 Message 消息
 */
public class Demo05Message {

    public static final String TOPIC = "DEMO_05";

    /**
     * 编号
     */
    private Integer id;

    public Demo05Message setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Demo05Message{" +
                "id=" + id +
                '}';
    }

}
