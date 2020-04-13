package com.liang.erhua.datastructure.linkedlist;

import java.util.Stack;

/**
 * @author: liangjia
 * @date: created in 22:12 2020年04月11日
 * @description:
 * @modified by:
 * @version: 1.0
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();


        //加入
		/*singleLinkedList.add(hero1);
		singleLinkedList.add(hero4);
		singleLinkedList.add(hero2);
		singleLinkedList.add(hero3);

		// 测试一下单链表的反转功能
		System.out.println("原来链表的情况~~");
		singleLinkedList.list();*/

//		System.out.println("反转单链表~~");
//		reversetList(singleLinkedList.getHead());
//		singleLinkedList.list();

//		System.out.println("测试逆序打印单链表, 没有改变链表的结构~~");
//		reversePrint(singleLinkedList.getHead());


        //加入按照编号的顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        //显示一把
        singleLinkedList.list();

        reverseList(singleLinkedList.getHead());

        singleLinkedList.list();
/*
		//测试修改节点的代码
		HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
		singleLinkedList.update(newHeroNode);

		System.out.println("修改后的链表情况~~");
		singleLinkedList.list();

		//删除一个节点
		singleLinkedList.del(1);
		singleLinkedList.del(4);
		System.out.println("删除后的链表情况~~");
		singleLinkedList.list();

		//测试一下 求单链表中有效节点的个数
		System.out.println("有效的节点个数=" + getLength(singleLinkedList.getHead()));//2

		//测试一下看看是否得到了倒数第K个节点
		HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 3);
		System.out.println("res=" + res);
*/

    }

    /**
     * 获取单向链表的节点个数
     *
     * @param head 头节点
     * @return 长度
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        HeroNode temp = head.next;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 获取倒数第index个节点元素
     *
     * @param head  头节点
     * @param index 倒数第index
     * @return 节点元素
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 反转链表
     *
     * @param head 头部节点元素
     */
    public static void reverseList(HeroNode head) {
        // 空链表或者长度为1的单链表无需反转
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode current = head.next;
        HeroNode next;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (current != null) {
            //记录当前节点的下一个节点
            next = current.next;
            // 把遍历出的节点连接新链表头部后面的节点，总是把遍历出的元素放置在新链表头部的下一个
            current.next = reverseHead.next;
            // 把头部节点和已经连接的节点进行连接
            reverseHead.next = current;
            // 向下遍历条件
            current = next;
        }
        head.next = reverseHead.next;
    }

    /**
     * 逆序打印单链表 利用栈机制
     *
     * @param head 头节点
     */
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }

        HeroNode heroNode = head.next;
        Stack<HeroNode> stack = new Stack<>();
        // 遍历链表，放入栈中
        while (heroNode != null) {
            stack.push(heroNode);
            heroNode = heroNode.next;
        }
        // 遍历栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }
}
