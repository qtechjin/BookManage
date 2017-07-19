package com.xiaomi.example.task.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by liujin on 2017/7/6.
 */
public class LogTest extends BaseTest{



    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        String sql="ddd";
        String jsql="ddd";
        logger.info("你這是{}什麼 {}", sql, jsql);

    }
    @Test
    public void testMem(){

    }

}
