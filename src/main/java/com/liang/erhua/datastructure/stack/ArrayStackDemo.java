package com.liang.erhua.datastructure.stack;

/**
 * @author: liangjia
 * @date: created in 17:36 2020年04月15日
 * @description: 栈实现中缀表达式计算器
 * @modified by:
 * @version: 1.0
 */
public class ArrayStackDemo {
	public static void main(String[] args) {
		String expression = "7*2*2-5+1-5+3-3";
		ArrayStack numStack = new ArrayStack(5);
		ArrayStack operStack = new ArrayStack(5);
		char[] chars = expression.toCharArray();
		for (char aChar : chars) {
			if (isOper(aChar)) {
				if (operStack.isEmpty()) {
					operStack.push(aChar);
				} else {
					if (priority(aChar) > priority(operStack.peek())) {
						operStack.push(aChar);
					} else {
						int popOper = operStack.pop();
						int num2 = numStack.pop();
						int num1 = numStack.pop();
						int number;
						if ('*' == popOper) {
							number = num2 * num1;
						} else if ('/' == popOper) {
							number = num2 / num1;
						} else if ('+' == popOper) {
							number = num2 + num1;
						} else if ('-' == popOper) {
							number = num2 - num1;
						} else {
							throw new RuntimeException("运算符异常");
						}
						operStack.push(aChar);
						numStack.push(number);
					}
				}
			} else {
				numStack.push(aChar - 48);
			}
		}
		System.out.println(numStack.pop());
	}

	/**
	 * 根据运算符获取计算优先级
	 *
	 * @param oper 运算符
	 * @return 最高 1 中等 0 最低 -1
	 */
	public static int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * 判断元素是操作符还是数字
	 *
	 * @param value 元素
	 * @return true or false
	 */
	public static boolean isOper(int value) {
		return value == '+' || value == '-' || value == '*' || value == '/';
	}
}
