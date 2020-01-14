package cn.javadog.labs.springboot2.rocketmq.simple.message;

/**
 * @author 余勇
 * @date 2020-01-14 09:47
 * 示例 03 的 Message 消息
 */
public class Demo03Message {

    public static final String TOPIC = "DEMO_03";

    /**
     * 编号
     */
    private Integer id;

    public Demo03Message setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Demo03Message{" +
                "id=" + id +
                '}';
    }

}
