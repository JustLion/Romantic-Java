package com.liang.erhua.study;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author liang
 */
public class ObjectsTest {
    public static void main(String[] args) {
        String str = null;
        System.out.println(StandardCharsets.UTF_8);
        System.out.println(Objects.toString(str,"liangjia"));
        System.out.println(String.format("小明是个%s%s","大","帅哥"));
    }
}
