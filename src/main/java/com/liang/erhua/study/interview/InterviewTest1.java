package com.liang.erhua.study.interview;

/**
 * @author ${user}
 * @version 1.0
 * @date ${time}/${date}
 */
public class InterviewTest1 {
    public static void main(String[] args) {
        int[] intArr = {1, 2, -3, -66, 99, 22, -80, 132};
        getMaxTwo(intArr);

    }

    /**
     * 求一个数组中两个相邻的数之和最大的两个值
     *
     * @param intArr
     */
    private static void getMaxTwo(int[] intArr) {
        if (intArr.length < 1) {
            System.out.println("数组长度不正确");
            System.exit(0);
        }
        if (intArr.length < 2) {
            System.out.println("序列是0和1");
            System.exit(0);
        }
        int sum = intArr[0] + intArr[1];
        int index = 1;
        for (int i = 1, len = intArr.length; i < len; i++) {
            int tempNum = intArr[i] + intArr[i - 1];
            if (tempNum > sum) {
                index = i;
                sum = tempNum;
            }
        }
        System.out.println(String.format("第%s个数和第%s个数的和最大", index, index + 1));
    }
}
