package com.liang.erhua.datastructure.sort;

import java.util.Arrays;

/**
 * @author: liangjia
 * @date: created in 15:19 2020年04月21日
 * @description: 选择排序
 * @modified by:
 * @version: 1.0
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] arr = {101, 34, 119, 1 };
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 选择排序
	 * @param arr 需要排序的数组
	 */
	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			int index = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < temp) {
					index = j;
					temp = arr[j];
				}
			}
			if (index != i) {
				arr[index] = arr[i];
				arr[i] = temp;
			}
		}
	}
}
