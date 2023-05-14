package com.longluo.contest.weekly_contest_345;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/contest/weekly-contest-345
 */
public class Problem3 {

    public static int maxMoves(int[][] grid) {
        int m = grid.length;

        int ans = 0;

        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, bfs(grid, i, 0));
        }

        return ans;
    }

    private static int bfs(int[][] grid, int x, int y) {
        int[][] dirs = {{-1, 1}, {0, 1}, {1, 1}};

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] marked = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});

        marked[x][y] = true;

        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for (int[] dir : dirs) {
                    int nextX = cur[0] + dir[0];
                    int nextY = cur[1] + dir[1];

                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                        continue;
                    }

                    if (marked[nextX][nextY] || grid[nextX][nextY] <= grid[cur[0]][cur[1]]) {
                        continue;
                    }

                    marked[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY, cur[2] + 1});
                    ans = Math.max(ans, cur[2] + 1);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + maxMoves(new int[][]{{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}}));
    }
}