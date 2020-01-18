package cn.javadog.labs.springboot2.activemq._native;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @author 余勇
 * @date 2020-01-18 23:54
 */
public class ActiveMQProducer {

    private static final String BROKER_URL = "tcp://127.0.0.1:61616";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    /**
     * 只有 QUEUE_NAME 需要共享给 ActiveMQConsumer
     */
    private static final String QUEUE_NAME = "queue_demo";

    public static void main(String[] args) throws JMSException {
        // 创建连接
        Connection connection = getConnection();

        // 创建会话
        Session session = getSession(connection);

        // 创建队列
        Queue queue = getQueue(session);

        // 创建 Producer
        MessageProducer producer = session.createProducer(queue);

        // 发送 3 条消息
        for (int i = 0; i < 3; i++) {
            Message message = session.createTextMessage("Hello World" + i);
            producer.send(message);
        }

        // 关闭
        session.close();
        connection.close();
    }

    public static Connection getConnection() throws JMSException {
        // 创建连接
        ConnectionFactory factory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);
        Connection connection = factory.createConnection();
        // 启动连接
        connection.start();
        return connection;
    }

    public static Session getSession(Connection connection) throws JMSException {
        // 第一个方法参数 transacted ，是否开启事务。这里设置为 false ，无需开启
        // 第二个方法参数 acknowledgeMode ，确认模式。这里设置为 AUTO_ACKNOWLEDGE ，自动确认。推荐阅读 https://my.oschina.net/thinwonton/blog/995291
        return connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    public static Queue getQueue(Session session) throws JMSException {
        return session.createQueue(QUEUE_NAME);
    }

}
