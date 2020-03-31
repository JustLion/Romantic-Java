package com.liang.erhua.thread.base;

import org.apache.log4j.Logger;

import java.lang.invoke.MethodHandles;

/**
 * @author liangjia
 * @version 1.0
 * @date 11:21/2020-01-18
 * @description
 */
public class NewThread1 extends Thread {

    private static final Logger logger =
            Logger.getLogger(MethodHandles.lookup().lookupClass());

    public NewThread1() {
        super("线程例子");
        System.out.println("子线程：" + this);
        start();
    }

    @Override
    public void run() {

        try{
            for (int i = 5; i > 0; i--) {
                System.out.println("子线程：" + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            logger.error("线程沉睡发生异常",e);
        }
        System.out.println("子线程退出");
    }

}
class ExtendThread{

    private static final Logger logger =
            Logger.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        NewThread1 newThread1 = new NewThread1();
        Thread.State state = newThread1.getState();
        try{
            for (int i = 5; i > 0; i--) {
                System.out.println("主线程：" + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            logger.error("线程沉睡发生异常",e);
        }
        System.out.println("主线程退出");
    }

}
