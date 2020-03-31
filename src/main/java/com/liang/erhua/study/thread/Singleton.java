package com.liang.erhua.study.thread;

/**
 * @author liangjia
 * @version 1.0
 * @date 22:46/2019-10-18
 * @description
 */
public class Singleton {

    /**使用 volatile 可以禁止 JVM 的指令重排*/
    private volatile static Singleton uniqueInstance;

    private Singleton() {

    }

    public static Singleton getUniqueInstance() {
        //先判断对象是否已经实例化过，没有实例化的话再实例化
        if (uniqueInstance == null) {
            // 类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    /**
                    * 这段代码分为3步执行
                    * 1. 为 uniqueInstance 分配内存空间
                    * 2. 初始化 uniqueInstance
                    * 3. 将 uniqueInstance 指向分配的内存地址
                    * JVM 具有指令重排的特性，执行顺序有可能变成 1->3->2
                    * 单线程环境下没有问题，但是多线程环境下会导致一个线程获取到没有初始化的实例
                    */
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

}
