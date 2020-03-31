package com.liang.erhua.jdk8.classfile;

/**
 * @author liangjia
 * @version 1.0
 * @date 22:55/2020-01-17
 * @description
 */
public interface DefaultMethod {
    int getNumber();

    /**
     * JDK8 以后接口可以定义默认方法实现，但是必须default修饰，在接口内实现该方法
     * @return
     */
    default String getString(){
        return "default string";
    }
}
