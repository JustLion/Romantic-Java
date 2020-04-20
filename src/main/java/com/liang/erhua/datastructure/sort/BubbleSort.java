package com.liang.erhua.datastructure.sort;

import java.util.Arrays;

/**
 * @author liangjia
 * @version 1.0
 * @date 19:50/2020-04-18
 * @description 冒泡排序算法
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

       long start = System.currentTimeMillis();

        //测试冒泡排序
        bubbleSort(arr);

        System.out.println("排序耗时=" + (System.currentTimeMillis() - start));
    }

    /**
     * 冒泡排序
     *
     * @param arr 需要被排序的数组
     */
    public static void bubbleSort(int[] arr) {
        int temp;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
