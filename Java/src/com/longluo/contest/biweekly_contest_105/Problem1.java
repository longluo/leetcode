package com.longluo.contest.biweekly_contest_105;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/biweekly-contest-105
 */
public class Problem1 {

    public static int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);

        int sum = prices[0] + prices[1];

        return sum > money ? money : money - sum;
    }

    public static void main(String[] args) {

    }
}
