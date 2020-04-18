package com.liang.erhua.datastructure.recursion;

/**
 * @author: liangjia
 * @date: created in 15:52 2020年04月18日
 * @description:
 * @modified by:
 * @version: 1.0
 */
public class Queen8 {
	int max = 8;
	int[] array = new int[max];
	static int count = 0;
	static int judgeCount = 0;

	public static void main(String[] args) {
		Queen8 queen8 = new Queen8();
		queen8.check(0);
		System.out.printf("一共有%d种解法\n", count);
		System.out.printf("一共判断冲突的次数：%d\n", judgeCount);
	}

	/**
	 * 放置第n个皇后后判断是否冲突
	 *
	 * @param n 第n个皇后
	 * @return 是否冲突
	 */
	private boolean judge(int n) {
		judgeCount++;
		for (int i = 0; i < n; i++) {
			if (array[n] == array[i] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 每次check都有回溯
	 *
	 * @param n 第 n 个皇后
	 */
	private void check(int n) {
		if (n == max) {
			print();
			return;
		}
		for (int i = 0; i < max; i++) {
			array[n] = i;
			if (judge(n)) {
				check(n + 1);
			}
		}
	}

	/**
	 * 将皇后放置的位置输出
	 */
	private void print() {
		count++;
		for (int value : array) {
			System.out.print(value + "\t");
		}
		System.out.println();
	}
}
