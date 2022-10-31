package com.longluo.contest.biweekly_contest_77;

/**
 * https://leetcode.cn/problems/count-unguarded-cells-in-the-grid/
 */
public class Problem3 {

    // TLE
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int guardCnt = guards.length;
        int wallCnt = walls.length;

        if (guardCnt + wallCnt == m * n) {
            return 0;
        }

        int[][] grid = new int[m][n];

        for (int[] pos : walls) {
            grid[pos[0]][pos[1]] = 1;
        }

        for (int[] pos : guards) {
            for (int[] dir : dirs) {
                int x = pos[0];
                int y = pos[1];

                while (x >= 0 && x < m && y >= 0 && y < n) {
                    if (grid[x][y] == 1) {
                        break;
                    }

                    grid[x][y] = 2;

                    x += dir[0];
                    y += dir[1];
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("7 ?= " + countUnguarded(4, 6, new int[][]{{0, 0}, {1, 1}, {2, 3}}, new int[][]{{0, 1}, {2, 2}, {1, 4}}));
        System.out.println("4 ?= " + countUnguarded(3, 3, new int[][]{{1, 1}}, new int[][]{{0, 1}, {1, 0}, {2, 1}, {1, 2}}));
    }
}
