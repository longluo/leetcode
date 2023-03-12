package com.longluo.contest.weekly_contest_336;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-336
 */

/**
 * https://leetcode.cn/problems/rearrange-array-to-maximize-prefix-score/
 */
public class Problem2 {

    public static int maxScore(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;

        int ans = 0;
        long sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum > 0) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + maxScore(new int[]{-2, -3, 0}));
        System.out.println("6 ?= " + maxScore(new int[]{2, -1, 0, 1, -3, 3, -3}));
    }
}
