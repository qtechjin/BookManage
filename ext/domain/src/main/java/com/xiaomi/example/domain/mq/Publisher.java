package com.xiaomi.example.domain.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by liujin on 6/1/17.
 */
public class Publisher {


    public static void publishTopic(String topicName, String message) {
        //构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar
        ActiveMQConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("liujin", "123", "tcp://localhost:61616");
        // ConnectionFactory ：连接工厂，JMS 用它创建连接
        // Connection ：JMS 客户端到JMS Provider 的连接
        // Session： 一个发送或接收消息的线程
        // Destination ：消息的目的地;消息发送给谁.
        // MessageProducer：消息发送者
        Session session = null;
        Destination destination;
        Connection connection = null;
        try {

            // 构造从工厂得到连接对象
            connection = connectionFactory.createConnection();
            // 启动
            connection.start();
            // 获取操作连接
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            // 获取session注意参数值是一个服务器的topic，须在在ActiveMq的console配置
            destination = session.createTopic(topicName);
            // 得到消息生成者【发送者】
            MessageProducer producer = session.createProducer(destination);
            // 设置不持久化，此处学习，实际根据项目决定
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            // 构造消息，此处写死，项目就是参数，或者方法获取
            TextMessage outMessage = session.createTextMessage();
            outMessage.setText(message);
            producer.send(outMessage);
            session.commit();
            producer.close();
            System.out.println("connection is close");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection) {
                    connection.close();
                }
            } catch (Exception e) {

            }
        }
    }
}
