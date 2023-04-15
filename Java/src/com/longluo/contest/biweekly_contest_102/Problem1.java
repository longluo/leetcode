package com.longluo.contest.biweekly_contest_102;

/**
 * https://leetcode.cn/contest/biweekly-contest-102
 */
public class Problem1 {

    public static int[] findColumnWidth(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[] ans = new int[c];

        for (int i = 0; i < c; i++) {
            int max = 0;
            for (int j = 0; j < r; j++) {
                max = Math.max(max, String.valueOf(grid[j][i]).length());
            }

            ans[i] = max;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(String.valueOf(-15).length());
        System.out.println(String.valueOf(10).length());
    }
}
