package com.xiaomi.example.web.test;

import java.util.Date;

/**
 * Created by liujin on 2017/7/18.
 */
public class TestClone {

    public static void main(String[] args) throws CloneNotSupportedException {
        User user1 = new User("starrysky", "starrysky", new Date());
        User user2 = user1;//创建一个引用
        User user3 = (User)user1.clone();//克隆一个对象

        System.out.println("user1=user2:"+(user1==user2));
        System.out.println("user1.equals(user2):"+(user1.equals(user2)));


        System.out.println(user1.toString());
        System.out.println(user3.toString());
        System.out.println("user1=user3:"+(user1==user3));
        System.out.println("user1.equals(user3):"+(user1.equals(user3)));

        User u1 = new User("Kent", "123456", new Date());
        User u2 = u1;
        User u3 = (User) u1.clone();

        System.out.println(u1 == u2);		// true
        System.out.println(u1.equals(u2));	// true

        System.out.println(u1 == u3);		// false
        System.out.println(u1.equals(u3));	// true
    }
}
