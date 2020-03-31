package com.liang.erhua.study.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author liangjia
 * @version 1.0
 * @date 21:49/2019-10-23
 * @description
 */
public class AqsTest extends AbstractQueuedSynchronizer {
    public static void main(String[] args) {
        Collections.synchronizedMap(new HashMap<>());
    }


    private static void printEncode() {
        
    }
}
