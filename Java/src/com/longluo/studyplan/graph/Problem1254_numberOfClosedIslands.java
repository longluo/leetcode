package com.longluo.studyplan.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1254. 统计封闭岛屿的数目
 * <p>
 * 二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，
 * 封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
 * <p>
 * 请返回 封闭岛屿 的数目。
 * <p>
 * 示例 1：
 * 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * 输出：2
 * 解释：
 * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
 * <p>
 * 示例 2：
 * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：grid = [[1,1,1,1,1,1,1],
 * [1,0,0,0,0,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,1,0,1,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * 输出：2
 * <p>
 * 提示：
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 * <p>
 * https://leetcode-cn.com/problems/number-of-closed-islands/
 */
public class Problem1254_numberOfClosedIslands {

    // BFS time: O(m*n) space: O(m*n)
    public static int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int ans = 0;

        for (int i = 0; i < row; i++) {
            if (!visited[i][0] && grid[i][0] == 0) {
                bfs_edge(grid, visited, i, 0);
            }

            if (!visited[i][col - 1] && grid[i][col - 1] == 0) {
                bfs_edge(grid, visited, i, col - 1);
            }
        }

        for (int i = 0; i < col; i++) {
            if (!visited[0][i] && grid[0][i] == 0) {
                bfs_edge(grid, visited, 0, i);
            }

            if (!visited[row - 1][i] && grid[row - 1][i] == 0) {
                bfs_edge(grid, visited, row - 1, i);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == 0) {
                    bfs(grid, visited, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void bfs_edge(int[][] grid, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        grid[x][y] = 1;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir : dirs) {
                int nextX = pos[0] + dir[0];
                int nextY = pos[1] + dir[1];
                if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length
                        && grid[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                    queue.offer(new int[]{nextX, nextY});
                    grid[nextX][nextY] = 1;
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    public static void bfs(int[][] grid, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir : dirs) {
                int nextX = pos[0] + dir[0];
                int nextY = pos[1] + dir[1];
                if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length
                        && grid[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + closedIsland(new int[][]{{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}}));
        System.out.println("5 ?= " + closedIsland(new int[][]{{0, 0, 1, 1, 0, 1, 0, 0, 1, 0}, {1, 1, 0, 1, 1, 0, 1, 1, 1, 0}, {1, 0, 1, 1, 1, 0, 0, 1, 1, 0}, {0, 1, 1, 0, 0, 0, 0, 1, 0, 1}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 1, 0, 1, 0, 1}, {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}}));
        System.out.println("1 ?= " + closedIsland(new int[][]{{0, 1, 1, 1, 0}, {1, 0, 1, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {0, 1, 1, 1, 0}}));
    }
}
