package com.longluo.contest.weekly_contest_347;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/contest/weekly-contest-347
 */
public class Problem2 {

    public static int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Set<Integer> left = new HashSet<>();
                for (int k = 1; i - k >= 0 && j - k >= 0; k++) {
                    left.add(grid[i - k][j - k]);
                }

                Set<Integer> right = new HashSet<>();
                for (int k = 1; i + k < m && j + k < n; k++) {
                    right.add(grid[i + k][j + k]);
                }

                ans[i][j] = Math.abs(left.size() - right.size());
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[[1, 1, 0], [1, 0, 1], [0, 1, 1]] ?= " + Arrays.deepToString(differenceOfDistinctValues(new int[][]{{1, 2, 3}, {3, 1, 5}, {3, 2, 1}})));
    }
}
