package com.xiaomi.example.other;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by liujin on 2017/8/8.
 */
public class OtherTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS sss");
        Date date = getBusinessDate(new Date());
        System.out.println(sdf.format(date));

        date = getStartDate(date);
        System.out.println(sdf.format(date));

        date = getEndDate(date);
        System.out.println(sdf.format(date));

    }

    private static Date getBusinessDate1(Date handleDate) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(handleDate);
        ca.set(Calendar.MONTH, ca.get(Calendar.MONTH)-1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        try {
            Date date = sdf.parse(sdf.format(ca.getTime()));
            return date;
        } catch (ParseException e) {
            e.printStackTrace();

            return null;
        }
    }

    private static Date getBusinessDate(Date handleDate) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(handleDate);
        ca.set(Calendar.MONTH, ca.get(Calendar.MONTH) -1);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));

        return ca.getTime();
    }

    //根据bizDate获得当前批次的开始时间
    private static Date getStartDate( Date bizDate) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(bizDate);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMinimum(Calendar.DAY_OF_MONTH));
        return getDayBegin(ca.getTime());

        /*DateTime datetime = new DateTime();
        DateTime firstDayOfmonth = datetime.minusMonths(1).dayOfMonth().withMinimumValue().secondOfDay()
                .withMinimumValue();
        return firstDayOfmonth.toDate();*/
    }

    //获得当前批次的结束时间
    private static Date getEndDate(Date bizDate) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(bizDate);
        ca.set(Calendar.MONTH, ca.get(Calendar.MONTH) + 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMinimum(Calendar.DAY_OF_MONTH));
        return getDayBegin(ca.getTime());
        /*DateTime datetime = new DateTime();
        DateTime lastDayOfMonth = datetime.dayOfMonth().withMinimumValue().secondOfDay().withMinimumValue();
        return lastDayOfMonth.toDate();*/
    }

    /*
    * 获取一天的开始时间
    * */
    public static Date getDayBegin(Date date) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String dateString = df.format(date);

        try {
            return df.parse(dateString);
        } catch (ParseException e) {
            return date;
        }
    }
}
