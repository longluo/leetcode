package com.longluo.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. Rotting Oranges
 * <p>
 * Medium
 * <p>
 * You are given an m x n grid where each cell can have one of three values:
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * <p>
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible,
 * return -1.
 * <p>
 * Example 1:
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * <p>
 * Example 2:
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 * <p>
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 * <p>
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 * <p>
 * https://leetcode.com/problems/rotting-oranges/
 */
public class Problem994_rottingOranges {

    // BFS time: O(mn) space: O(mn)
    public static int orangesRotting_bfs(int[][] grid) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int nr = grid.length;
        int nc = grid[0].length;

        boolean[][] visited = new boolean[nr][nc];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int time = 0;
        while (!queue.isEmpty()) {
            time++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int nextX = cur[0] + dir[0];
                    int nextY = cur[1] + dir[1];
                    if (nextX >= 0 && nextX < nr && nextY >= 0 && nextY < nc && !visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        grid[nextX][nextY] = 2;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time > 0 ? time - 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + orangesRotting_bfs(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }
}
