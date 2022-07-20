package com.longluo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 * <p>
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * <p>
 * 每次「迁移」操作将会引发下述活动：
 * <p>
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 * <p>
 * 示例 1：
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 * <p>
 * 示例 2：
 * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * <p>
 * 示例 3：
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * 输出：[[1,2,3],[4,5,6],[7,8,9]]
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 50
 * 1 <= n <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 * <p>
 * https://leetcode.cn/problems/array-nesting/
 */
public class Problem1260_shift2DGrid {

    // BF time: O(mn) space: O(mn)
    public static List<List<Integer>> shiftGrid_bf(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;

        int sum = row * col;
        k = k % sum;

        int[][] mat = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int idx = (sum - k + i * col + j) % sum;
                mat[i][j] = grid[idx / col][idx % col];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> column = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                column.add(mat[i][j]);
            }

            ans.add(column);
        }

        return ans;
    }

    // Change to One Way time: O(mn) space: O(1)
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                rowList.add(grid[i][j]);
            }

            res.add(rowList);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int index = i * col + j;
                int nextIdx = (index + k) % (row * col);
                res.get(nextIdx / col).set(nextIdx % col, grid[i][j]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(" " + shiftGrid_bf(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1));
        System.out.println(" " + shiftGrid_bf(new int[][]{{1}, {2}, {3}, {4}, {7}, {6}, {5}}, 23));

        System.out.println(" " + shiftGrid(new int[][]{{1}, {2}, {3}, {4}, {7}, {6}, {5}}, 23));
    }
}
