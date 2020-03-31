package com.liang.erhua.study.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author liangjia
 * @version 1.0
 * @date 10:56/2020-02-26
 * @description
 */
public class TimeShow {
    public static void main(String[] args) {

    }

    public static void getDay() {
        // 获取今天的日期
        LocalDate today = LocalDate.now();
        System.out.println("今天的日期：" + today);
        // 获取年月日
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.println("今天是：" + year + "年" + month + "月" + day + "日");
        // 处理特定日期
        LocalDate date = LocalDate.of(2019, 2, 16);
        System.out.println("处理特定日期：" + date);
        // 判断两个日期是否相等
        boolean equals = today.equals(date);
        // 检查周期性事件
        MonthDay birthday = MonthDay.of(date.getMonth(), date.getDayOfMonth());
        MonthDay currentDay = MonthDay.from(today);
        if (birthday.equals(currentDay)) {
            System.out.println("今天是你的生日");
        }
        // 获取当前时间
        LocalTime time = LocalTime.now();
        System.out.println("当前时间不含有日期：" + time);
        // 计算一周后的日期
        LocalDate localDate = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("一周后的日期为：" + localDate);
        // 计算一年前或一年后的日期
        LocalDate minusYear = today.minus(1, ChronoUnit.YEARS);
        LocalDate plusYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("一年前的日期：" + minusYear + "，一年后的日期：" + plusYear);
        // clock时钟类
        Clock clock = Clock.systemUTC();
        System.out.println("时钟：" + clock.millis());
        Clock clock1 = Clock.systemDefaultZone();
        System.out.println("时钟：" + clock1.millis());
        // 判断日期是早于还是晚于另一个日期
        if (date.isAfter(today)) {
            System.out.println("这是之前的日期");
        }
        // 处理时区
        ZoneId zone = ZoneId.of("America/New_York");
        LocalDateTime usTime = LocalDateTime.now();
        ZonedDateTime usDateTime = ZonedDateTime.of(usTime, zone);
    }

    /**
     * 表示信用卡到期这类固定日期，答案就在YearMonth
     */
    public static void demo1() {
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpiry = YearMonth.of(2019, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
    }

    /**
     * 检查闰年
     */
    public static void demo2() {
        LocalDate today = LocalDate.now();
        if(today.isLeapYear()){
            System.out.println("This year is Leap year");
        }else {
            System.out.println("2018 is not a Leap year");
        }
    }

    /**
     * 计算两个日期之间的天数和月数
     */
    public static void demo3() {
        LocalDate today = LocalDate.now();

        LocalDate java8Release = LocalDate.of(2018, 12, 14);

        Period periodToNextJavaRelease = Period.between(today, java8Release);
        System.out.println("Months left between today and Java 8 release : "
                + periodToNextJavaRelease.getMonths() );
    }

    /**
     * 获取当前的时间戳
     */
    public static void demo4() {
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp.toEpochMilli());
    }

    /**
     * 使用预定义的格式化工具去解析或格式化日期
     */
    public static void demo5() {
        String dayAfterTommorrow = "20180205";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow,
                DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(dayAfterTommorrow+" 格式化后的日期为: "+formatted);
    }

    /**
     * 字符串互转日期类型
     */
    public static void demo6() {
        LocalDateTime date = LocalDateTime.now();

        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //日期转字符串
        String str = date.format(format1);

        System.out.println("日期转换为字符串:"+str);

        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //字符串转日期
        LocalDate date2 = LocalDate.parse(str,format2);
        System.out.println("日期类型:"+date2);
    }
}
