package com.liang.erhua.study.interview;

import java.util.*;

/**
 * @author liangjia
 * @version 1.0
 * @date 21:33/2020-03-26
 * @description
 */
public class SortUser {
    public static void main(String[] args) {
        sortHashMap();
        sortList();
    }

    /**
     * hashMap 中 User 的年龄逆序排序
     */
    public static void sortHashMap() {
        HashMap<Integer,User> users = new HashMap<>();
        users.put(1, new User("张三", 25));
        users.put(3, new User("李四", 22));
        users.put(2, new User("王五", 28));
        System.out.println(users);
        Set<Map.Entry<Integer, User>> entrySet = users.entrySet();
        List<Map.Entry<Integer,User>> list  = new ArrayList<>(entrySet);
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge()-o1.getValue().getAge();
            }
        });

        LinkedHashMap<Integer,User> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, User> entry : list) {
            linkedHashMap.put(entry.getKey(),entry.getValue());
        }
        System.out.println(linkedHashMap);
    }

    /**
     * list 中 User 的年龄正序排序
     */
    public static void sortList() {
        List<User> list = new ArrayList<>();
        list.add(new User("张三", 25));
        list.add(new User("李四", 22));
        list.add(new User("王五", 28));
        System.out.println(list);
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println(list);
    }

    /**
     * 获得线程安全的集合
     */
    public static void getSafeCollection() {
        // 获取线程安全的list集合
        List<Object> objects = Collections.synchronizedList(new ArrayList<>());
        // 获得线程安全的set集合
        Set<Object> objects1 = Collections.synchronizedSet(new HashSet<>());
        // 获得线程安全的map集合
        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());
        // 获得线程安全的集合
        Collection<Object> objects2 = Collections.synchronizedCollection(new ArrayList<>());
    }
}
