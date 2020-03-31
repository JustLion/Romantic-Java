package com.liang.erhua.thread.proandcon;


/**
 * @author liangjia
 * @version 1.0
 * @date 22:21/2020-01-19
 * @description
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Producer producer = new Producer(resource);
        ConSumer conSumer = new ConSumer(resource);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(producer);
        Thread t3 = new Thread(conSumer);
        Thread t4 = new Thread(conSumer);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
