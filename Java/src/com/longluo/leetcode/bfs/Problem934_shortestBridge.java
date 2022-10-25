package com.longluo.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 934. 最短的桥
 * <p>
 * 给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。
 * 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。
 * 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。
 * 返回必须翻转的 0 的最小数目。
 * <p>
 * 示例 1：
 * 输入：grid = [[0,1],[1,0]]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * 输出：1
 * <p>
 * 提示：
 * n == grid.length == grid[i].length
 * 2 <= n <= 100
 * grid[i][j] 为 0 或 1
 * grid 中恰有两个岛
 * <p>
 * https://leetcode.cn/problems/shortest-bridge/
 */
public class Problem934_shortestBridge {

    // BFS time: O(m^2n^2) space: O(mn)
    public static int shortestBridge(int[][] grid) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int n = grid.length;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n * n; i++) {
            int r = i / n;
            int c = i % n;
            if (grid[r][c] == 1) {
                visited[r][c] = true;
                bfs(grid, queue, visited, r, c, dirs);
                break;
            }
        }

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for (int[] dir : dirs) {
                    int nextX = cur[0] + dir[0];
                    int nextY = cur[1] + dir[1];

                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || visited[nextX][nextY]) {
                        continue;
                    }

                    if (grid[nextX][nextY] == 1) {
                        return steps;
                    }

                    if (grid[nextX][nextY] == 0) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }

            steps++;
        }

        return steps;
    }

    private static void bfs(int[][] grid, Queue<int[]> res, boolean[][] marked, int x, int y, int[][] dirs) {
        int n = grid.length;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            marked[cur[0]][cur[1]] = true;
            res.offer(new int[]{cur[0], cur[1]});

            for (int[] dir : dirs) {
                int nextX = cur[0] + dir[0];
                int nextY = cur[1] + dir[1];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n
                        && grid[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + shortestBridge(new int[][]{{0, 1}, {1, 0}}));
        System.out.println("2 ?= " + shortestBridge(new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 1}}));
    }
}
