package com.liang.erhua.datastructure.queue;

/**
 * @author liangjia
 * @version 1.0
 * @date 16:28/2020-04-11
 * @description 数组实现队列，此方法不完备
 */
public class ArrayQueue {
    /**
     * 数组的最大容量
     */
    private int maxSize;
    /**
     * 队列头,指向队列第一个元素的前一个位置
     */
    private int front;
    /**
     * 队列尾，指向队列尾部元素
     */
    private int rear;
    /**
     * 实现队列的数组
     */
    private int[] arr;

    /**
     * 初始化队列
     *
     * @param maxSize 初始化队列容量
     */
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        // 指向队列头部，分析出front是指向队列头的前一个位置
        front = -1;
        // 指向队尾数据
        rear = -1;
    }

    /**
     * 判断队列是否已满
     *
     * @return true or false
     */
    public boolean isFull() {
        return rear == maxSize - 1;
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
        rear++;
        arr[rear] = num;
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
        front++;
        return arr[front];
    }

    /**
     * 展示队列中数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列是空的，无数据~~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * 取出队列头元素
     *
     * @return 队列头元素
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空~~");
        }
        return arr[front + 1];
    }

}
