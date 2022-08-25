package com.longluo.leetcode.recursion;

/**
 * 509. 斐波那契数
 * <p>
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
 * <p>
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
 * https://leetcode.cn/problems/fibonacci-number/
 */
public class Problem509_fibonacciNumber {

    // Recursive
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    // DP
    public static int fib_dp(int n) {
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

    public static int fib_dp_opt(int n) {
        if (n <= 1) {
            return n;
        }

        int p = 0;
        int q = 1;
        int r = 1;
        for (int i = 2; i <= n; i++) {
            r = p + q;
            p = q;
            q = r;
        }

        return r;
    }

    public static int fib_table(int n) {
        int[] fibNums = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040};
        return fibNums[n];
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + fib(0));
        System.out.println("1 ?= " + fib(1));
        System.out.println("1 ?= " + fib(2));
        System.out.println("2 ?= " + fib(3));
        System.out.println("3 ?= " + fib(4));

        System.out.println("3 ?= " + fib_dp(4));
        System.out.println("3 ?= " + fib_dp_opt(4));

        System.out.println("3 ?= " + fib_table(4));

        for (int i = 0; i <= 30; i++) {
            System.out.print(fib(i) + ",");
        }
    }
}
