package com.longluo.contest.weekly_contest_352;

/**
 * https://leetcode.cn/contest/weekly-contest-352
 */
public class Problem1 {

    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0 || nums[i] > threshold) {
                continue;
            }

            int cnt = 1;
            int prev = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > threshold || prev % 2 == nums[j] % 2) {
                    break;
                }

                cnt++;
                prev = nums[j];
            }

            ans = Math.max(ans, cnt);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + longestAlternatingSubarray(new int[]{3, 2, 5, 4}, 5));
        System.out.println("1 ?= " + longestAlternatingSubarray(new int[]{1, 2}, 2));
    }
}
