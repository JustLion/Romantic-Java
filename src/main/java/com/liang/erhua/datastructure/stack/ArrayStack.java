package com.liang.erhua.datastructure.stack;

/**
 * @author: liangjia
 * @date: created in 15:02 2020年04月13日
 * @description: 用数组实现栈~~~ 可以尝试用链表实现栈
 * @modified by:
 * @version: 1.0
 */
public class ArrayStack {
	/**
	 * 栈的大小
	 */
	private final int maxSize;
	/**
	 * 模拟栈的数组
	 */
	private final int[] stack;
	/**
	 * 栈顶为-1
	 */
	private int top = -1;

	/**
	 * 构造元素个数为 maxSize 的数组
	 *
	 * @param maxSize 元素个数
	 */
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}

	/**
	 * 元素入栈
	 *
	 * @param item 入栈元素
	 */
	public void push(int item) {
		if (isFull()) {
			System.out.println("栈已满，添加失败");
			return;
		}
		top++;
		stack[top] = item;
	}

	/**
	 * 元素出栈
	 *
	 * @return 元素
	 */
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("栈已空，取数据失败");
		}
		int item = stack[top];
		top--;
		return item;
	}

	/**
	 * 遍历栈
	 */
	public void list() {
		if (isEmpty()) {
			System.out.println("栈空，没有数据~~");
			return;
		}
		for (int i = top; i > 0; i--) {
			System.out.printf("stack[%d]=%d", i, stack[i]);
		}
	}

	/**
	 * 栈是否已满
	 *
	 * @return true or false
	 */
	public boolean isFull() {
		return top + 1 == maxSize;
	}

	/**
	 * 是否为空栈
	 *
	 * @return true or false
	 */
	public boolean isEmpty() {
		return top == -1;
	}

	/**
	 * 返回栈顶部数据
	 *
	 * @return 顶部数据
	 */
	public int peek() {
		return stack[top];
	}

	/**
	 * 进行计算
	 * @param num1 数字1
	 * @param num2 数字2
	 * @param oper 操作符
	 * @return 计算结果
	 */
	public int cal(int num1, int num2, int oper) {
		int res = 0; // res 用于存放计算的结果
		switch (oper) {
			case '+':
				res = num1 + num2;
				break;
			case '-':
				res = num2 - num1;// 注意顺序
				break;
			case '*':
				res = num1 * num2;
				break;
			case '/':
				res = num2 / num1;
				break;
			default:
				break;
		}
		return res;
	}

}
