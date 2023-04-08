package com.longluo.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1020. 飞地的数量
 * <p>
 * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 * <p>
 * 示例 1：
 * 输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 * <p>
 * 示例 2：
 * 输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * 输出：0
 * 解释：所有 1 都在边界上或可以到达边界。
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid[i][j] 的值为 0 或 1
 * <p>
 * https://leetcode.cn/problems/number-of-enclaves/
 */
public class Problem1020_numberOfEnclaves {

    //
    public static int numEnclaves(int[][] grid) {
        if (grid == null || grid.length <= 2 || grid[0].length <= 2) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        int[][] step = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            if (grid[i][0] == 1) {
                queue.offer(new int[]{i, 0});
                grid[i][0] = 2;
                visited[i][0] = true;
            }

            if (grid[i][col - 1] == 1) {
                queue.offer(new int[]{i, col - 1});
                grid[i][col - 1] = 2;
                visited[i][col - 1] = true;
            }
        }

        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 1) {
                queue.offer(new int[]{0, i});
                grid[0][i] = 2;
                visited[0][i] = true;
            }

            if (grid[row - 1][i] == 1) {
                queue.offer(new int[]{row - 1, i});
                grid[row - 1][i] = 2;
                visited[row - 1][i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = pos[0] + step[i][0];
                int nextY = pos[1] + step[i][1];

                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                    continue;
                }

                if (!visited[nextX][nextY]) {
                    if (grid[nextX][nextY] == 1) {
                        queue.offer(new int[]{nextX, nextY});
                        grid[nextX][nextY] = 2;
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }

    //
    public static int numEnclaves_uf(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        UnionFind uf = new UnionFind(grid);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {

                    int index = i * n + j;
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        uf.union(index, index + 1);
                    }

                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        uf.union(index, index + n);
                    }
                }
            }
        }

        int enclaves = 0;

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !uf.isOnEdge(i * n + j)) {
                    enclaves++;
                }
            }
        }

        return enclaves;
    }

    static class UnionFind {
        private int[] parent;
        private int[] rank;

        private boolean[] onEdge;

        public UnionFind(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            parent = new int[m * n];
            rank = new int[m * n];

            onEdge = new boolean[m * n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        int index = i * n + j;
                        parent[index] = index;
                        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                            onEdge[index] = true;
                        }
                    }
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }

            return parent[i];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                    onEdge[rootX] |= onEdge[rootY];
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                    onEdge[rootY] |= onEdge[rootX];
                } else {
                    parent[rootY] = rootX;
                    onEdge[rootX] |= onEdge[rootY];
                    rank[rootX]++;
                }
            }
        }

        public boolean isOnEdge(int i) {
            return onEdge[find(i)];
        }
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + numEnclaves(new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}));
        System.out.println("0 ?= " + numEnclaves(new int[][]{{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}}));
    }
}
