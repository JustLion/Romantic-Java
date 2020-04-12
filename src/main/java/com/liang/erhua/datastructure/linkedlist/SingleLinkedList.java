package com.liang.erhua.datastructure.linkedlist;

/**
 * @author: liangjia
 * @date: created in 22:12 2020年04月11日
 * @description:
 * @modified by:
 * @version: 1.0
 */
public class SingleLinkedList {

	private final HeroNode head = new HeroNode(1, "", "");

	public HeroNode getHead() {
		return head;
	}

	/**
	 * 增加节点
	 *
	 * @param heroNode 需要增加的节点
	 */
	public void add(HeroNode heroNode) {
		// 遍历找到尾部节点
		HeroNode temp = head;
		while (true) {
			if (temp.next == null) {
				//尾部
				break;
			}
			temp = temp.next;
		}
		temp.next = heroNode;
	}

	/**
	 * 列出链表中所有元素
	 */
	public void list() {
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空！");
		}
		// 遍历找到尾部节点
		HeroNode temp = head;
		while (true) {
			if (temp.next == null) {
				//尾部
				break;
			}
			temp = temp.next;
			System.out.println(temp);
		}
	}

	/**
	 * 按照顺序添加英雄
	 *
	 * @param heroNode 需要添加的英雄
	 */
	public void addByOrder(HeroNode heroNode) {
		// 遍历找到尾部节点
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				//尾部
				break;
			} else if (temp.no.equals(heroNode.no)) {
				flag = true;
				break;
			} else if (temp.next.no.compareTo(heroNode.no) > 0) {
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			System.out.printf("英雄编号为%d已存在，请勿重复添加\n", heroNode.no);
		} else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}

	/**
	 * 根据节点no删除节点
	 *
	 * @param no 节点no
	 */
	public void delete(Integer no) {
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			} else if (temp.next.no.equals(no)) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.next = temp.next.next;
		} else {
			System.out.printf("要删除的 %d 节点不存在\n", no);
		}
	}

	/**
	 * 更新某元素信息
	 *
	 * @param heroNode 新元素信息
	 */
	public void update(HeroNode heroNode) {
		HeroNode temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			} else if (temp.no.equals(heroNode.no)) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = heroNode.name;
			temp.nickName = heroNode.nickName;
		} else {
			System.out.printf("没有找到 编号 %d 的节点，不能修改\n", heroNode.no);
		}
	}

	/**
	 * 根据编号查询英雄
	 *
	 * @param no 编号
	 * @return 英雄
	 */
	public HeroNode search(Integer no) {
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			}
			if (temp.no.equals(no)) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			return temp;
		} else {
			System.out.printf("no为%d的英雄不存在\n", no);
			return null;
		}
	}

	/**
	 * 获取链表的长度
	 * @return 链表长度
	 */
	public int length() {
		int count = 0;
		HeroNode temp = head;
		while (temp.next != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
}
