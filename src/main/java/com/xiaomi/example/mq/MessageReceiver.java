package com.xiaomi.example.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by liujin on 5/31/17.
 */
public class MessageReceiver {
    private String url;
    private String user;
    private String password;
    private final String QUEUE_NAME;

    public MessageReceiver(String url, String user, String password, String queueName) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.QUEUE_NAME = queueName;
    }

    // ConnectionFactory ：连接工厂，JMS 用它创建连接
    // Connection ：JMS 客户端到JMS Provider 的连接
    // Session： 一个发送或接收消息的线程
    // Destination ：消息的目的地;消息发送给谁.
    // MessageConsumer：消息接收者
    public String receiveMessage(){
        //构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);

        Session session = null;
        Destination destination;
        try {

            // 构造从工厂得到连接对象
            Connection connection = connectionFactory.createConnection();
            // 启动
            connection.start();
            // 获取操作连接
            session = connection.createSession(Boolean.TRUE, Session.SESSION_TRANSACTED);
            // 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
            destination = session.createQueue(QUEUE_NAME);
            // 得到消息生成者【发送者】
            MessageConsumer consumer = session.createConsumer(destination);

            while(true) {
                TextMessage message = (TextMessage) consumer.receive(10000);
                if(null != message) {
                    System.out.println("get message:" + message.getText());
                } else {
                    break;
                }
            }


        } catch (JMSException e) {
            e.printStackTrace();
        }

        return "";
    }
}
