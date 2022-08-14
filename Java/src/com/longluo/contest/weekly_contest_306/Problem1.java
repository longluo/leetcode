package com.longluo.contest.weekly_contest_306;

public class Problem1 {

    public static int[][] largestLocal(int[][] grid) {
        int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int max = grid[i][j];
                for (int[] dir : dirs) {
                    int nextX = i + dir[0];
                    int nextY = j + dir[1];
                    max = Math.max(max, grid[nextX][nextY]);
                }

                ans[i - 1][j - 1] = max;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
