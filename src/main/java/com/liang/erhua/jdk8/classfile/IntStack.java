package com.liang.erhua.jdk8.classfile;

/**
 * @author liangjia
 * @version 1.0
 * @date 22:23/2020-01-17
 * @description
 */
public interface IntStack {
    void push(int item);
    int pop();
    default void clear(){
        System.out.println("clear() not implemented");
    }
}
