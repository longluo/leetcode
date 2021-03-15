package com.longluo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/*
54. 螺旋矩阵
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]

示例 2:
输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]

[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12],
  [13,14,15,16],
]

1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

 */
public class Problem54_spiralOrder {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null) {
            return ans;
        }

        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int total = rowNum * colNum;
        int count = 0;

        for (int i = 0; i <= rowNum / 2; i++) {

            for (int j = i; j < colNum - i; j++) {
                ans.add(matrix[i][j]);
                count++;
                if (count >= total) {
                    return ans;
                }
            }

            for (int k = i + 1; k < rowNum - i; k++) {
                ans.add(matrix[k][colNum - i - 1]);
                count++;
                if (count >= total) {
                    return ans;
                }
            }

            for (int m = colNum - i - 2; m >= i; m--) {
                ans.add(matrix[rowNum - i - 1][m]);
                count++;
                if (count >= total) {
                    return ans;
                }
            }

            for (int n = rowNum - i - 2; n > i; n--) {
                ans.add(matrix[n][i]);
                count++;
                if (count >= total) {
                    return ans;
                }
            }
        }

        return ans;
    }

    public static List<Integer> spiralOrder_2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int rowIdx = 0;
        int colIdx = 0;
        boolean[][] visited = new boolean[row][col];
        int dirIdx = 0;
        for (int i = 0; i < row * col; i++) {
            res.add(matrix[rowIdx][colIdx]);
            visited[rowIdx][colIdx] = true;
            int nextRow = rowIdx + dirs[dirIdx][0];
            int nextCol = colIdx + dirs[dirIdx][1];
            if (nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col || visited[nextRow][nextCol]) {
                dirIdx = (dirIdx + 1) % 4;
            }
            rowIdx = rowIdx + dirs[dirIdx][0];
            colIdx = colIdx + dirs[dirIdx][1];
        }

        return res;
    }

    public static List<Integer> spiralOrder_3(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;
        while (left <= right && top <= bottom) {
            for (int colIdx = left; colIdx <= right; colIdx++) {
                res.add(matrix[top][colIdx]);
            }

            for (int rowIdx = top + 1; rowIdx <= bottom; rowIdx++) {
                res.add(matrix[rowIdx][right]);
            }

            if (left < right && top < bottom) {
                for (int colIdx = right - 1; colIdx >= left; colIdx--) {
                    res.add(matrix[bottom][colIdx]);
                }

                for (int rowIdx = bottom - 1; rowIdx > top; rowIdx--) {
                    res.add(matrix[rowIdx][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(" Method 1: ");
        System.out.println("[1,2,3,6,9,8,7,4,5] ?= " + spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println("[1,2,3,4,8,12,11,10,9,5,6,7] ?= " + spiralOrder(new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8}, {9, 10, 11, 12}}));

        System.out.println(" Method 2: ");
        System.out.println("[1,2,3,6,9,8,7,4,5] ?= " + spiralOrder_2(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println("[1,2,3,4,8,12,11,10,9,5,6,7] ?= " + spiralOrder_2(new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8}, {9, 10, 11, 12}}));

        System.out.println(" Method 3: ");
        System.out.println("[1,2,3,6,9,8,7,4,5] ?= " + spiralOrder_3(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println("[1,2,3,4,8,12,11,10,9,5,6,7] ?= " + spiralOrder_3(new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
