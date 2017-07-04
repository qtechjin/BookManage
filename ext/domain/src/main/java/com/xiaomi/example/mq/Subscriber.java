package com.xiaomi.example.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by liujin on 17-6-1.
 */
public class Subscriber {

    public static void subsribe(String topicName) {
        //订阅一个发布
        //连接工厂，JMS用它创建连接
        ConnectionFactory connectionFactory;
        //JMS客户端到服务端的连接
        Connection connection = null;
        //session，一个发送或接收消息的县城
        Session session;
        //消息目的地，消息发送到哪或从哪接收
        Destination destination;
        MessageConsumer consumer;
        try {
            connectionFactory = new ActiveMQConnectionFactory("liujin", "123", "tcp://localhost:61616");
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic(topicName);
            consumer = session.createConsumer(topic);
            consumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    TextMessage tm = (TextMessage) message;
                    try {
                        System.out.println(tm.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
            while(true);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != connection){
                    connection.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }


    }
}
