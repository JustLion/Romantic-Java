package com.liang.erhua.datastructure.queue;

/**
 * @author liangjia
 * @version 1.0
 * @date 18:17/2020-04-11
 * @description 深入理解环形队列算法
 */
public class CircleQueue {
    /**
     * 环形队列的最大容量为 maxSize - 1
     */
    private int maxSize;
    /**
     * 环形队列列头,指向队列第一个元素，front初始值为0
     */
    private int front;
    /**
     * 环形队列列尾，指向队列尾部元素的后一个位置，rear初始值为0
     */
    private int rear;
    /**
     * 实现队列的数组
     */
    private int[] arr;

    /**
     * 初始化环形队列 front = 1，rear = 1
     *
     * @param maxSize 初始化队列容量
     */
    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否已满
     *
     * @return true or false
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 把元素添加到队列
     *
     * @param num 需要添加的元素
     */
    public void addQueue(int num) {
        // 首先判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满，添加失败~~");
            return;
        }
        arr[rear] = num;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 从队列中取出数据
     *
     * @return 取出的数据
     */
    public int getQueue() {
        //首先判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取出数据~~");
        }
        // 即将取出的元素
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 展示队列中数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列是空的，无数据~~");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 获取队列长度
     *
     * @return 队列长度
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 取出队列头部元素
     *
     * @return 队列头部元素
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空~~");
        }
        return arr[front];
    }
}
