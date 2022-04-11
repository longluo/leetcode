package com.longluo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/shift-2d-grid/
 */
public class Problem1260_shift2DGrid {

    // BF time: O(m * n) space: O(m * n)
    public static List<List<Integer>> shiftGrid_bf(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int sum = row * col;
        k = k % sum;
        int[][] array = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int idx = (sum - k + i * col + j) % sum;
                array[i][j] = grid[idx / col][idx % col];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> column = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                column.add(array[i][j]);
            }

            ans.add(column);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(" " + shiftGrid_bf(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1));
        System.out.println(" " + shiftGrid_bf(new int[][]{{1}, {2}, {3}, {4}, {7}, {6}, {5}}, 23));
    }
}
