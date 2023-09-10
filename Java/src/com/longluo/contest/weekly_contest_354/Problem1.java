package com.longluo.contest.weekly_contest_354;

/**
 * https://leetcode.cn/contest/weekly-contest-354
 */
public class Problem1 {

    public static int sumOfSquares(int[] nums) {
        int n = nums.length;

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                ans += nums[i - 1] * nums[i - 1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("63 ?= " + sumOfSquares(new int[]{2, 7, 1, 19, 18, 3}));
    }
}
