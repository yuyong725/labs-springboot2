package cn.javadog.labs.springboot2.activemq._native;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

/**
 * @author 余勇
 * @date 2020-01-18 23:54
 */
public class ActiveMQConsumer {

    public static void main(String[] args) throws JMSException {
        // 创建连接
        Connection connection = ActiveMQProducer.getConnection();

        // 创建会话
        final Session session = ActiveMQProducer.getSession(connection);

        // 创建队列
        Queue queue = ActiveMQProducer.getQueue(session);

        // 创建 Consumer
        MessageConsumer consumer = session.createConsumer(queue);

        consumer.setMessageListener(message -> {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println(String.format("[线程：%s][消息编号：%s][消息内容：%s]",
                        Thread.currentThread(), textMessage.getJMSMessageID(), textMessage.getText()));
            } catch (JMSException e) {
                throw new RuntimeException(e);
            }
        });

        // 关闭
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException ignore) {
        }
        session.close();
        connection.close();
    }

}
