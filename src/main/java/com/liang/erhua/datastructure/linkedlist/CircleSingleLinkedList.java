package com.liang.erhua.datastructure.linkedlist;

/**
 * @author: liangjia
 * @date: created in 10:39 2020年04月13日
 * @description: 创建环形单向链表
 * @modified by:
 * @version: 1.0
 */
public class CircleSingleLinkedList {
	/**
	 * 创建第一个节点
	 */
	private Boy first = null;

	/**
	 * 添加元素至循环链表
	 *
	 * @param nums 元素个数
	 */
	public void addBoy(int nums) {
		if (nums < 1) {
			System.out.println("nums的值不准确！");
			return;
		}
		Boy currentBoy = null;
		for (int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			if (i == 1) {
				// 第一个的话就是first
				first = boy;
				// 下一个 指向 first 形成环形
				first.setNext(first);
				// 指针后移
				currentBoy = first;
			} else {
				currentBoy.setNext(boy);
				boy.setNext(first);
				currentBoy = boy;

			}
		}
	}

	/**
	 * 遍历链表
	 */
	public void list() {
		if (first == null) {
			System.out.println("循环链表中没有元素！");
			return;
		}
		Boy current = first;
		while (true) {
			System.out.printf("元素的编号为：%d\n", current.getNo());
			if (current.getNext() == first) {
				break;
			}
			// 元素后移
			current = current.getNext();
		}
	}

	/**
	 * 根据定制出出圈顺序
	 *
	 * @param startNo  开始序号
	 * @param countNum 每次数几个数
	 * @param nums     最初圈中有多少元素
	 */
	public void countItem(int startNo, int countNum, int nums) {
		// 数据校验
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("参数输入有误，请重新输入！");
			return;
		}
		Boy helper = first;
		while (true) {
			if (helper.getNext() == first) {
				// 指向最后节点
				break;
			}
			helper = helper.getNext();
		}
		// 报数前先让first 和 helper 移动 k-1次
		for (int i = 0; i < startNo - 1; i++) {
			first = first.getNext();
			helper = helper.getNext();
		}

		while (true) {
			if (helper == first) {
				break;
			}
			// 走 countNum 步， first指向这次需要出圈的元素
			for (int i = 0; i < countNum - 1; i++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			System.out.printf("元素出圈：%d\n",first.getNo());
			// 为下次游戏准备 first 后移
			first = first.getNext();
			// helper 指向 first 形成环形链表
			helper.setNext(first);
		}
		System.out.printf("最后留在圈中的元素编号%d\n",first.getNo());
	}

}
