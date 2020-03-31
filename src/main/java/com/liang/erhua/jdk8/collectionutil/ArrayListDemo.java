package com.liang.erhua.jdk8.collectionutil;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author liangjia
 * @version 1.0
 * @date 19:51/2020-02-16
 * @description
 */
public class ArrayListDemo {
    public static void main(String[] args) {

    }

    public static void listDemo() {
        // 创建 ArrayList 集合
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add(1,"1");
        list.remove("A");
        list.remove(1);
        // 返回的是一个 Object 类型的数组
        Object[] objects = list.toArray();
        // 返回一个指定类型的数组
        String[] strs = new String[list.size()];
        String[] strings = list.toArray(strs);
    }

    public static void linkedListDemo() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add(1,"1");
        list.remove("A");
        list.remove(1);
        // 向list 头部添加元素
        list.offerFirst("A");
        list.addFirst("S");
        // 向list尾部添加元素
        list.addLast("L");
        list.offerLast("C");

        // 获取list第一个元素
        String first = list.getFirst();
        String peekFirst = list.peekFirst();
        // 获取 list的最后一个元素
        String last = list.getLast();
        String peekLast = list.peekLast();

        // 移除第一个元素
        String removeFirst = list.removeFirst();
        String pollFirst = list.pollFirst();
        // 移除最后一个元素
        String removeLast = list.removeLast();
        String pollLast = list.pollLast();
    }

    public static void hashSetDemo() {
        HashSet<String> set = new HashSet<>();
        set.add("beta");
        set.add("alpha");
        set.add("eta");
        set.add("gamma");
        set.add("epsilon");
        set.add("omega");
        // hashset不能保证元素的顺序
        System.out.println(set);
        // 使用 LinkedHashSet可以保证顺序性
    }

    public static void treeSetDemo() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("A");
        treeSet.add("B");
        treeSet.add("C");
        treeSet.add("D");
        treeSet.add("E");
        treeSet.add("F");
        treeSet.add("G");
        System.out.println(treeSet);
        SortedSet<String> strings = treeSet.subSet("C", "F");
        System.out.println(strings);
    }

    public static void arrayDequeDemo() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>(16);
        arrayDeque.push("A");
        arrayDeque.push("B");
        arrayDeque.push("C");
        arrayDeque.push("D");
        arrayDeque.push("E");
        while (arrayDeque.peek() != null) {
            System.out.println(arrayDeque.pop());
        }
    }

    public static void enmuSetDemo() {

    }

    public static void iteratorDemo() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println("element:" + s);
        }
        boolean next = iterator.hasNext();
        String next1 = iterator.next();
        iterator.remove();
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String next2 = listIterator.next();
            listIterator.set(next2 + "+");
        }

        while (listIterator.hasPrevious()) {
            String previous = listIterator.previous();
            System.out.println("previous:" + previous);
        }
    }

    public static void spliteratorDemo() {
        List<Double> list = new ArrayList<>();
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);
        list.add(4.0);
        list.add(5.0);
        Spliterator<Double> spliterator = list.spliterator();
        while (spliterator.tryAdvance(aDouble -> System.out.println(aDouble)));
        List<Double> newList = new ArrayList<>();
        while (spliterator.tryAdvance(aDouble -> newList.add(aDouble)));
        Spliterator<Double> spliterator1 = newList.spliterator();
        spliterator1.forEachRemaining(aDouble -> System.out.println(aDouble));
    }

    public static void mapDemo() {

        Comparator<String> mc = (o1, o2) -> o2.compareTo(o1);


        // o1 和 o2 谁调用compareTo方法很重要
        TreeSet<String> treeSet = new TreeSet<>(new MyComp().reversed());
        treeSet.add("A");
        treeSet.add("B");
        treeSet.add("C");
        treeSet.add("D");
        treeSet.add("E");
        treeSet.add("F");
        for (String s : treeSet) {
            System.out.println(s);
        }
    }

}

class MyComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}
