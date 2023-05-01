package com.longluo.contest.biweekly_contest_103;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/contest/biweekly-contest-103
 */
public class Problem3 {

    public static int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    ans = Math.max(ans, bfs(grid, visited, i, j));
                }
            }
        }

        return ans;
    }

    private static int bfs(int[][] grid, boolean[][] visited, int x, int y) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int curX = cur[0];
            int curY = cur[1];

            ans += grid[curX][curY];

            for (int[] dir : dirs) {
                int nextX = curX + dir[0];
                int nextY = curY + dir[1];

                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || grid[nextX][nextY] == 0 || visited[nextX][nextY]) {
                    continue;
                }

                visited[nextX][nextY] = true;
                queue.offer(new int[]{nextX, nextY});
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("7 ?= " + findMaxFish(new int[][]{{0, 2, 1, 0}, {4, 0, 0, 3}, {1, 0, 0, 4}, {0, 3, 2, 0}}));
    }
}
