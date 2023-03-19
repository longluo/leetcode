package com.longluo.contest.weekly_contest_337;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/contest/weekly-contest-337
 */

/**
 * https://leetcode.cn/problems/rearrange-array-to-maximize-prefix-score/
 */
public class Problem2 {

    public static boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }

        int n = grid.length;

        boolean[][] visited = new boolean[n][n];

        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int no = grid[i][j];
                map.put(no, new int[]{i, j});
            }
        }

        int curX = 0;
        int curY = 0;

        visited[0][0] = true;

        for (int i = 1; i < n * n; i++) {
            int[] pos = map.get(i);

            int x = pos[0];
            int y = pos[1];

            if (visited[x][y]) {
                return false;
            }

            if ((curX >= 2 && curY >= 1 && x == curX - 2 && y == curY - 1)
                    || (curX >= 2 && curY < n - 1 && x == curX - 2 && y == curY + 1)
                    || (curX < n - 2 && curY >= 1 && x == curX + 2 && y == curY - 1)
                    || (curX < n - 2 && curY < n - 1 && x == curX + 2 && y == curY + 1)
                    || (curX < n - 1 && curY < n - 2 && x == curX + 1 && y == curY + 2)
                    || (curX < n - 1 && curY >= 2 && x == curX + 1 && y == curY - 2)
                    || (curX >= 1 && curY < n - 2 && x == curX - 1 && y == curY + 2)
                    || (curX >= 1 && curY >= 2 && x == curX - 1 && y == curY - 2)
            ) {
                visited[x][y] = true;
                curX = x;
                curY = y;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + checkValidGrid(new int[][]{{0, 3, 6}, {5, 8, 1}, {2, 7, 4}}));
        System.out.println("true ?= " + checkValidGrid(new int[][]{{0, 11, 16, 5, 20}, {17, 4, 19, 10, 15}, {12, 1, 8, 21, 6}, {3, 18, 23, 14, 9}, {24, 13, 2, 7, 22}}));
    }
}
