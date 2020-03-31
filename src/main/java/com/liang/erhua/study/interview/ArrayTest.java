package com.liang.erhua.study.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liangjia
 * @version 1.0
 * @date 15:29/2020-03-16
 * @description
 */
public class ArrayTest {
    public static void main(String[] args) {

    }

    public static void testArray() {
        int[] arr = {1,4,1,4,2,5,4,5,8,7,8,77,88,5,4,9,6,2,4,1,5};
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            Integer integer = map.get(i);
            if (integer == null) {
                map.put(i,1);
            }else {
                map.put(i,integer+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"出现了" + entry.getValue() + "次");
        }
    }
}
