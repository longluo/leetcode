package com.longluo.contest.weekly_contest_342;

/**
 * https://leetcode.cn/contest/weekly-contest-342
 */
public class Problem2 {

    public static int sumOfMultiples(int n) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                ans += i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
