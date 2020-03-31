package com.liang.erhua.study.thread;

import java.util.concurrent.*;

/**
 * @author liangjia
 * @version 1.0
 * @date 20:42/2019-10-21
 * @description
 */
public class ExecutorCreate {
    public static void main(String[] args) {

    }

    private static void createExecutors() {
        ExecutorService service = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });
    }
}
