package com.longluo.leetcode.array;

/**
 * 766. 托普利茨矩阵
 * <p>
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出：true
 * 解释：
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True 。
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2],[2,2]]
 * 输出：false
 * 解释：
 * 对角线 "[1, 2]" 上的元素不同。
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 20
 * 0 <= matrix[i][j] <= 99
 * <p>
 * 进阶：
 * 如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？
 * 如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？
 * <p>
 * https://leetcode.cn/problems/toeplitz-matrix/
 */
public class Problem766_isToeplitzMatrix {

    // BF time: O(mn) space: O(1)
    public static boolean isToeplitzMatrix_bf(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n && j < m - i; j++) {
                if (matrix[i][0] != matrix[i + j][j]) {
                    return false;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m && i < n - j; i++) {
                if (matrix[0][j] != matrix[i][i + j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isToeplitzMatrix_bf(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
        System.out.println("true ?= " + isToeplitzMatrix_bf(new int[][]{{65, 98, 57}}));

        System.out.println("true ?= " + isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
        System.out.println("true ?= " + isToeplitzMatrix(new int[][]{{1}, {2}, {3}}));
        System.out.println("true ?= " + isToeplitzMatrix(new int[][]{{1, 2, 3, 4}}));
        System.out.println("false ?= " + isToeplitzMatrix(new int[][]{{1, 2}, {2, 2}}));
        System.out.println("false ?= " + isToeplitzMatrix(new int[][]{{11, 74, 0, 93}, {40, 11, 74, 7}}));
    }
}
