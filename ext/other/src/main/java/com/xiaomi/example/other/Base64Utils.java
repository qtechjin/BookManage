package com.xiaomi.example.other;


import org.apache.commons.codec.binary.Base64;
import org.codehaus.groovy.runtime.powerassert.SourceText;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by liujin on 2017/7/13.
 */
public class Base64Utils {


    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");


        String date = df.format(new BigDecimal(11));
        System.out.println(date);
    }
}
