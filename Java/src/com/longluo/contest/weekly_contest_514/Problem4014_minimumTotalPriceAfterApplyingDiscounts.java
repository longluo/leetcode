package com.longluo.contest.weekly_contest_514;

import java.util.Arrays;

/**
 * 4014. 应用折扣后的最低总价
 * <p>
 * https://leetcode.cn/problems/minimum-total-price-after-applying-discounts/description/
 */
public class Problem4014_minimumTotalPriceAfterApplyingDiscounts {

    public static double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        double ans = 0.0;

        int priceLen = prices.length;
        int disLen = discounts.length;

        for (int i = priceLen - 1, j = disLen - 1; i >= 0; i--, j--) {
            if (j >= 0) {
                double price = prices[i];
                double discount = discounts[j];
                ans += price * (100 - discount) / 100;
            } else {
                ans += prices[i];
            }

            disLen--;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("32.5000 ?= " + minPrice(new int[]{10, 30, 21}, new int[]{50, 60}));
    }
}
