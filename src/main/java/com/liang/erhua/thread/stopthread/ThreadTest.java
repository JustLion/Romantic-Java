package com.liang.erhua.thread.stopthread;

/**
 * @author liangjia
 * @version 1.0
 * @date 23:09/2020-01-19
 * @description
 */
public class ThreadTest {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("线程的创建方法1");
                }
            }
        }.start();

        Runnable run = new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("线程的创建方法2");
                }
            }
        };
        new Thread(run).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("线程的创建方法3");
                }
            }
        }).start();

    }
}
