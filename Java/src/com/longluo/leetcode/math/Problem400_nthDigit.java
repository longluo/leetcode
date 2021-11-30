package com.longluo.leetcode.math;

/**
 * 400. 第 N 位数字
 * <p>
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 * <p>
 * 提示：
 * 1 <= n <= 2^31 - 1
 * 第 n 位上的数字是按计数单位（digit）从前往后数的第 n 个数，参见 示例 2 。
 * <p>
 * https://leetcode-cn.com/problems/nth-digit/
 */
public class Problem400_nthDigit {

    public static int findNthDigit(int n) {
        if (n <= 9) {
            return n;
        }

        int[] mem = new int[11];
        mem[1] = 9;
        mem[2] = 29;
        for (int i = 3; i <= 10; i++) {
            mem[i] = 9 * i * (int) Math.pow(10, i - 1) + mem[i - 1];
        }

        int sum = 0;
        int bits = 1;
        int idx = 1;
        while (sum <= n) {
            sum = mem[bits];
            bits++;
        }

        return idx % 10;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + findNthDigit(3));
        System.out.println("0 ?= " + findNthDigit(11));
    }
}
