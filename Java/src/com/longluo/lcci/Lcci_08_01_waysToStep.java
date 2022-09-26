package com.longluo.lcci;

/**
 * 面试题 08.01. 三步问题
 * <p>
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。
 * 结果可能很大，你需要对结果模1000000007。
 * <p>
 * 示例1:
 * 输入：n = 3
 * 输出：4
 * 说明: 有四种走法
 * <p>
 * 示例2:
 * 输入：n = 5
 * 输出：13
 * <p>
 * 提示:
 * n范围在[1, 1000000]之间
 * <p>
 * https://leetcode.cn/problems/three-steps-problem-lcci/?favorite=xb9lfcwi
 */
public class Lcci_08_01_waysToStep {

    public static int waysToStep(int n) {
        if (n <= 1) {
            return 1;
        }

        long[] dp = new long[n + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] % 1000000007 + dp[i - 2] % 1000000007 + dp[i - 3] % 1000000007;
            dp[i] = dp[i] % 1000000007;
        }

        return (int) dp[n];
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + waysToStep(1));
        System.out.println("2 ?= " + waysToStep(2));
        System.out.println("4 ?= " + waysToStep(3));
        System.out.println("13 ?= " + waysToStep(5));
        System.out.println("752119970 ?= " + waysToStep(61));
    }
}
