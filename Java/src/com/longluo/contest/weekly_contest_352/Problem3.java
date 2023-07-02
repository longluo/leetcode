package com.longluo.contest.weekly_contest_352;

/**
 * https://leetcode.cn/contest/weekly-contest-352
 */
public class Problem3 {

    // TLE
    public static long continuousSubarrays(int[] nums) {
        int n = nums.length;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int max = nums[i];

            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                if (max - min <= 2) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("8 ?= " + continuousSubarrays(new int[]{5, 4, 2, 4}));
        System.out.println("6 ?= " + continuousSubarrays(new int[]{1, 2, 3}));
    }
}
