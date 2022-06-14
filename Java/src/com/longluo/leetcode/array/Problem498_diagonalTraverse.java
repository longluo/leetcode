package com.longluo.leetcode.array;

import java.util.Arrays;

/**
 * 498. 对角线遍历
 * <p>
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * <p>
 * 示例 1：
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * <p>
 * 示例 2：
 * 输入：mat = [[1,2],[3,4]]
 * 输出：[1,2,3,4]
 * <p>
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 10^4
 * 1 <= m * n <= 10^4
 * -10^5 <= mat[i][j] <= 10^5
 * <p>
 * https://leetcode.cn/problems/diagonal-traverse/
 */
public class Problem498_diagonalTraverse {

    // Simulate time: O(n^2) space: O(1)
    // TODO: 2022/6/14  
    public static int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[] ans = new int[row * col];
        if (row <= 1) {
            System.arraycopy(mat[0], 0, ans, 0, row * col);
            return ans;
        } else if (col == 1) {
            for (int i = 0; i < row; i++) {
                ans[i] = mat[i][0];
            }

            return ans;
        }

        int idx = 0;
        int cycle = row + col - 2;
        for (int i = 0; i <= cycle; i++) {
            int max = Math.min(row - 1, i);
            if (i % 2 == 0) {
                for (int j = max; j >= i - max; j--) {
                    ans[idx++] = mat[j][i - j];
                }
            } else {
                for (int j = i - max; j <= max; j++) {
                    ans[idx++] = mat[j][i - j];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[2,3] ?= " + Arrays.toString(findDiagonalOrder(new int[][]{{2, 3}})));
        System.out.println("[2,3] ?= " + Arrays.toString(findDiagonalOrder(new int[][]{{2}, {3}})));
        System.out.println("[1,2,4,7,5,3,6,8,9] ?= " + Arrays.toString(findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }
}
