package com.longluo.contest.biweekly_contest_92;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/biweekly-contest-92
 */

public class Problem2 {

    public static int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowCnt = new int[m];
        int[] colCnt = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCnt[i]++;
                    colCnt[j]++;
                }
            }
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = rowCnt[i] + colCnt[j] - (n - rowCnt[i]) - (m - colCnt[j]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[[0,0,4], [0,0,4], [-2,-2,2]] ?= " + Arrays.deepToString(onesMinusZeros(new int[][]{{0, 1, 1}, {1, 0, 1}, {0, 0, 1}})));
        System.out.println("[[5,5,5], [5,5,5]] ?= " + Arrays.deepToString(onesMinusZeros(new int[][]{{1, 1, 1}, {1, 1, 1}})));
    }
}
