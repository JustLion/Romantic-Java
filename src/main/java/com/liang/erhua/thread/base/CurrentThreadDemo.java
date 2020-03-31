package com.liang.erhua.thread.base;

import org.apache.log4j.Logger;

import java.lang.invoke.MethodHandles;

/**
 * @author liangjia
 * @version 1.0
 * @date 10:53/2020-01-18
 * @description
 */
public class CurrentThreadDemo {

    private static final Logger logger =
            Logger.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("current thread:" + thread);
        // 改变线程的名字
        thread.setName("my thread");
        System.out.println("改变名字后：" + thread);
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            logger.error("线程沉睡发生异常",e);
        }
    }
}
