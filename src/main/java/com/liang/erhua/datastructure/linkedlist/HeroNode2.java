package com.liang.erhua.datastructure.linkedlist;

import java.io.Serializable;

/**
 * @author: liangjia
 * @date: created in 22:13 2020年04月11日
 * @description: 双向链表
 * @modified by:
 * @version: 1.0
 */
public class HeroNode2 implements Serializable {
	public Integer no;
	public String name;
	public String nickName;
	public HeroNode2 next;
	public HeroNode2 pre;

	public HeroNode2(Integer no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "HeroNode{" +
				"no=" + no +
				", name='" + name + '\'' +
				", nickName='" + nickName + '\'' +
				'}';
	}
}
