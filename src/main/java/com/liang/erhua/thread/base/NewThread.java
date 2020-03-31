package com.liang.erhua.thread.base;

import org.apache.log4j.Logger;

import java.lang.invoke.MethodHandles;

/**
 * @author liangjia
 * @version 1.0
 * @date 11:10/2020-01-18
 * @description
 */
public class NewThread implements Runnable {

    private static final Logger logger =
            Logger.getLogger(MethodHandles.lookup().lookupClass());

    Thread thread;

    public NewThread() {
        thread = new Thread(this,"demo thread");
        System.out.println("子线程 :" + thread);
        thread.start();
    }

    @Override
    public void run() {
        try{
            for (int i = 5; i > 0; i--) {
                System.out.println("子线程:" + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e ) {
            logger.error("线程沉睡发生异常",e);
        }
        System.out.println("子线程退出");
    }
}
