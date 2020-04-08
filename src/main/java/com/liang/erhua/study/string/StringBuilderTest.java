package com.liang.erhua.study.string;

/**
 * @author: liangjia
 * @date: created in 17:48 2020年04月08日
 * @description:
 * @modified by:
 * @version: 1.0
 */
public class StringBuilderTest {
	/**
	 * AB,B
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuilder builder1 = new StringBuilder("A");
		StringBuilder builder2 = new StringBuilder("B");
		operator(builder1, builder2);
		System.out.println(builder1 + "," + builder2);
	}

	/**
	 * builder1的append可以成功，但是builder2的赋值却失败
	 *
	 * @param builder1
	 * @param builder2
	 */
	public static void operator(StringBuilder builder1, StringBuilder builder2) {
		builder1.append(builder2);
		builder2 = builder1;
	}
}
