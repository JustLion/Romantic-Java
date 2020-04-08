package com.liang.erhua.interviewtest;

/**
 * @author: liangjia
 * @date: created in 17:39 2020年04月07日
 * @description: 一个数如果恰好等于它的因子之和, 这个数就称为”完数”. 例如 6 = 1+2+3。 编程找出
 * 1000 以内的所有完数。
 * @modified by:
 * @version: 1.0
 */
public class WSTest {
	public static void main(String[] args) {
		for (int i = 1; i < 1000; i++) {
			int sum = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					sum += j;
				}
			}
			if (i == sum) {
				System.out.println(i + "就是这个完数！");
				StringBuilder builder = new StringBuilder();
				builder.append(i).append("的因数分别为：");
				for (int k = 1; k < i; k++) {
					if (i % k == 0) {
						builder.append(k).append(",");
					}
				}
				System.out.println(builder.deleteCharAt(builder.lastIndexOf(
						",")).toString());
			}
		}
	}
}
