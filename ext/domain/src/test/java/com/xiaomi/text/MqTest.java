package com.xiaomi.text;

import com.xiaomi.example.mq.MessageReceiver;
import com.xiaomi.example.mq.MessageSender;
import com.xiaomi.example.mq.Publisher;
import com.xiaomi.example.mq.Subscriber;
import org.junit.Test;

/**
 * Created by liujin on 5/31/17.
 */
public class MqTest {

    @Test
    public void testProduce() {
        String url = "tcp://localhost:61616";
        String user = "liujin";
        String password = "admin";
        String queue = "myQueue";
        MessageSender ms =new MessageSender(url, user, password, queue);
        ms.sendMessage("register a user");
    }

    @Test
    public void testConsumer() {
        String url = "tcp://localhost:61616";
        String user = "liujin";
        String password = "admin";
        String queue = "myQueue";
        MessageReceiver mr =new MessageReceiver(url, user, password, queue);
        mr.receiveMessage();
    }

    @Test
    public void testPublish() {
        Publisher.publishTopic("MyTopic", "hello, liujin. 5 time");
    }

    @Test
    public void testSubscrib() {
        Subscriber.subsribe("MyTopic");
    }

    @Test
    public void testSubscrib2() {
        Subscriber.subsribe("MyTopic");
    }
}
