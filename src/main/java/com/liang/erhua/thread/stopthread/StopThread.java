package com.liang.erhua.thread.stopthread;

/**
 * @author liangjia
 * @version 1.0
 * @date 22:37/2020-01-19
 * @description
 */
public class StopThread implements Runnable{

    private boolean flag = true;

    @Override
    public synchronized void run() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                flag = false;
                System.out.println("抛异常啦");
            }
            System.out.println(Thread.currentThread().getName() + "...run");
        }
    }

    public void changeFlag() {
        flag = false;
    }
}
