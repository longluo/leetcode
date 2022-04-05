package com.longluo.contest.biweekly_contest_75;

public class Problem2 {

    public static int triangularSum(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return nums[0];
        }

        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[0][i] = nums[i];
        }

        for (int i = len - 1; i >= 0; i--) {
            int rowIdx = len - i;
            for (int j = 0; j < i; j++) {
                dp[rowIdx][j] = (dp[rowIdx - 1][j] + dp[rowIdx - 1][j + 1]) % 10;
            }
        }

        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        triangularSum(new int[]{1, 2, 3, 4, 5});
        triangularSum(new int[]{5});
    }
}
