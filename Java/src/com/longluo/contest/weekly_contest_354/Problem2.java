package com.longluo.contest.weekly_contest_354;

/**
 * https://leetcode.cn/contest/weekly-contest-354
 */
public class Problem2 {

    // TLE
    public static int maximumBeauty(int[] nums, int k) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int x : nums) {
            max = Math.max(max, x);
            min = Math.min(min, x);
        }

        if (min == max) {
            return n;
        }

        int ans = 1;

        for (int i = min; i <= max; i++) {
            int cnt = 0;
            for (int x : nums) {
                if (i - k <= x && x <= i + k) {
                    cnt++;
                }
            }

            ans = Math.max(ans, cnt);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + maximumBeauty(new int[]{4, 6, 1, 2}, 2));
        System.out.println("4 ?= " + maximumBeauty(new int[]{1, 1, 1, 1}, 10));
    }
}
