package com.liang.erhua.util;

import java.util.Map;

/**
 * @author: liangjia
 * @date: created in 16:43 2020年04月07日
 * @description: 字符串处理类
 * @modified by:
 * @version: 1.0
 */
public class StringUtil {
	/**
	 * 从map集合中获取String的值，如果不存在就返回空字符串
	 * @param params
	 * @param key
	 * @return
	 */
	public static String getString(Map<String,Object> params,String key) {
		String value = "";
		if (null != params && params.containsKey(key) && params.get(key) != null){
			value = String.valueOf(params.get(key));
		}
		return value;
	}

	/**
	 * 比较两个char数组转换的字符串 a>b return 1;a=b return 0;a<b return -1
	 * @param a
	 * @param b
	 * @return
	 */
	public static int compare(char[] a,char[] b) {
		String str1 = new String(a);
		String str2 = new String(b);
		int result = str1.compareTo(str2);
		return result == 0?0:(result > 0 ? 1:-1);
	}
}
