package com.longluo.contest.weekly_contest_313;

public class Problem2 {

    public static int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int max = 0;

        for (int i = 0; i <= m - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    sum += grid[i][j + k];
                    sum += grid[i + 2][j + k];
                }

                sum += grid[i + 1][j + 1];
                max = Math.max(max, sum);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(" " + maxSum(new int[][]{{6, 2, 1, 3}, {4, 2, 1, 5}, {9, 2, 8, 7}, {4, 1, 2, 9}}));
    }
}
