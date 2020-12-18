package com.longluo.offer;

/**
 * 剑指 Offer 10-II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 * <p>
 * 示例 3：
 * 输入：n = 0
 * 输出：1
 * <p>
 * 提示：
 * 0 <= n <= 100
 */
public class Offer10_numberWays {

    public static int numWays(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + numWays(0));
        System.out.println("1 ?= " + numWays(1));
        System.out.println("2 ?= " + numWays(2));
        System.out.println("21 ?= " + numWays(7));
        System.out.println("971215059 ?= " + numWays(46));
        System.out.println("720754435 ?= " + numWays(92));
    }
}
