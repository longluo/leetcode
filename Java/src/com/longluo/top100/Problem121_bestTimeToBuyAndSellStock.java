package com.longluo.top100;

/**
 * 121. Best Time to Buy and Sell Stock
 * <p>
 * Easy
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day
 * in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * <p>
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * <p>
 * Constraints:
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^4
 * <p>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Problem121_bestTimeToBuyAndSellStock {

    // BF time: O(n^2) space: O(1)
    // TLE
    public static int maxProfit_bf(int[] prices) {
        int len = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (prices[j] <= prices[i]) {
                    continue;
                }

                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    // DP time: O(n) space: O(n)
    public static int maxProfit_dp(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[len - 1][0];
    }

    // One Scan time: O(n) space: O(1)
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < len; i++) {
            minPrice = Math.min(prices[i], minPrice);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + maxProfit_bf(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("0 ?= " + maxProfit_bf(new int[]{7, 6, 4, 3, 1}));

        System.out.println("5 ?= " + maxProfit_dp(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("0 ?= " + maxProfit_dp(new int[]{7, 6, 4, 3, 1}));

        System.out.println("5 ?= " + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("0 ?= " + maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
