package com.liang.erhua.jdk8.classfile;

import org.apache.log4j.Logger;

import java.lang.invoke.MethodHandles;

/**
 * @author liangjia
 * @version 1.0
 * @date 22:30/2020-01-17
 * @description
 */
public class IfTest {
    /**日志输出*/
    private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        // 不可扩容的 stack
        IntStack mystack1 = new FixedStack(5);
        IntStack mystack2 = new FixedStack(8);

        for (int i = 0; i < 5; i++) {
            mystack1.push(i);
        }

        for (int i = 0; i < 8; i++) {
            mystack2.push(i);
        }

        System.out.println("stack in mystack1");

        for (int i = 0; i < 5; i++) {
            System.out.println(mystack1.pop());
        }

        System.out.println("stack in mystack2");

        for (int i = 0; i < 8; i++) {
            System.out.println(mystack2.pop());
        }

        // 可扩容的 stack
        IntStack mystack3 = new DynStack(5);
        IntStack mystack4 = new DynStack(8);

        for (int i = 0; i < 12; i++) {
            mystack3.push(i);
        }

        for (int i = 0; i < 20; i++) {
            mystack4.push(i);
        }

        System.out.println("stack in mystack3");

        for (int i = 0; i < 12; i++) {
            System.out.println(mystack3.pop());
        }

        System.out.println("stack in mystack4");
        for (int i = 0; i < 20; i++) {
            System.out.println(mystack4.pop());
        }
    }
}
