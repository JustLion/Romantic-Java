package com.liang.erhua.study.interview;

/**
 * @author liangjia
 * @version 1.0
 * @date 10:10/2020-03-30
 * @description
 */
public class ThreadDemo {

    private static volatile int num = 100;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    num++;
                    System.out.println(num);
                }
            }
        },"线程1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    num++;
                    System.out.println(num);
                }
            }
        },"线程2").start();
    }
}
