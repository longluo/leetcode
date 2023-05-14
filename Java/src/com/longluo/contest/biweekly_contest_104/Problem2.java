package com.longluo.contest.biweekly_contest_104;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/biweekly-contest-104
 */
public class Problem2 {

    public static int matrixSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;

        for (int i = 0; i < m; i++) {
            Arrays.sort(nums[i]);
        }

        int ans = 0;

        for (int j = 0; j < n; j++) {
            int max = nums[0][n - 1 - j];

            for (int i = 0; i < m; i++) {
                max = Math.max(max, nums[i][n - 1 - j]);
            }

            ans += max;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + matrixSum(new int[][]{{1}}));
        System.out.println("15 ?= " + matrixSum(new int[][]{{7, 2, 1}, {6, 4, 2}, {6, 5, 3}, {3, 2, 1}}));
    }
}
