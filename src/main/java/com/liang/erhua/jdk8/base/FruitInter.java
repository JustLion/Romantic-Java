package com.liang.erhua.jdk8.base;

/**
 * @author liangjia
 * @version 1.0
 * @date 23:05/2019-11-27
 * @description 自己创建一个具有三个构造参数的接口
 */
@FunctionalInterface
public interface FruitInter<T,U,R,V> {
    /**
     * 构建 T 对象
     * @param u
     * @param r
     * @param v
     * @return
     */
    T apply(U u, R r, V v);
}
