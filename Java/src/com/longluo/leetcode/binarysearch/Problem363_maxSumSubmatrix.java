package com.longluo.leetcode.binarysearch;

/**
 * 363. 矩形区域不超过 K 的最大数值和
 * <p>
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * <p>
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出：2
 * 解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * <p>
 * 示例 2：
 * 输入：matrix = [[2,2,-1]], k = 3
 * 输出：3
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -10^5 <= k <= 10^5
 * <p>
 * 进阶：如果行数远大于列数，该如何设计解决方案？
 * <p>
 * https://leetcode.cn/problems/max-sum-of-rectangle-no-larger-than-k/
 */
public class Problem363_maxSumSubmatrix {

    // TODO: 2022/9/9
    // BF + DP time: O(n^3) space: O(1)
    public static int maxSumSubmatrix_bf(int[][] matrix, int k) {
        int max = Integer.MIN_VALUE;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = matrix[i][j];
                if (sum > k) {
                    continue;
                }


            }
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
