package com.longluo.offer_ii;

/**
 * 剑指 Offer II 072. 求平方根
 * <p>
 * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
 * 正数的平方根有两个，只输出其中的正数平方根。
 * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * 输入: x = 4
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: x = 8
 * 输出: 2
 * 解释: 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
 * <p>
 * 提示:
 * 0 <= x <= 2^31 - 1
 * <p>
 * 注意：本题与主站 69 题相同： https://leetcode-cn.com/problems/sqrtx/
 * <p>
 * https://leetcode-cn.com/problems/jJ0w9p/
 */
public class Offer2_72_mysqrt {

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        for (int i = 1; i * i <= x; i++) {
            long product = i * i;
            long bigger = product + 2 * i + 1;
            if (product == x) {
                return i;
            } else if (bigger == x) {
                return i + 1;
            } else if (product < x && bigger > x) {
                return i;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + mySqrt(0));
        System.out.println("1 ?= " + mySqrt(1));
        System.out.println("2 ?= " + mySqrt(4));
        System.out.println("2 ?= " + mySqrt(8));
        System.out.println("46340 ?= " + mySqrt(2147395600));
        System.out.println("46340 ?= " + mySqrt(2147483647));
    }
}
