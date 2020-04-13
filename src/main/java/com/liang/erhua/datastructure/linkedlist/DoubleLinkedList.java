package com.liang.erhua.datastructure.linkedlist;

/**
 * @author: liangjia
 * @date: created in 22:12 2020年04月11日
 * @description:
 * @modified by:
 * @version: 1.0
 */
public class DoubleLinkedList {

    private final HeroNode2 head = new HeroNode2(1, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 增加节点
     *
     * @param heroNode 需要增加的节点
     */
    public void add(HeroNode2 heroNode) {
        // 遍历找到尾部节点
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                //尾部
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
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
        HeroNode2 temp = head;
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
    public void addByOrder(HeroNode2 heroNode) {
        // 遍历找到尾部节点
        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //尾部
                break;
            }
            if (temp.next.no.equals(heroNode.no)) {
                flag = true;
                break;
            }
            if (temp.next.no.compareTo(heroNode.no) > 0) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("英雄编号为%d已存在，请勿重复添加\n", heroNode.no);
        }else {
            if (temp.next == null) {
                temp.next = heroNode;
                heroNode.pre = temp;
            }else {
                heroNode.next = temp.next;
                temp.next.pre = heroNode;
                temp.next = heroNode;
                heroNode.pre = temp;
            }
        }
    }

    /**
     * 根据节点no删除节点
     *
     * @param no 节点no
     */
    public void delete(Integer no) {
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no.equals(no)) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

    /**
     * 更新某元素信息
     *
     * @param heroNode 新元素信息
     */
    public void update(HeroNode2 heroNode) {
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no.equals(heroNode.no)) {
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
    public HeroNode2 search(Integer no) {
        HeroNode2 temp = head;
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

}
