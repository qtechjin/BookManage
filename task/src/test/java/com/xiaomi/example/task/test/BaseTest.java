package com.xiaomi.example.task.test;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

/**
 * Created by liujin on 2017/7/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/app*.xml")
public class BaseTest {
    private Logger logger = Logger.getLogger(BaseTest.class);

    static {
        try {
            Log4jConfigurer.initLogging("classpath:config/log4j.xml");
        } catch (Exception e) {
            System.err.println("init log4j error");
        }
    }


}
