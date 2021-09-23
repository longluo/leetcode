package com.longluo.leetcode.recursion;

/**
 * 509. 斐波那契数
 * <p>
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
 *
 * 也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 * <p>
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * <p>
 * 示例 2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * <p>
 * 示例 3：
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * <p>
 * 提示：
 * 0 <= n <= 30
 * <p>
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class Problem509_fib {
    // Dynamic Programming
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] dp = new int[32];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Recursive
    public static int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fib2(n - 1) + fib2(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + fib(0));
        System.out.println("1 ?= " + fib(1));
        System.out.println("1 ?= " + fib(2));
        System.out.println("2 ?= " + fib(3));
        System.out.println("3 ?= " + fib(4));

        System.out.println("0 ?= " + fib2(0));
        System.out.println("1 ?= " + fib2(1));
        System.out.println("1 ?= " + fib2(2));
        System.out.println("2 ?= " + fib2(3));
        System.out.println("3 ?= " + fib2(4));
    }
}
