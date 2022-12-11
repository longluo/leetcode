package com.longluo.contest.weekly_contest_323;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-323
 */

/**
 * https://leetcode.cn/problems/delete-greatest-value-in-each-row/
 */
public class Problem1 {

    // Sort time: O(mnlogn * mn) space: O(logn)
    public static int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            Arrays.sort(grid[i]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, grid[j][n - 1 - i]);
            }

            ans += max;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("8 ?= " + deleteGreatestValue(new int[][]{{1, 2, 4}, {3, 3, 1}}));
    }
}
