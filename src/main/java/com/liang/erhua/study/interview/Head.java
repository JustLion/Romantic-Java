package com.liang.erhua.study.interview;

/**
 * @author liangjia
 * @version 1.0
 * @date 22:06/2020-03-04
 * @description
 */
public class Head implements Cloneable {
    public Face face;

    public Head() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
