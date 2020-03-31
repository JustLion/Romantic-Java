package com.liang.erhua.jdk8.collectionutil;

import java.io.*;
import java.util.*;

/**
 * @author liangjia
 * @version 1.0
 * @date 10:45/2020-02-19
 * @description
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        arraysDemo();
    }

    public static void treeMap() {
        TreeMap<String, Double> treeMap = new TreeMap<>();
        treeMap.put("John Doe", new Double(3434.34));
        treeMap.put("Tom Smith", new Double(123.22));
        treeMap.put("Jane Baker", new Double(1378.00));
        treeMap.put("Tod Hall", new Double(99.22));
        treeMap.put("Ralph Smith", new Double(-19.08));
        Set<Map.Entry<String, Double>> set = treeMap.entrySet();
        for (Map.Entry<String, Double> entry : set) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        Double balance = treeMap.get("John Doe");
        treeMap.put("John Doe", balance + 1000);
        System.out.println("John Doe's new balance:" + treeMap.get("John Doe"));
    }

    /**
     * Collections 集合工具类 API
     */
    public static void collectionsDemo() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        boolean b = Collections.addAll(list);
        ArrayDeque<String> arrayDeque = new ArrayDeque<>(16);
        arrayDeque.push("A");
        arrayDeque.push("B");
        arrayDeque.push("C");
        arrayDeque.push("D");
        arrayDeque.push("E");
        Queue<String> strings = Collections.asLifoQueue(arrayDeque);
        int a = Collections.binarySearch(list, "A", String::compareTo);
        int a1 = Collections.binarySearch(list, "A");
        Collection<String> strings1 = Collections.checkedCollection(list,
                String.class);
        List<String> list1 = Collections.checkedList(list, String.class);
        Collections.copy(new ArrayList<>(), list);
        // 比较两个集合是否有交集
        boolean disjoint = Collections.disjoint(new ArrayList<>(), list);
        // 返回一个空的枚举
        Enumeration<Object> objectEnumeration = Collections.emptyEnumeration();
        // 返回一个空的迭代器
        Iterator<Object> objectIterator = Collections.emptyIterator();
        // 返回一个空的list
        List<Object> objects = Collections.emptyList();
        // 返回一个基于list集合的枚举
        Enumeration<String> enumeration = Collections.enumeration(list);
        // 将某元素赋值给集合中的每个元素
        Collections.fill(new ArrayList<>(5), "A");
        // 计算“A” 在集合中出现的次数，返回结果
        int a2 = Collections.frequency(list, "A");

        List<String> list2 = new ArrayList<>();
        list2.add("A");
        // list2 第一次在list中出现的位置
        int i = Collections.indexOfSubList(list, list2);
        // list2 最后一次在 list 中出现的位置
        int i1 = Collections.lastIndexOfSubList(list, list2);
        // 返回一个包含 enumeration 元素的list集合
        ArrayList<String> list3 = Collections.list(enumeration);
        // 返回一个由特定排序指定的最大元素
        String max = Collections.max(list, String::compareTo);
        // 返回list4 ，list4不可变，内容都为str
        List<String> list4 = Collections.nCopies(10, "str");

    }


    public static void littleDemo() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(9);
        linkedList.add(11);
        linkedList.add(-8);
        linkedList.add(-12);
        Comparator<Integer> objectComparator = Collections.reverseOrder();
        Collections.sort(linkedList, objectComparator);
        for (Integer integer : linkedList) {
            System.out.println(integer);
        }
        Collections.shuffle(linkedList);
        for (Integer integer : linkedList) {
            System.out.println(integer);
        }
        System.out.println("min:" + Collections.min(linkedList));
        System.out.println("max:" + Collections.max(linkedList));
    }

    public static void arraysDemo() {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = -3 * i;
        }
        display(array);
        Arrays.sort(array);
        System.out.println("sorted:");
        display(array);
        Arrays.fill(array, 2, 6, -1);
        System.out.println("after fill:");
        display(array);
        Arrays.sort(array);
        System.out.println("after sorting again:");
        display(array);
        System.out.println("the value  - 9 is at location:");
        int index = Arrays.binarySearch(array, -9);
        System.out.println(index);
    }

    private static void display(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public static void vectorDemo() {
        Vector<Integer> vector = new Vector<>(3, 2);
        System.out.println("size:" + vector.size());
        System.out.println("capacity:" + vector.capacity());
        vector.addElement(1);
        vector.addElement(2);
        vector.addElement(3);
        vector.addElement(4);
        System.out.println("current capacity:" + vector.capacity());
        vector.addElement(5);
        System.out.println("current capacity:" + vector.capacity());
        vector.addElement(6);
        System.out.println("current capacity:" + vector.capacity());
        vector.addElement(7);
        System.out.println("current capacity:" + vector.capacity());
        System.out.println("first:" + vector.firstElement());
        System.out.println("last:" + vector.lastElement());
        if (vector.contains(3)) {
            System.out.println("vector contains 3");
        }
        Enumeration<Integer> elements = vector.elements();
        while (elements.hasMoreElements()) {
            System.out.print(elements.nextElement() + " ");
        }
    }

    public static void stackDemo() {
        Stack<Integer> stack = new Stack<>();
        stack.push(42);
        stack.push(22);
        stack.push(33);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.pop();
        System.out.println(stack.isEmpty());
    }


    public static void hashTableDemo() {
        Hashtable<String, Double> table = new Hashtable<>();
        table.put("John Doe", new Double(3434.34));
        table.put("Tom Smith", new Double(123.22));
        table.put("Jane Baker", new Double(1378.00));
        table.put("Tod Hall", new Double(99.22));
        table.put("Ralph Smith", new Double(-19.08));
        Enumeration<String> keys = table.keys();
        while (keys.hasMoreElements()) {
            String str = keys.nextElement();
            System.out.println("value :" + table.get(str));
        }

        Set<String> strings = table.keySet();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println("value :" + table.get(str));
        }
    }


    public static void propertiesDemo() {
        Properties properties = new Properties();
        properties.put("username", "liangjia");
        properties.put("password", "123456");
        properties.put("url", "127.0.0.1");
        properties.put("user", "liangjia");
        properties.put("path", "/usr");
        Set<Object> set = properties.keySet();
        for (Object o : set) {
            System.out.println("name:" + o + ",value:" + properties.get(o));
        }
        properties.getProperty("John", "not found");
        properties.getOrDefault("John", "not found");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name, number;
        FileInputStream fileInputStream = null;
        boolean changed = false;
        try {
            fileInputStream = new FileInputStream("phonebook.dat");
            if (fileInputStream != null) {
                properties.load(fileInputStream);
                fileInputStream.close();
            }
            do{
                name = reader.readLine();
                if ("quit".equals(name)) {
                    continue;
                }
                number = reader.readLine();
                properties.put(name,number);
                changed = true;
            }while (!"quit".equals(name));
            if (changed) {
                FileOutputStream fileOutputStream = new FileOutputStream("phonebook.dat");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
