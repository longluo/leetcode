package com.longluo.leetcode.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1091. 二进制矩阵中的最短路径
 * <p>
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 * <p>
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 * <p>
 * 路径途经的所有单元格都的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 * <p>
 * 示例 1：
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
 * 输出：4
 * <p>
 * 示例 3：
 * 输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
 * 输出：-1
 * <p>
 * 提示：
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] 为 0 或 1
 * <p>
 * https://leetcode.cn/problems/shortest-path-in-binary-matrix/
 */
public class Problem1091_shortestPathBinaryMatrix {

    // BFS time: O(n^2) space: O(n^2)
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int ans = 0;

        int row = grid.length;
        int col = grid[0].length;

        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }

        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        boolean[][] visited = new boolean[row][col];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;

            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();

                if (curPos[0] == row - 1 && curPos[1] == col - 1) {
                    return ans;
                }

                for (int[] dir : dirs) {
                    int nextX = curPos[0] + dir[0];
                    int nextY = curPos[1] + dir[1];

                    if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || visited[nextX][nextY] || grid[nextX][nextY] == 1) {
                        continue;
                    }

                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        return -1;
    }

    // BFS Distance time: O(n^2) space: O(n^2)
    public static int shortestPathBinaryMatrix_dist(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        int[][] dist = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return dist[m - 1][n - 1];
                }

                for (int[] dir : dirs) {
                    int nextX = cur[0] + dir[0];
                    int nextY = cur[1] + dir[1];

                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || grid[nextX][nextY] == 1) {
                        continue;
                    }

                    if (dist[nextX][nextY] <= dist[cur[0]][cur[1]] + 1) {
                        continue;
                    }

                    dist[nextX][nextY] = Math.min(dist[cur[0]][cur[1]] + 1, dist[nextX][nextY]);
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        return -1;
    }

    // BFS Opt time: O(n^2) space: O(n^2)
    public static int shortestPathBinaryMatrix_opt(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            steps++;

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                int x = cur[0];
                int y = cur[1];

                if (x == n - 1 && y == n - 1) {
                    return steps;
                }

                for (int j = -1; j <= 1; j++) {
                    for (int k = -1; k <= 1; k++) {
                        int nextX = x + j;
                        int nextY = y + k;

                        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                            continue;
                        }

                        if (grid[nextX][nextY] == 1 || visited[nextX][nextY]) {
                            continue;
                        }

                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
        System.out.println("-1 ?= " + shortestPathBinaryMatrix(new int[][]{{0, 0, 0, 0, 1}, {1, 0, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}}));

        System.out.println("2 ?= " + shortestPathBinaryMatrix_dist(new int[][]{{0, 1}, {1, 0}}));
        System.out.println("-1 ?= " + shortestPathBinaryMatrix_dist(new int[][]{{0, 0, 0, 0, 1}, {1, 0, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}}));

        System.out.println("2 ?= " + shortestPathBinaryMatrix_opt(new int[][]{{0, 1}, {1, 0}}));
        System.out.println("-1 ?= " + shortestPathBinaryMatrix_opt(new int[][]{{0, 0, 0, 0, 1}, {1, 0, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}}));
    }
}

