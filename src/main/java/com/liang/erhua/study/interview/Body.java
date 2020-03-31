package com.liang.erhua.study.interview;

/**
 * @author liangjia
 * @version 1.0
 * @date 22:04/2020-03-04
 * @description
 */
public class Body implements Cloneable {
    public Head head;

    public Body(Head head) {
        this.head = head;
    }

    public Body() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Body body = (Body) super.clone();
        body.head = (Head) super.clone();
        return body;
    }
}
