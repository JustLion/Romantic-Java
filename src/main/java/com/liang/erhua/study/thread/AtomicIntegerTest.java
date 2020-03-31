package com.liang.erhua.study.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liangjia
 * @version 1.0
 * @date 21:05/2019-10-21
 * @description
 */
public class AtomicIntegerTest {

    private AtomicInteger count = new AtomicInteger();

    public void increment(){
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }

}
