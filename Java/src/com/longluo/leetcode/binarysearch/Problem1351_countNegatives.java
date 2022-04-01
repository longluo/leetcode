package com.longluo.leetcode.binarysearch;

/**
 * 1351. 统计有序矩阵中的负数
 * <p>
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 请你统计并返回 grid 中 负数 的数目。
 * <p>
 * 示例 1：
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 * <p>
 * 示例 2：
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？
 * <p>
 * https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix/
 */
public class Problem1351_countNegatives {

    // BF time: O(m*n) space: O(1)
    public static int countNegatives_bf(int[][] grid) {
        int ans = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] < 0) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // BF Opt time: O(m*n) space: O(1)
    public static int countNegatives_bf_opt(int[][] grid) {
        int ans = 0;
        int row = grid.length;
        int col = grid[0].length;

        if (grid[0][0] < 0) {
            return row * col;
        } else if (grid[row - 1][col - 1] >= 0) {
            return 0;
        }

        for (int i = 0; i < row; i++) {
            if (grid[i][col - 1] >= 0) {
                continue;
            }

            if (grid[i][0] < 0) {
                ans += col;
                continue;
            }

            for (int j = col - 1; j >= 0; j--) {
                if (grid[i][j] < 0) {
                    ans++;
                } else {
                    break;
                }
            }
        }

        return ans;
    }

    // Coord time: O(m + n) space: O(1)
    public static int countNegatives_coord(int[][] grid) {
        int ans = 0;
        int row = grid.length;
        int col = grid[0].length;

        if (grid[0][0] < 0) {
            return row * col;
        } else if (grid[row - 1][col - 1] >= 0) {
            return 0;
        }

        int i = row - 1;
        int j = 0;
        while (i >= 0 && j < col) {
            if (grid[i][j] >= 0) {
                j++;
            } else if (grid[i][j] < 0) {
                i--;
                ans += col - j;
            }
        }

        return ans;
    }



    public static void main(String[] args) {

    }
}
