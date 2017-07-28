package com.xiaomi.example.web.test;

import java.lang.reflect.ParameterizedType;

/**
 * Created by liujin on 2017/8/1.
 */
public class SomeTest<T, T1>{

    public Class getObject() {
        Class entityClass = (Class) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[1];
                return entityClass;
    }
}
