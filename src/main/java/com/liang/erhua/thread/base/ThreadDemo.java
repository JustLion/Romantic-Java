package com.liang.erhua.thread.base;

import org.apache.log4j.Logger;

import java.lang.invoke.MethodHandles;

/**
 * @author liangjia
 * @version 1.0
 * @date 11:15/2020-01-18
 * @description
 */
public class ThreadDemo {

    private static final Logger logger =
            Logger.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        new NewThread();

        try{
            for (int i = 5; i > 0; i--) {
                System.out.println("主线程"+i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            logger.error("主线程被打断",e);
        }
        System.out.println("主线程退出。");
    }
}
