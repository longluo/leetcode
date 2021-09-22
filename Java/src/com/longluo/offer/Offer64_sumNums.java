package com.longluo.offer;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * <p>
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 * <p>
 * 示例 2：
 * 输入: n = 9
 * 输出: 45
 * <p>
 * 限制：
 * 1 <= n <= 10000
 * <p>
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 */
public class Offer64_sumNums {

    public static int sumNums(int n) {
        if (n <= 1) {
            return n;
        }

        return n + sumNums(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + sumNums(3));
        System.out.println("45 ?= " + sumNums(9));
    }
}
