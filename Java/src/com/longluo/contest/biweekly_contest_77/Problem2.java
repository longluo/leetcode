package com.longluo.contest.biweekly_contest_77;

/**
 * https://leetcode.cn/contest/biweekly-contest-77/
 */

/**
 * https://leetcode.cn/problems/minimum-average-difference/
 */
public class Problem2 {

    // BF time: O(n^2) space: O(1)
    // TLE
    public static int minimumAverageDifference_bf(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }

        int ans = 0;
        long minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            long leftSum = 0;
            for (int j = 0; j <= i; j++) {
                leftSum += nums[j];
            }

            long rightSum = 0;
            for (int j = i + 1; j < len; j++) {
                rightSum += nums[j];
            }

            long diff = 0;
            if (i == len - 1) {
                diff = leftSum / len;
            } else {
                diff = Math.abs(leftSum / (i + 1) - rightSum / (len - i - 1));
            }

            if (diff < minDiff) {
                ans = i;
                minDiff = diff;
            }
        }

        return ans;
    }

    public static int minimumAverageDifference(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }

        long[] sums = new long[len + 1];

        for (int i = 1; i <= len; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        int ans = 0;
        long minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            long diff = 0;
            if (i == len - 1) {
                diff = sums[len] / len;
            } else {
                diff = Math.abs(sums[i + 1] / (i + 1) - (sums[len] - sums[i + 1]) / (len - i - 1));
            }
            if (diff < minDiff) {
                minDiff = diff;
                ans = i;
            } else if (diff == minDiff) {
                ans = Math.min(ans, i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + minimumAverageDifference(new int[]{0}));
        System.out.println("0 ?= " + minimumAverageDifference(new int[]{1}));
        System.out.println("3 ?= " + minimumAverageDifference(new int[]{2, 5, 3, 9, 5, 3}));
        System.out.println("3 ?= " + minimumAverageDifference_bf(new int[]{2, 5, 3, 9, 5, 3}));
    }
}
