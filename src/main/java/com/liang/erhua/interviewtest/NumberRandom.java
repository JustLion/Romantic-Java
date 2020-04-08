package com.liang.erhua.interviewtest;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author: liangjia
 * @date: created in 17:25 2020年04月07日
 * @description:
 * @modified by:
 * @version: 1.0
 */
public class NumberRandom {
	String[] strs = {"1", "2", "2", "3", "4", "5"};
	int n = strs.length;
	boolean[] visited = new boolean[n];
	String result = "";
	TreeSet<String> ts = new TreeSet<>();
	int[][] array = new int[n][n];

	private void searchMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					array[i][j] = 0;
				} else {
					array[i][j] = 1;
				}
			}
		}
		//3 和 5 不能相连
		array[3][5] = 0;
		array[5][3] = 0;
		//开始遍历
		for (int i = 0; i < n; i++) {
			search(i);
		}
		Iterator<String> it = ts.iterator();
		while (it.hasNext()) {
			String str = it.next();
			//4 不能在第三位
			if (str.indexOf("4") != 2) {
				System.out.println(str);
			}
		}
	}

	private void search(int startIndex) {
		visited[startIndex] = true;
		result = result + strs[startIndex];
		if (result.length() == n) {
			ts.add(result);
		}
		for (int j = 0; j < n; j++) {
			if (array[startIndex][j] == 1 && !visited[j]) {
				search(j);
			} else {
				continue;
			}
		}
		//一个 result 结束后踢掉最后一个，寻找别的可能性，若没有的话，则继续向前踢掉当前最后一个
		result = result.substring(0, result.length() - 1);
		visited[startIndex] = false;
	}

	public static void main(String[] args) {
		new NumberRandom().searchMap();
	}
}
