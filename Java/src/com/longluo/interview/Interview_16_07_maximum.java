package com.longluo.interview;

/**
 * 面试题 16.07. 最大数值
 * <p>
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 * <p>
 * 示例：
 * 输入： a = 1, b = 2
 * 输出： 2
 *
 *
 */
public class Interview_16_07_maximum {

    public static int maximum(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + maximum(1, 2));
    }
}
