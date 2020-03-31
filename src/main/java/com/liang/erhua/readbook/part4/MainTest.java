package com.liang.erhua.readbook.part4;

import java.util.concurrent.*;

/**
 * @author ${user}
 * @version 1.0
 * @date ${time}/${date}
 */
public class MainTest {
    ScheduledExecutorService stpe;
    ScheduledFuture<?> hndl;//取消时需要

    BlockingQueue<WorkUnit<String>> lbq = new LinkedBlockingQueue<>();
    private void run(){
        stpe = Executors.newScheduledThreadPool(2);//执行者的工厂方法

        final Runnable msgReader = new Runnable(){
            @Override
            public void run(){
                /*String nextMsg = lbq.poll().getWork();
                if (nextMsg != null) {
                    System.out.println("Msg recvd: "+ nextMsg);
                }*/
            }
        };
        hndl = stpe.scheduleAtFixedRate(msgReader, 10, 10,
                TimeUnit.MILLISECONDS);
    }

    public void cancel() {
        final ScheduledFuture<?> myHndl = hndl;

        stpe.schedule(new Runnable() {
            @Override
            public void run() { myHndl.cancel(true); }//取消时需要
        }, 10, TimeUnit.MILLISECONDS);
    }
}
