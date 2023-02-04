package com.longluo.contest.biweekly_contest_97;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/contest/biweekly-contest-97
 */
public class Problem4 {

    // TLE
    public static boolean isPossibleToCutPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == 0 && j == 0) || (i == rows - 1 && j == cols - 1)) {
                    continue;
                }

                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (!bfs(grid)) {
                        return true;
                    }
                    grid[i][j] = 1;
                }
            }
        }

        return false;
    }

    private static boolean bfs(int[][] grid) {
        int[][] dirs = {{1, 0}, {0, 1}};

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return true;
                }

                for (int[] dir : dirs) {
                    int nextX = cur[0] + dir[0];
                    int nextY = cur[1] + dir[1];

                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                        continue;
                    }

                    if (grid[nextX][nextY] == 1) {
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isPossibleToCutPath(new int[][]{{1, 1, 1}, {1, 0, 0}, {1, 1, 1}}));
        System.out.println("false ?= " + isPossibleToCutPath(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
    }
}
