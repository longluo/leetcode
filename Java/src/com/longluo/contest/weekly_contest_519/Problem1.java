package com.longluo.contest.weekly_contest_519;

/**
 * https://leetcode.cn/contest/weekly-contest-519
 */
public class Problem1 {

    public static int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        for (int i = 0; i < n; i++) {
            if (rowShift[i] == 0) {
                continue;
            }

            int k = rowShift[i];
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                temp[j] = grid[i][(j + k) % n];
            }

            for (int j = 0; j < n; j++) {
                grid[i][j] = temp[j];
            }
        }

        for (int j = 0; j < n; j++) {
            if (colShift[j] == 0) {
                continue;
            }

            int k = colShift[j];
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                temp[i] = grid[(i + k) % n][j];
            }

            for (int i = 0; i < n; i++) {
                grid[i][j] = temp[i];
            }
        }

        return grid;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + cyclicShift(2, new int[][]{{1, 2}, {3, 4}}, new int[]{1, 0}, new int[]{0, 1}));
        System.out.println("1 ?= " + cyclicShift(3, new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[]{1, 2, 0}, new int[]{2, 2, 1}));
    }
}
