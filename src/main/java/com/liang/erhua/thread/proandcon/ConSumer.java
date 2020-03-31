package com.liang.erhua.thread.proandcon;

/**
 * @author liangjia
 * @version 1.0
 * @date 22:19/2020-01-19
 * @description
 */
public class ConSumer implements Runnable {

    private Resource resource;

    public ConSumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            resource.out();
        }
    }
}
