package com.longluo.contest.biweekly_contest_92;

/**
 * https://leetcode.cn/contest/biweekly-contest-92
 */

/**
 * https://leetcode.cn/problems/minimum-penalty-for-a-shop/
 */
public class Problem3 {

    // BF time: O(n^2) space: O(1)
    // TLE
    public static int bestClosingTime_bf(String customers) {
        int len = customers.length();

        int ans = len;

        int price = Integer.MAX_VALUE;
        int cost = 0;

        for (int i = 0; i <= len; i++) {
            int cnt = 0;
            for (int j = i; j <= len; j++) {
                if (j < len && customers.charAt(j) == 'Y') {
                    cnt++;
                }
            }

            if (cnt + cost < price) {
                price = cnt + cost;
                ans = i;
            }

            if (i < len && customers.charAt(i) == 'N') {
                cost++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + bestClosingTime_bf("YN"));
        System.out.println("4 ?= " + bestClosingTime_bf("YNYY"));
        System.out.println("4 ?= " + bestClosingTime_bf("YYNYNY"));
        System.out.println("4 ?= " + bestClosingTime_bf("YYYNYN"));
        System.out.println(" ?= " + bestClosingTime_bf("YYNY"));
        System.out.println(" ?= " + bestClosingTime_bf("YYNYY"));
        System.out.println(" ?= " + bestClosingTime_bf("NNNNN"));
        System.out.println("4 ?= " + bestClosingTime_bf("YYYY"));
    }
}
