package com.longluo.contest.weekly_contest_349;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-349
 */
public class Problem4 {

    public static int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int m = nums1.length;

        int n = queries.length;

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = queries[i][0];
            int y = queries[i][1];

            int max = 0;

            for (int j = 0; j < m; j++) {
                if (nums1[j] >= x && nums2[j] >= y) {
                    max = Math.max(max, nums1[j] + nums2[j]);
                }
            }

            ans[i] = max == 0 ? -1 : max;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[6, 10, 7] ?= " + Arrays.toString(maximumSumQueries(new int[]{4, 3, 1, 2}, new int[]{2, 4, 9, 5}, new int[][]{{4, 1}, {1, 3}, {2, 5}})));
        System.out.println("[9, 9, 9] ?= " + Arrays.toString(maximumSumQueries(new int[]{3, 2, 5}, new int[]{2, 3, 4}, new int[][]{{4, 4}, {3, 2}, {1, 1}})));
        System.out.println("[-1] ?= " + Arrays.toString(maximumSumQueries(new int[]{2, 1}, new int[]{2, 3}, new int[][]{{3, 3}})));
    }
}