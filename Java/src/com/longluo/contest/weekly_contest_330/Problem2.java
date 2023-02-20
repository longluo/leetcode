package com.longluo.contest.weekly_contest_330;

/**
 * https://leetcode.cn/contest/weekly-contest-330
 */
public class Problem2 {

    // Math time: O(n) space: O(1)
    // TLE
    public static int monkeyMove(int n) {
        int mod = 1_000_000_007;

        long sum = 1;

        for (int i = 0; i < n; i++) {
            sum *= 2;

            if (sum - 1 > mod) {
                sum %= mod;
            }
        }

        return (int) (sum - 2);
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + monkeyMove(3));
        System.out.println("14 ?= " + monkeyMove(4));
        System.out.println("1000000006 ?= " + monkeyMove(500000003));
    }
}
