package com.longluo.top100;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * <p>
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * <p>
 * 示例 2:
 * 输入: prices = [1]
 * 输出: 0
 * <p>
 * 提示：
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 * <p>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class Problem309_bestTimeToBuyAndSellStockWithCooldown {

    // DP time: O(n) space: O(n)
    public static int maxProfit(int[] prices) {
        int len = prices.length;

        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], i >= 2 ? dp[i - 2][0] - prices[i] : -prices[i]);
        }

        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
