package com.liang.erhua.thread.proandcon;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liangjia
 * @version 1.0
 * @date 22:08/2020-01-19
 * @description
 */
public class Resource {

    private String name;
    private int count = 1;
    private boolean flag = false;

    private Lock lock = new ReentrantLock();

    private Condition conditionPro = lock.newCondition();
    private Condition conditionCon = lock.newCondition();

    public void setName(String name) {
        lock.lock();
        try {
            while (flag) {
                conditionPro.await();
            }
            this.name = name + "...." + count++;
            System.out.println(Thread.currentThread().getName() + "---生产者---" + this.name);
            flag = true;
            conditionCon.signalAll();
        }catch (InterruptedException e) {
            System.out.println("锁等待异常");
        }finally {
            lock.unlock();
        }
    }

    public void out() {
        lock.lock();
        try {
            while (!flag) {
                conditionCon.await();
            }
            System.out.println(Thread.currentThread().getName() + "........" +
                    "消费者......." + this.name);
            flag = false;
            conditionPro.signalAll();
        }catch (InterruptedException e) {
            System.out.println("锁等待异常");
        } finally {
            lock.unlock();
        }
    }
}
