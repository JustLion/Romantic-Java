package com.liang.erhua.designpattern.single;

/**
 * @author liangjia
 * @version 1.0
 * @date 22:02/2020-03-22
 * @description 单例模式，懒汉式
 */
public class Singleton2 {
    private static volatile Singleton2 instance = null;

    private Singleton2(){
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }

        return  instance;
    }
}
