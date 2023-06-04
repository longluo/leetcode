package com.longluo.contest.weekly_contest_348;

/**
 * https://leetcode.cn/contest/weekly-contest-348
 */
public class Problem3 {

    public static long matrixSumQueries_bf(int n, int[][] queries) {
        int[][] grid = new int[n][n];

        for (int[] query : queries) {
            int type = query[0];
            int idx = query[1];
            int value = query[2];

            if (type == 0) {
                for (int i = 0; i < n; i++) {
                    grid[idx][i] = value;
                }
            } else {
                for (int i = 0; i < n; i++) {
                    grid[i][idx] = value;
                }
            }
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += grid[i][j];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("23 ?= " + matrixSumQueries_bf(3, new int[][]{{0, 0, 1}, {1, 2, 2}, {0, 2, 3}, {1, 0, 4}}));
        System.out.println("17 ?= " + matrixSumQueries_bf(3, new int[][]{{0, 0, 4}, {0, 1, 2}, {1, 0, 1}, {0, 2, 3}, {1, 2, 1}}));
    }
}