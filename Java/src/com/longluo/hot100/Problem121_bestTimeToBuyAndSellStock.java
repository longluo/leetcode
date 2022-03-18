package com.longluo.hot100;

/**
 * 121. Best Time to Buy and Sell Stock
 * Easy
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
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 * <p>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Problem121_bestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (prices[j] <= prices[i]) {
                    continue;
                }
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }

        return maxProfit;
    }

    public static int maxProfit_bf(int[] prices) {
        int len = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public static int maxProfit_opt(int[] prices) {
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
        System.out.println("5 ?= " + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("0 ?= " + maxProfit(new int[]{7, 6, 4, 3, 1}));

        System.out.println("5 ?= " + maxProfit_opt(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("0 ?= " + maxProfit_opt(new int[]{7, 6, 4, 3, 1}));
    }
}
