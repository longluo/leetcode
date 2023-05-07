package com.longluo.contest.weekly_contest_344;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-344
 */
public class Problem3 {

    // TLE
    public static int[] colorTheArray(int n, int[][] queries) {
        int[] nums = new int[n];

        int len = queries.length;

        int[] ans = new int[len];

        nums[queries[0][0]] = queries[0][1];

        for (int i = 1; i < len; i++) {
            int count = 0;

            nums[queries[i][0]] = queries[i][1];

            for (int j = 0; j < n - 1; j++) {
                if (nums[j] == nums[j + 1] && nums[j] != 0) {
                    count++;
                }
            }

            ans[i] = count;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[1] ?= " + Arrays.toString(colorTheArray(1, new int[][]{{0, 100000}})));
        System.out.println("[0, 1, 1, 0, 2] ?= " + Arrays.toString(colorTheArray(4, new int[][]{{0, 2}, {1, 2}, {3, 1}, {1, 1}, {2, 1}})));
    }
}