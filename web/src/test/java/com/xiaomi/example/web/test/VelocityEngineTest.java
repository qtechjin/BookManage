package com.xiaomi.example.web.test;

import com.xiaomi.example.core.common.utils.ContentVelocityTemplate;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liujin on 2017/8/3.
 */

public class VelocityEngineTest extends BaseTest{

    @Resource
    private ContentVelocityTemplate testVelocityEngine;

    @Test
    public void testgg(){
        Map map = new HashMap();
        map.put("username", "liujin");
        map.put("age", 14);
        map.put("email", "liujin@gg.com");
        String content = testVelocityEngine.getContent(map);

        System.out.println("模板内容为：\n" + content);
    }
}
