package com.longluo.leetcode.array;

/**
 * 240. 搜索二维矩阵 II
 * <p>
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30]], target = 5
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30]], target = 20
 * 输出：false
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -10^9 <= matrix[i][j] <= 10^9
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -10^9 <= target <= 10^9
 * <p>
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class Problem240_searchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        if (matrix[0][0] > target || matrix[row - 1][col - 1] < target) {
            return false;
        }

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] > target) {
                break;
            }

            if (matrix[i][col - 1] < target) {
                continue;
            }

            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean searchMatrix_1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        if (matrix[0][0] > target || matrix[row - 1][col - 1] < target) {
            return false;
        }

        boolean flag = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] > target) {
                break;
            }

            if (matrix[i][col - 1] < target) {
                continue;
            }

            if (binarySearch(matrix[i], target)) {
                flag = true;
                return flag;
            }
        }

        return flag;
    }

    public static boolean searchMatrix_bs(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        if (matrix[0][0] > target || matrix[row - 1][col - 1] < target) {
            return false;
        }

        int low = 0;
        int high = row - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] < target && matrix[mid][col - 1] < target) {
                low = mid + 1;
            } else if (matrix[mid][0] > target) {
                high = mid - 1;
            } else if (matrix[mid][0] < target) {
                high = mid;
            }
        }

        boolean flag = false;
        for (int i = low; i <= high; i++) {
            if (binarySearch(matrix[i], target)) {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println("true ?= " + searchMatrix(mat, 5));
        System.out.println("true ?= " + searchMatrix_1(mat, 5));
        System.out.println("true ?= " + searchMatrix_bs(mat, 5));
    }
}
