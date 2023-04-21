package com.longluo.contest.weekly_contest_311;

/**
 * https://leetcode.cn/contest/weekly-contest-311/
 */

/**
 * 2413. 最小偶倍数
 * <p>
 * 给你一个正整数 n ，返回 2 和 n 的最小公倍数（正整数）。
 * <p>
 * 示例 1：
 * 输入：n = 5
 * 输出：10
 * 解释：5 和 2 的最小公倍数是 10 。
 * <p>
 * 示例 2：
 * 输入：n = 6
 * 输出：6
 * 解释：6 和 2 的最小公倍数是 6 。注意数字会是它自身的倍数。
 * <p>
 * 提示：
 * 1 <= n <= 150
 * <p>
 * https://leetcode.cn/problems/smallest-even-multiple/
 */
public class Problem2413_smallestEvenMultiple {

    public static int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : 2 * n;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + smallestEvenMultiple(1));
        System.out.println("2 ?= " + smallestEvenMultiple(2));
        System.out.println("10 ?= " + smallestEvenMultiple(5));
        System.out.println("6 ?= " + smallestEvenMultiple(6));
    }
}
