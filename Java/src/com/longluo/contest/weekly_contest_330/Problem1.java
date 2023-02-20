package com.longluo.contest.weekly_contest_330;

/**
 * https://leetcode.cn/contest/weekly-contest-330
 */
public class Problem1 {

    public static int distinctIntegers(int n) {
        if (n <= 2) {
            return 1;
        }

        return n - 1;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + distinctIntegers(5));
    }
}
