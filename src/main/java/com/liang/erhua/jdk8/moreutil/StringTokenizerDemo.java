package com.liang.erhua.jdk8.moreutil;

import java.util.*;

/**
 * @author liangjia
 * @version 1.0
 * @date 16:15/2020-02-20
 * @description
 */
public class StringTokenizerDemo {
    public static void main(String[] args) {
        dateDemo();
    }

    public static void stringTokenizerDemo() {
        String str = "title=java:the complete reference;author=liangjia;publisher=liangjia;copyright=2014";
        StringTokenizer tokenizer = new StringTokenizer(str,"=;");
        while (tokenizer.hasMoreElements()) {
            String key = tokenizer.nextToken();
            String value = tokenizer.nextToken();
            System.out.println(key + "\t" + value);
        }
    }

    public static void bitSetDemo() {
        BitSet bitSet1 = new BitSet(16);
        BitSet bitSet2 = new BitSet(16);
        for (int i = 0; i < 16; i++) {
            if (i % 2 == 0) {
                bitSet1.set(i);
            }
            if (i % 5 != 0) {
                bitSet2.set(i);
            }
        }
        bitSet2.and(bitSet1);
        System.out.println(bitSet2);
        bitSet2.or(bitSet1);
        System.out.println(bitSet2);
        bitSet2.xor(bitSet1);
        System.out.println(bitSet2);
    }

    public static void optionalDemo() {
        Optional<String> opEmpty = Optional.empty();
        Optional<String> opHas = Optional.of("ABCDEFG");
        if (opEmpty.isPresent()) {
            System.out.println("this won't be displayed");
        }else {
            System.out.println("opEmpty is no value");
        }
        if (opHas.isPresent()) {
            System.out.println("the string opHas is:" + opHas.get());
        }
        String aDefault = opEmpty.orElse("default");
        System.out.println(aDefault);
    }

    public static void dateDemo() {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime() + "----" + System.currentTimeMillis());
    }

    public static void calendarDemo() {
        String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        Calendar calendar = Calendar.getInstance();
        System.out.println(months[calendar.get(Calendar.MONTH)]);
        
    }
}
