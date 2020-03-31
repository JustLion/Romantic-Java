package com.liang.erhua.study.list;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author liangjia
 * @version 1.0
 * @date 21:30/2019-10-16
 * @description 普通for遍历非常慢，增强for和iterator遍历很快，用pollFirst()和pollLast()以及removeFirst()、removeLast()遍历很快
 */
public class LinkedListTest {
    public static void main(String[] args) {
        baseOperate();
    }

    private static void baseOperate() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        //linkedList的基本操作
        // 添加元素到列表开头
        linkedList.addFirst(0);
        // 在列表结尾添加元素
        linkedList.add(1);
        // 在指定位置添加元素
        linkedList.add(2, 2);
        // 添加元素到列表结尾
        linkedList.addLast(3);

        System.out.println("LinkedList（直接输出的）: " + linkedList);

        // 返回此列表的第一个元素
        System.out.println("getFirst()获得第一个元素: " + linkedList.getFirst());
        // 返回此列表的最后一个元素
        System.out.println("getLast()获得第最后一个元素: " + linkedList.getLast());
        // 移除并返回此列表的第一个元素
        System.out.println("removeFirst()删除第一个元素并返回: " + linkedList.removeFirst());
        // 移除并返回此列表的最后一个元素
        System.out.println("removeLast()删除最后一个元素并返回: " + linkedList.removeLast());
        System.out.println("After remove:" + linkedList);
        // 判断此列表包含指定元素，如果是，则返回true
        System.out.println("contains()方法判断列表是否包含1这个元素:" + linkedList.contains(1));
        // 返回此列表的元素个数
        System.out.println("该linkedList的大小 : " + linkedList.size());

        //位置访问操作
        System.out.println("-----------------------------------------");
        // 将此列表中指定位置的元素替换为指定的元素
        linkedList.set(1, 3);
        System.out.println("After set(1, 3):" + linkedList);
        // 返回此列表中指定位置处的元素
        System.out.println("get(1)获得指定位置（这里为1）的元素: " + linkedList.get(1));

        //Search操作
        System.out.println("-----------------------------------------");
        linkedList.add(3);
        // 返回此列表中首次出现的指定元素的索引
        System.out.println("indexOf(3): " + linkedList.indexOf(3));
        // 返回此列表中最后出现的指定元素的索引
        System.out.println("lastIndexOf(3): " + linkedList.lastIndexOf(3));

        //Queue操作
        System.out.println("-----------------------------------------");
        // 获取但不移除此列表的头
        System.out.println("peek(): " + linkedList.peek());
        // 获取但不移除此列表的头
        System.out.println("element(): " + linkedList.element());
        // 获取并移除此列表的头
        linkedList.poll();
        System.out.println("After poll():" + linkedList);
        linkedList.remove();
        // 获取并移除此列表的头
        System.out.println("After remove():" + linkedList);
        linkedList.offer(4);
        // 将指定元素添加到此列表的末尾
        System.out.println("After offer(4):" + linkedList);

        // Deque操作
        System.out.println("-----------------------------------------");
        // 在此列表的开头插入指定的元素
        linkedList.offerFirst(2);
        System.out.println("After offerFirst(2):" + linkedList);
        // 在此列表末尾插入指定的元素
        linkedList.offerLast(5);
        System.out.println("After offerLast(5):" + linkedList);
        // 获取但不移除此列表的第一个元素
        System.out.println("peekFirst(): " + linkedList.peekFirst());
        // 获取但不移除此列表的第一个元素
        System.out.println("peekLast(): " + linkedList.peekLast());
        // 获取并移除此列表的第一个元素
        linkedList.pollFirst();
        System.out.println("After pollFirst():" + linkedList);
        // 获取并移除此列表的最后一个元素
        linkedList.pollLast();
        System.out.println("After pollLast():" + linkedList);
        // 将元素推入此列表所表示的堆栈（插入到列表的头）
        linkedList.push(2);
        System.out.println("After push(2):" + linkedList);
        // 从此列表所表示的堆栈处弹出一个元素（获取并移除列表第一个元素）
        linkedList.pop();
        System.out.println("After pop():" + linkedList);
        linkedList.add(3);
        // 从此列表中移除第一次出现的指定元素（从头部到尾部遍历列表）
        linkedList.removeFirstOccurrence(3);
        System.out.println("After removeFirstOccurrence(3):" + linkedList);
        // 从此列表中移除最后一次出现的指定元素（从尾部到头部遍历列表）
        linkedList.removeLastOccurrence(3);
        System.out.println("After removeFirstOccurrence(3):" + linkedList);

        //遍历操作
        System.out.println("-----------------------------------------");
        linkedList.clear();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }
        // 迭代器遍历-----10ms
        long start = System.currentTimeMillis();
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long end = System.currentTimeMillis();
        System.out.println("Iterator：" + (end - start) + " ms");

        // 顺序遍历(随机遍历)------6891ms
        start = System.currentTimeMillis();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }
        end = System.currentTimeMillis();
        System.out.println("for：" + (end - start) + " ms");

        // 另一种for循环遍历------1ms
        start = System.currentTimeMillis();
        for (Integer i : linkedList) {
            //System.out.println(i);
        }
        end = System.currentTimeMillis();
        System.out.println("for2：" + (end - start) + " ms");

        // 通过pollFirst()或pollLast()来遍历LinkedList------1ms
        LinkedList<Integer> temp1 = new LinkedList<>();
        temp1.addAll(linkedList);
        start = System.currentTimeMillis();
        while (temp1.size() != 0) {
            temp1.pollFirst();
        }
        end = System.currentTimeMillis();
        System.out.println("pollFirst()或pollLast()：" + (end - start) + " ms");

        // 通过removeFirst()或removeLast()来遍历LinkedList -----0ms
        LinkedList<Integer> temp2 = new LinkedList<>();
        temp2.addAll(linkedList);
        start = System.currentTimeMillis();
        while (temp2.size() != 0) {
            temp2.removeFirst();
        }
        end = System.currentTimeMillis();
        System.out.println("removeFirst()或removeLast()：" + (end - start) + " ms");
    }
}
