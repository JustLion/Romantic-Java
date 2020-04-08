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

	public static String getString(Map<String,Object> params,String key) {
		String value = "";
		if (null != params && params.containsKey(key) && params.get(key) != null){
			value = String.valueOf(params.get(key));
		}
		return value;
	}
}
