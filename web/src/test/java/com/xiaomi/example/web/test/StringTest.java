package com.xiaomi.example.web.test;

import com.xiaomi.example.core.common.utils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;

/**
 * Created by liujin on 2017/8/1.
 */
public class StringTest extends SomeTest<BeanUtils, String> {



    @Test
    public void test() {
//        SomeTest<String> someTest = new SomeTest<>();
        Class<BeanUtils> obj = getObject();
    }
}
