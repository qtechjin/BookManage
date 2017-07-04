package com.xiaomi.example.bm.ext.task;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liujin on 17-6-9.
 */
public class HelloTask {
    public void execute(){

        VelocityEngineFactoryBean factoryBean = new VelocityEngineFactoryBean();
        factoryBean.setResourceLoaderPath("classpath:META-INF/velocity");

        VelocityEngine engine = factoryBean.getObject();



        Map<String, Object> data = new HashMap<String, Object>();
        data.put("name", "liujin");
        data.put("age", 19);
        data.put("gender", "男");
        String gg = VelocityEngineUtils.mergeTemplateIntoString(engine, "hello.vm", "UTF-8", data);

        System.out.println("模板生成字符串:" + gg);
        String sql = "nihao";
        System.out.println("打印helloworld!");
        sql += "1";
        System.out.println(sql);
    }
}
