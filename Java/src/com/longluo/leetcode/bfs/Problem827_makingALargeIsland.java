package com.longluo.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 827. 最大人工岛
 * <p>
 * 给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
 * <p>
 * 返回执行此操作后，grid 中最大的岛屿面积是多少？
 * <p>
 * 岛屿 由一组上、下、左、右四个方向相连的 1 形成。
 * <p>
 * 示例 1:
 * 输入: grid = [[1, 0], [0, 1]]
 * 输出: 3
 * 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 * <p>
 * 示例 2:
 * 输入: grid = [[1, 1], [1, 0]]
 * 输出: 4
 * 解释: 将一格0变成1，岛屿的面积扩大为 4。
 * <p>
 * 示例 3:
 * 输入: grid = [[1, 1], [1, 1]]
 * 输出: 4
 * 解释: 没有0可以让我们变成1，面积依然为 4。
 * <p>
 * 提示：
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 500
 * grid[i][j] 为 0 或 1
 * <p>
 * https://leetcode.cn/problems/making-a-large-island/
 */
public class Problem827_makingALargeIsland {

    // BFS time: O(n^4) space: O(n^2)
    // TLE
    public static int largestIsland_bfs(int[][] grid) {
        int n = grid.length;

        int ans = 1;

        boolean contain0 = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    contain0 = true;
                    ans = Math.max(ans, bfs(grid, i, j));
                }
            }
        }

        return contain0 ? ans : n * n;
    }

    private static int bfs(int[][] grid, int x, int y) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int n = grid.length;

        boolean[][] visited = new boolean[n][n];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        int ans = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : dirs) {
                int nextX = cur[0] + dir[0];
                int nextY = cur[1] + dir[1];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || visited[nextX][nextY]) {
                    continue;
                }

                if (grid[nextX][nextY] == 1) {
                    ans++;
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + largestIsland_bfs(new int[][]{{1, 0}, {0, 1}}));
        System.out.println("4 ?= " + largestIsland_bfs(new int[][]{{1, 1}, {1, 0}}));
    }
}
