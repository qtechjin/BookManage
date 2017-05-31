package com.xiaomi.example.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by liujin on 5/31/17.
 */
public class MessageSender {

    private String url;
    private String user;
    private String password;
    private final String QUEUE_NAME;

    public MessageSender(String url, String user, String password, String queueName) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.QUEUE_NAME = queueName;
    }

    public void sendMessage(String message) {
        //构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
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
            session = connection.createSession(Boolean.TRUE, Session.SESSION_TRANSACTED);
            // 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
            destination = session.createQueue(QUEUE_NAME);
            // 得到消息生成者【发送者】
            MessageProducer producer = session.createProducer(destination);
            // 设置不持久化，此处学习，实际根据项目决定
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            // 构造消息，此处写死，项目就是参数，或者方法获取

            session.commit();
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
                if(null != connection) {
                    connection.close();
                }
            } catch (Exception e) {

            }
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
