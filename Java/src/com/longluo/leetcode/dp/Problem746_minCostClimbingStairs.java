package com.longluo.leetcode.dp;

/**
 * 746. 使用最小花费爬楼梯
 * <p>
 * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 示例 1:
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 * <p>
 * 示例 2:
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * 注意：
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 * <p>
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class Problem746_minCostClimbingStairs {

    // DP time: O(n) space: O(n)
    public static int minCostClimbingStairs_dp(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[len];
    }

    // DP time: O(n) space: O(1)
    public static int minCostClimbingStairs_dp_opt(int[] cost) {
        int length = cost.length;
        int p = 0;
        int q = 0;
        int r = 0;
        for (int i = 2; i <= length; i++) {
            r = Math.min(p + cost[i - 2], q + cost[i - 1]);
            p = q;
            q = r;
        }

        return r;
    }

    // DP Method 2 time: O(n) space: O(1)
    public static int minCostClimbingStairs_dp2(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[len - 1], dp[len - 2]);
    }

    public static void main(String[] args) {
        System.out.println("15 ?= " + minCostClimbingStairs_dp(new int[]{10, 15, 20}));
        System.out.println("6 ?= " + minCostClimbingStairs_dp(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println("6 ?= " + minCostClimbingStairs_dp_opt(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
