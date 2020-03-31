package com.liang.erhua.jdk8.base;

/**
 * @author liangjia
 * @version 1.0
 * @date 00:00/2019-11-28
 * @description
 */
public class Letter {

    public static String addHeader(String text){
        return "From Raoul, Mario and Alan: " + text;
    }
    public static String addFooter(String text){
        return text + " Kind regards";
    }
    public static String checkSpelling(String text){
        return text.replaceAll("labda", "lambda");
    }
}
