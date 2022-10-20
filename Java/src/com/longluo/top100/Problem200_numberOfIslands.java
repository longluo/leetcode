package com.longluo.top100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. 岛屿数量
 * <p>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1：
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 * <p>
 * https://leetcode.com/problems/number-of-islands/
 */
public class Problem200_numberOfIslands {

    // BFS  time: O(m*n) space: O(m*n)
    public static int numIslands_bfs(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, visited, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void bfs(char[][] grid, boolean[][] visited, int x, int y) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir : dirs) {
                int nextX = pos[0] + dir[0];
                int nextY = pos[1] + dir[1];
                if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length
                        && !visited[nextX][nextY] && grid[nextX][nextY] == '1') {
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    // DFS time: O(mn) space: O(mn)
    public static int numIslands_dfs(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    private static void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int m = grid.length;
        int n = grid[0].length;

        visited[x][y] = true;

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == '1' && !visited[nextX][nextY]) {
                dfs(grid, visited, nextX, nextY);
            }
        }
    }

    // Union Find time: O(mn*aplha(mn)) space: O(mn)
    public static int numIslands_uf(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        UnionFind uf = new UnionFind(grid);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }

                if (i > 0 && grid[i - 1][j] == '1') {
                    uf.union(i * n + j, (i - 1) * n + j);
                }

                if (i < m - 1 && grid[i + 1][j] == '1') {
                    uf.union(i * n + j, (i + 1) * n + j);
                }

                if (j > 0 && grid[i][j - 1] == '1') {
                    uf.union(i * n + j, i * n + j - 1);
                }

                if (j < n - 1 && grid[i][j + 1] == '1') {
                    uf.union(i * n + j, i * n + j + 1);
                }
            }
        }

        return uf.getCount();
    }

    static class UnionFind {
        int count = 0;
        int[] parents;
        int[] size;

        UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            parents = new int[m * n];
            size = new int[m * n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parents[i * n + j] = i * n + j;
                        size[i * n + j] = 1;
                        count++;
                    }
                }
            }
        }

        int find(int x) {
            while (x != parents[x]) {
                x = parents[x];
            }

            return parents[x];
        }

        void union(int x, int y) {
            int a = find(x);
            int b = find(y);

            if (a != b) {
                if (size[a] < size[b]) {
                    parents[a] = b;
                    size[b] += size[a];
                } else if (size[a] > size[b]) {
                    parents[b] = a;
                    size[a] += size[b];
                } else {
                    parents[b] = a;
                    size[a] += size[b];
                }

                count--;
            }
        }

        int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + numIslands_bfs(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));

        System.out.println("1 ?= " + numIslands_dfs(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));

        System.out.println("1 ?= " + numIslands_uf(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
        System.out.println("3 ?= " + numIslands_uf(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
    }
}
