package com.liang.erhua.study.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liangjia
 * @version 1.0
 * @date 21:59/2019-10-16
 * @description
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(6);
        // 键不能重复，值可以重复
        map.put("san", "张三");
        map.put("si", "李四");
        map.put("wu", "王五");
        map.put("wang", "老王");
        map.put("lao", "老王");
        System.out.println("-------直接输出hashmap:-------");
        System.out.println(map);
        System.out.println("after map.containsKey(si)："+map.containsKey("si"));
        System.out.println("after containsValue(李四)："+map.containsValue("李四"));
        System.out.println(map.replace("si", "李四2"));
        System.out.println("after map.replace(si, 李四2):"+map);
    }
}
