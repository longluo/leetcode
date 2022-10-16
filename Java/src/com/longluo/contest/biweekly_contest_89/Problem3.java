package com.longluo.contest.biweekly_contest_89;

public class Problem3 {

    public static int minimizeArrayValue(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return nums[0];
        }

        int max = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                max = Math.max(max, nums[i]);
            }
        }

        int average = (nums[0] + max) / 2;
        int steps = (max - nums[0]) / 2;

        return Math.max(average, nums[0] + steps);
    }

    public static void main(String[] args) {

    }
}
