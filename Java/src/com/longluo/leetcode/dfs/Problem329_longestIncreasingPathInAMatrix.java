package com.longluo.leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 329. 矩阵中的最长递增路径
 * <p>
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 * <p>
 * 示例 1：
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 * <p>
 * 示例 2：
 * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * 输出：4
 * 解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * <p>
 * 示例 3：
 * 输入：matrix = [[1]]
 * 输出：1
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 2^31 - 1
 * <p>
 * https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/
 */
public class Problem329_longestIncreasingPathInAMatrix {

    // BFS time: O(m^2n^2) space: O(mn)
    // TLE
    public static int longestIncreasingPath_bfs(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 1 && col == 1) {
            return 1;
        }

        int max = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, bfs(matrix, i, j));
            }
        }

        return max;
    }

    public static int bfs(int[][] matrix, int x, int y) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int ans = 0;
        int row = matrix.length;
        int col = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;

            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();

                for (int[] dir : dirs) {
                    int nextX = curPos[0] + dir[0];
                    int nextY = curPos[1] + dir[1];

                    if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                        continue;
                    }

                    if (matrix[nextX][nextY] <= matrix[curPos[0]][curPos[1]]) {
                        continue;
                    }

                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        return ans;
    }

    // Memory + DFS time: O(mn) space: O(mn)
    public static int longestIncreasingPath_memo(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 1 && col == 1) {
            return 1;
        }

        int max = 0;
        int[][] memo = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (memo[i][j] == 0) {
                    max = Math.max(max, dfs(matrix, memo, i, j));
                }
            }
        }

        return max;
    }

    public static int dfs(int[][] matrix, int[][] memo, int x, int y) {
        if (memo[x][y] > 0) {
            return memo[x][y];
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int ans = 1;

        int row = matrix.length;
        int col = matrix[0].length;

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                continue;
            }

            if (matrix[nextX][nextY] <= matrix[x][y]) {
                continue;
            }

            ans = Math.max(ans, dfs(matrix, memo, nextX, nextY) + 1);
        }

        memo[x][y] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + longestIncreasingPath_bfs(new int[][]{{1}}));
        System.out.println("4 ?= " + longestIncreasingPath_bfs(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
        System.out.println("4 ?= " + longestIncreasingPath_bfs(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}));
        System.out.println("6 ?= " + longestIncreasingPath_bfs(new int[][]{{7, 8, 9}, {9, 7, 6}, {7, 2, 3}}));

        System.out.println("4 ?= " + longestIncreasingPath_memo(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
        System.out.println("6 ?= " + longestIncreasingPath_memo(new int[][]{{7, 8, 9}, {9, 7, 6}, {7, 2, 3}}));
    }
}

/*
7 8 9
9 7 6
7 2 3
*/
