package com.liang.erhua.interviewtest;

/**
 * @author: liangjia
 * @date: created in 17:19 2020年04月07日
 * @description: 用 1,2 , 2 ,3, 4 ,5 这 6 个数字,
 * 用 Java 写一个 main 函数, 打印出所有不同的排列,
 * 如:512234, 412345 等, 要求: “4”不能在第三位, “3”与”5”不能相连
 * @modified by:
 * @version: 1.0
 */
public class SpecialSort {
	public static void main(String[] args) {
		// 思路，首先先排序得出所有可能的结果集
		String[] array = {"1", "2", "2", "3", "4", "5"};
		// 遍历打印字符串，str.indexOf("4") != 2 && !str.contains("35") && !str
		// .contains("53") 时再打印str
	}
}
