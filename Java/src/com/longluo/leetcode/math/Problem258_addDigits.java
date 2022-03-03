package com.longluo.leetcode.math;

/**
 * 258. 各位相加
 * <p>
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 * <p>
 * 示例 1:
 * 输入: num = 38
 * 输出: 2
 * 解释: 各位相加的过程为：
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * 由于 2 是一位数，所以返回 2。
 * <p>
 * 示例 1:
 * 输入: num = 0
 * 输出: 0
 * <p>
 * 提示：
 * 0 <= num <= 2^31 - 1
 * <p>
 * https://leetcode-cn.com/problems/add-digits/
 */
public class Problem258_addDigits {

    public static int addDigits(int num) {
        if (num == 0) {
            return 0;
        }

        if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + addDigits(0));
        System.out.println("1 ?= " + addDigits(1));
        System.out.println("9 ?= " + addDigits(9));
        System.out.println("1 ?= " + addDigits(10));
        System.out.println("2 ?= " + addDigits(38));
    }
}

