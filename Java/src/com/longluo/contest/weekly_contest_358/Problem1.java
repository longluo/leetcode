package com.longluo.contest.weekly_contest_358;

/**
 * https://leetcode.cn/contest/weekly-contest-358
 */
public class Problem1 {

    public static int maxSum(int[] nums) {
        int n = nums.length;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String numA = String.valueOf(nums[i]);
                String numB = String.valueOf(nums[j]);

                int maxA = 0;
                for (char ch : numA.toCharArray()) {
                    maxA = Math.max(maxA, ch - '0');
                }

                int maxB = 0;
                for (char ch : numB.toCharArray()) {
                    maxB = Math.max(maxB, ch - '0');
                }

                if (maxA == maxB) {
                    ans = Math.max(ans, nums[i] + nums[j]);
                }
            }
        }

        return ans > 0 ? ans : -1;
    }

    public static void main(String[] args) {
        System.out.println("88 ?= " + maxSum(new int[]{51, 71, 17, 24, 42}));
        System.out.println("-1 ?= " + maxSum(new int[]{1, 2, 3, 4}));
    }
}
