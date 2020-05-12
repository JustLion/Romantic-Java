package com.liang.erhua.datastructure.sort;

import java.util.Arrays;

/**
 * @author: liangjia
 * @date: created in 15:50 2020年04月21日
 * @description: 插入排序
 * @modified by:
 * @version: 1.0
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] arr = {101, 34, 119, 1,23,-101 };
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 *  插入排序--需要深入理解
	 * @param arr 需要被排序的数组
	 */
	public static void insertSort(int[] arr) {
		int insertVal = 0;
		int insertIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			insertVal = arr[i];
			insertIndex = i - 1;
			while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
				arr[insertIndex + 1] = arr[insertIndex];
				insertIndex--;
			}
			if (insertIndex + 1 != i) {
				arr[insertIndex + 1] = insertVal;
			}
		}
	}
}
