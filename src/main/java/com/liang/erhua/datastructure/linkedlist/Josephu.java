package com.liang.erhua.datastructure.linkedlist;

/**
 * @author: liangjia
 * @date: created in 09:41 2020年04月13日
 * @description: Josephu环 ：单向环形链表问题
 * @modified by:
 * @version: 1.0
 */
public class Josephu {
	public static void main(String[] args) {
		CircleSingleLinkedList circleSingleLinkedList =
				new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(125);

		circleSingleLinkedList.list();

		circleSingleLinkedList.countItem(10, 20, 125);
	}
}
