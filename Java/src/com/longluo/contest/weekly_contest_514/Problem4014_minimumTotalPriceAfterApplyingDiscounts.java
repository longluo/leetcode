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

        double sum = 0.0;

        int priceLen = prices.length;
        int disLen = discounts.length - 1;

        for (int i = priceLen - 1; i >= 0; i--) {
            if (disLen >= 0) {
                sum += prices[i] * (((double) (100 - discounts[disLen])) / 100);
            } else {
                sum += prices[i];
            }

            disLen--;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("32.5000 ?= " + minPrice(new int[]{10, 30, 21}, new int[]{50, 60}));
    }
}
