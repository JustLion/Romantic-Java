package com.liang.erhua.designpattern.single;

/**
 * @author liangjia
 * @version 1.0
 * @date 22:00/2020-03-22
 * @description 饿汉式单例 ，加final更狠一些
 */
public class Singleton1 {
    private static final Singleton1 singleton = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return singleton;
    }
}
