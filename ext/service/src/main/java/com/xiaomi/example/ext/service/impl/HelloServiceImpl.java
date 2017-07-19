package com.xiaomi.example.ext.service.impl;

import com.google.gson.Gson;
import com.xiaomi.example.ext.service.HelloException;
import com.xiaomi.example.ext.service.HelloWordService;
import com.xiaomi.example.ext.service.Person;
import org.apache.thrift.TException;

/**
 * Created by liujin on 2017/7/11.
 */
public class HelloServiceImpl implements HelloWordService.Iface {
    @Override
    public String sayHello(Person person) throws HelloException, TException {
        Gson gson = new Gson();

        System.out.println(gson.toJson(person));
        return person.getName();
    }
}
