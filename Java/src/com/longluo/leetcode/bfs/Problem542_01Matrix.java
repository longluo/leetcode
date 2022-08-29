package com.longluo.leetcode.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 Matrix
 * <p>
 * Medium
 * <p>
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 * <p>
 * Example 1:
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * <p>
 * Example 2:
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 * <p>
 * Constraints:
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 10^4
 * 1 <= m * n <= 10^4
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 * <p>
 * https://leetcode.com/problems/01-matrix/
 */
public class Problem542_01Matrix {

    // BFS time: O(m^2n^2) space: O(mn)
    // TLE
    public static int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE / 2);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = bfs(mat, i, j);
                }
            }
        }

        return res;
    }

    private static int bfs(int[][] grid, int row, int col) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int rows = grid.length;
        int cols = grid[0].length;
        int level = 0;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();
                int x = curPos[0];
                int y = curPos[1];

                if (grid[x][y] == 0) {
                    return level;
                }

                for (int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];

                    if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }

            level++;
        }

        return level;
    }

    public static void main(String[] args) {
        System.out.println("[[0,0,0],[0,1,0],[1,2,1]] ?= " + Arrays.deepToString(updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})));
    }
}
