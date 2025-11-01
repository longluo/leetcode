package com.longluo.contest.weekly_contest_347;

/**
 * https://leetcode.cn/contest/weekly-contest-347
 */
public class Problem3 {

    public static long minimumCost(String s) {
        int n = s.length();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                ans += Math.min(i + 1, n - 1 - i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + minimumCost("0011"));
        System.out.println("9 ?= " + minimumCost("010101"));
    }
}