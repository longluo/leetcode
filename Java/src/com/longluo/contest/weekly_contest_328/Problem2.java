package com.longluo.contest.weekly_contest_328;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-328
 */
public class Problem2 {

    public static int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans = new int[n][n];

        for (int[] query : queries) {
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];

            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    ans[i][j]++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[[1, 1, 0], [1, 2, 1], [0, 1, 1]] ?= " + Arrays.deepToString(rangeAddQueries(3, new int[][]{{1, 1, 2, 2}, {0, 0, 1, 1}})));
        System.out.println("[[1,1],[1,1]] ?= " + Arrays.deepToString(rangeAddQueries(2, new int[][]{{0, 0, 1, 1}})));
    }
}
