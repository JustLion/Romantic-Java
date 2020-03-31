package com.liang.erhua.study;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Liang
 * @version 0.01
 * @date  2019/04/23 19:00:00
 */
public class CalendarTest {
    public static void main(String[] args) throws ParseException {
        formatDate();
    }

    private static void getOneHourAgo() throws ParseException {
        String dateStr = "2019-11-02 00:00:00";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(format.parse(dateStr));
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) -1);
        String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY) + 1);
        format = new SimpleDateFormat("yyyyMMdd");
        String date = format.format(calendar.getTime());
        System.out.println(date);
        System.out.println(hour);
    }


    private static void getCalendar() {
        Calendar instance = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault(Locale.Category.FORMAT));
        Calendar calendar = Calendar.getInstance();
        System.out.println(Calendar.getInstance(TimeZone.getDefault()).after("2019"));
        System.out.println(Locale.getDefault(Locale.Category.FORMAT).getCountry());
        TimeZone timeZone = new SimpleTimeZone(720,"CN");
        System.out.println(timeZone.inDaylightTime(new Date()));
        System.out.println(calendar.getFirstDayOfWeek());
    }


    private static void formatDate() {
        long time = System.currentTimeMillis();
        //获取两个小时前的时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(time));
        calendar.set(Calendar.HOUR_OF_DAY,calendar.get(Calendar.HOUR_OF_DAY) - 2);

        DateFormat format = new SimpleDateFormat("截至yyyy年MM月dd日HH时00分00秒，您的指标数据为：");
        String format1 = format.format(new Date(time));
        System.out.println(format1);
    }

}
