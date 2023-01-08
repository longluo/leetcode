package com.longluo.contest.weekly_contest_327;

/**
 * https://leetcode.cn/contest/weekly-contest-327
 */
public class Problem1 {

    public static int maximumCount(int[] nums) {
        int n = nums.length;

        int pos = 0;
        int neg = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                neg++;
            } else if (nums[i] > 0) {
                pos = n - i;
                break;
            }
        }

        return Math.max(pos, neg);
    }

    public static void main(String[] args) {

    }
}
