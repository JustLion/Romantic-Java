package com.liang.erhua.thread.stopthread;

/**
 * @author liangjia
 * @version 1.0
 * @date 22:39/2020-01-19
 * @description 要想将多线程停止，要将多线程设置为守护线程，其他线程退出虚拟机就退出了。或者将两个线程interrupt();
 * join() 方法的线程要cpu执行权，其他线程会释放执行权，优先执行该线程，直到该线程执行结束才会执行别的线程方法。
 */
public class StopThreadDemo {
    public static void main(String[] args) {
        StopThread stopThread = new StopThread();
        Thread t1 = new Thread(stopThread);
        Thread t2 = new Thread(stopThread);

        // 将t1和t2设置为守护线程
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();

        int num = 0;
        while (true) {
            if (num++ == 60) {
               /* stopThread.changeFlag();
                t1.interrupt();
                t2.interrupt();*/
                break;
            }
            System.out.println(Thread.currentThread().getName() + "....." + num);
        }
        System.out.println("over");
    }

    /**
     * interrupt()方法的用法
     */
    public void interruptThread() {
        StopThread stopThread = new StopThread();
        Thread t1 = new Thread(stopThread);
        Thread t2 = new Thread(stopThread);

        t1.start();
        t2.start();

        int num = 0;
        while (true) {
            if (num++ == 60) {
                stopThread.changeFlag();
                t1.interrupt();
                t2.interrupt();
                break;
            }
            System.out.println(Thread.currentThread().getName() + "....." + num);
        }
        System.out.println("over");
    }

    /**
     * 设置线程的优先级和yield()方法
     */
    public void setPriority() {
        StopThread stopThread = new StopThread();
        Thread t1 = new Thread(stopThread);
        Thread t2 = new Thread(stopThread);

        t1.start();
        t2.start();
        //设置线程的优先级 10,1,5
        /*t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.setPriority(Thread.NORM_PRIORITY);*/

        int num = 0;
        while (true) {
            // 释放线程的执行权
            Thread.yield();
            if (num++ == 60) {
                stopThread.changeFlag();
                break;
            }
            System.out.println(Thread.currentThread().getName() + "....." + num);
        }
        System.out.println("over");
    }
}
