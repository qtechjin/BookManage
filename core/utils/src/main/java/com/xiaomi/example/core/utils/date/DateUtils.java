package com.xiaomi.example.core.utils.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liujin on 2017/11/7.
 */
public class DateUtils {
    private static final String LONG_DATE_STRING ="yyyy-MM-dd hh:mm:ss,SSS";

    public static String getLongDateString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(LONG_DATE_STRING);
        return sdf.format(date);
    }
}
