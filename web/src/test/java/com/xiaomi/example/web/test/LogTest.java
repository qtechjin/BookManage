package com.xiaomi.example.web.test;

import com.xiaomi.example.core.service.MemCacheService;
import org.apache.log4j.Logger;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by liujin on 2017/7/6.
 */
public class LogTest extends BaseTest{

    @Resource
    private MemCacheService memCacheService;
    Logger logger = Logger.getLogger(LogTest.class);

    @Test
    public void testMem(){

        int len = 12;
        long xxx = (long)Math.pow(10,len);
        long num = 8845345345345435789L;
        long ggg = num%xxx;
        System.out.println(ggg);
        String sql = String.format("%0"+len+"d", ggg);
        System.out.println(sql);

    String xml = "src/main/resources/reportModel/ddd.xml";
    String path = xml.substring(0, xml.lastIndexOf("/")+1);
        System.out.println(path);
    }
    private boolean isVal(String sql) throws Exception{
//        Assert.isNull(sql, "输入bixuwei空");
        if(sql != null) {
            throw new NumberFormatException("输入bixuwei空");
        }
        System.out.println(sql);
        return true;
    }

}
