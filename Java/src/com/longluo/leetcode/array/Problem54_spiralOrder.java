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

    public static void main(String[] args) {
        System.out.println("[1,2,3,6,9,8,7,4,5] ?= " + spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println("[1,2,3,4,8,12,11,10,9,5,6,7] ?= " + spiralOrder(new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
