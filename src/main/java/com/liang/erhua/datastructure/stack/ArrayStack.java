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
	 * 根据运算符获取计算优先级
	 * @param oper 运算符
	 * @return 最高 1 中等 0 最低 -1
	 */
	public int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		}else if (oper == '+' || oper == '-') {
			return 0;
		}else {
			return -1;
		}
	}
}
