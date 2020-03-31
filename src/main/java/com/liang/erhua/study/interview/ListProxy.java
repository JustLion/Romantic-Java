package com.liang.erhua.study.interview;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liangjia
 * @version 1.0
 * @date 20:02/2020-03-22
 * @description
 */
public class ListProxy {
    public static void main(String[] args) {
        final List<String> list = new ArrayList<>();
        List<String> proxyList = (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] arr) throws Throwable {
                return method.invoke(list,arr);
            }
        });
        proxyList.add("你好");
        System.out.println(list);
    }
}
