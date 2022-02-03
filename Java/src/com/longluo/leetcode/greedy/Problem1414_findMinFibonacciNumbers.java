package com.longluo.leetcode.greedy;

/**
 * 1414. 和为 K 的最少斐波那契数字数目
 * <p>
 * 给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
 * <p>
 * 斐波那契数字定义为：
 * F1 = 1
 * F2 = 1
 * Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
 * 数据保证对于给定的 k ，一定能找到可行解。
 * <p>
 * 示例 1：
 * 输入：k = 7
 * 输出：2
 * 解释：斐波那契数字为：1，1，2，3，5，8，13，……
 * 对于 k = 7 ，我们可以得到 2 + 5 = 7 。
 * <p>
 * 示例 2：
 * 输入：k = 10
 * 输出：2
 * 解释：对于 k = 10 ，我们可以得到 2 + 8 = 10 。
 * <p>
 * 示例 3：
 * 输入：k = 19
 * 输出：3
 * 解释：对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19 。
 * <p>
 * 提示：
 * 1 <= k <= 10^9
 * <p>
 * https://leetcode-cn.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
 */
public class Problem1414_findMinFibonacciNumbers {

    public static int findMinFibonacciNumbers(int k) {
        int[] dp = new int[45];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < 45; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int ans = 0;
        for (int i = 44; i >= 0; i--) {
            if (dp[i] == k) {
                return 1;
            } else if (dp[i] < k) {
                int rest = k - dp[i];
                ans++;
                for (int j = i - 2; j >= 0; j--) {
                    if (rest == 0) {
                        return ans;
                    }
                    if (dp[j] <= rest) {
                        ans++;
                        rest -= dp[j];
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + findMinFibonacciNumbers(1));
        System.out.println("2 ?= " + findMinFibonacciNumbers(7));
        System.out.println("2 ?= " + findMinFibonacciNumbers(10));
        System.out.println("3 ?= " + findMinFibonacciNumbers(19));
    }
}
