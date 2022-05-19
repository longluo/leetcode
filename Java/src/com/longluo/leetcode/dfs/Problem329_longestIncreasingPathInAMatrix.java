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

    // DFS time: O(m^2n^2) space: O(mn)
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

        boolean[][] visited = new boolean[row][col];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;

            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();

                for (int[] dir : dirs) {
                    int nextX = curPos[0] + dir[0];
                    int nextY = curPos[1] + dir[1];

                    if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || visited[nextX][nextY]) {
                        continue;
                    }

                    if (matrix[nextX][nextY] <= matrix[curPos[0]][curPos[1]]) {
                        continue;
                    }

                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + longestIncreasingPath_bfs(new int[][]{{1}}));
        System.out.println("4 ?= " + longestIncreasingPath_bfs(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
        System.out.println("4 ?= " + longestIncreasingPath_bfs(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}));
    }
}
