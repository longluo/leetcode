package com.longluo.contest.weekly_contest_323;

import com.longluo.datastructure.TreeUtils;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-323
 */

/**
 * https://leetcode.cn/problems/maximum-number-of-points-from-grid-queries/
 */
public class Problem4 {

    public static int[] maxPoints(int[][] grid, int[] queries) {
        int k = queries.length;

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            if (grid[0][0] >= queries[i]) {
                continue;
            }

            ans[i] = bfs(grid, queries[i]);
        }

        return ans;
    }

    private static int bfs(int[][] grid, int target) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        int max = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();

                int x = curPos[0];
                int y = curPos[1];

                for (int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];

                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                        continue;
                    }

                    if (grid[nextX][nextY] >= target) {
                        continue;
                    }

                    if (visited[nextX][nextY]) {
                        continue;
                    }

                    max++;
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("[5, 8, 1] ?= " + Arrays.toString(maxPoints(new int[][]{{1, 2, 3}, {2, 5, 7}, {3, 5, 1}}, new int[]{5, 6, 2})));
    }
}


