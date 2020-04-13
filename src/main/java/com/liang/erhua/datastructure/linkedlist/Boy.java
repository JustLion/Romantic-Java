package com.liang.erhua.datastructure.linkedlist;

/**
 * @author: liangjia
 * @date: created in 09:43 2020年04月13日
 * @description:
 * @modified by:
 * @version: 1.0
 */
public class Boy {
	/**
	 * 编号
	 */
	private int no;
	/**
	 * 下一个
	 */
	private Boy next;

	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}
}
