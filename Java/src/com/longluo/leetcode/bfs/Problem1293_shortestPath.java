package com.longluo.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1293. 网格中的最短路径
 * <p>
 * 给你一个 m * n 的网格，其中每个单元格不是 0（空）就是 1（障碍物）。每一步，您都可以在空白单元格中上、下、左、右移动。
 * <p>
 * 如果您 最多 可以消除 k 个障碍物，请找出从左上角 (0, 0) 到右下角 (m-1, n-1) 的最短路径，并返回通过该路径所需的步数。
 * <p>
 * 如果找不到这样的路径，则返回 -1 。
 * <p>
 * 示例 1：
 * 输入： grid = [[0,0,0}, {1,1,0}, {0,0,0}, {0,1,1}, {0,0,0]], k = 1
 * 输出：6
 * 解释：
 * 不消除任何障碍的最短路径是 10。
 * 消除位置 (3,2) 处的障碍后，最短路径是 6 。该路径是 (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 * <p>
 * 示例 2：
 * 输入：grid = [[0,1,1}, {1,1,1}, {1,0,0]], k = 1
 * 输出：-1
 * 解释：我们至少需要消除两个障碍才能找到这样的路径。
 * <p>
 * 提示：
 * grid.length == m
 * grid[0].length == n
 * 1 <= m, n <= 40
 * 1 <= k <= m*n
 * grid[i][j] 是 0 或 1
 * grid[0][0] == grid[m-1][n-1] == 0
 * <p>
 * https://leetcode.cn/problems/shortest-path-in-a-grid-with-obstacles-elimination/
 */
public class Problem1293_shortestPath {

    // BFS time: O(mnk) space: O(mn)
    public static int shortestPath(int[][] grid, int k) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, k});

        boolean[][][] visited = new boolean[m][n][k + 1];
        visited[0][0][k] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                int rest = cur[2];

                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return steps;
                }

                for (int[] dir : dirs) {
                    int nextX = cur[0] + dir[0];
                    int nextY = cur[1] + dir[1];

                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                        continue;
                    }

                    if (grid[nextX][nextY] == 0 && !visited[nextX][nextY][rest]) {
                        visited[nextX][nextY][rest] = true;
                        queue.offer(new int[]{nextX, nextY, rest});
                    } else if (grid[nextX][nextY] == 1 && rest >= 1 && !visited[nextX][nextY][rest - 1]) {
                        visited[nextX][nextY][rest - 1] = true;
                        queue.offer(new int[]{nextX, nextY, rest - 1});
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + shortestPath(new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}}, 1));
        System.out.println("-1 ?= " + shortestPath(new int[][]{{0, 1, 1}, {1, 1, 1}, {1, 0, 0}}, 1));
    }
}
