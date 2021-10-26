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

    public static boolean searchMatrix_2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        if (matrix[0][0] > target || matrix[row - 1][col - 1] < target) {
            return false;
        }

        int i = 0;
        int j = col - 1;

        while (i < row && j >= 0) {
            if (target > matrix[i][j]) {
                i++;
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                return true;
            }
        }

        return false;
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

        return searchMatrixHelper(matrix, 0, 0, col - 1, row - 1, col - 1, row - 1, target);
    }

    private static boolean searchMatrixHelper(int[][] matrix, int x1, int y1, int x2, int y2, int xMax, int yMax, int target) {
        //只需要判断左上角坐标即可
        if (x1 > xMax || y1 > yMax) {
            return false;
        }

        //x 轴代表的是列，y 轴代表的是行
        if (x1 == x2 && y1 == y2) {
            return matrix[y1][x1] == target;
        }
        int m1 = (x1 + x2) >>> 1;
        int m2 = (y1 + y2) >>> 1;
        if (matrix[m2][m1] == target) {
            return true;
        }
        if (matrix[m2][m1] < target) {
            // 右上矩阵
            return searchMatrixHelper(matrix, m1 + 1, y1, x2, m2, x2, y2, target) ||
                    // 左下矩阵
                    searchMatrixHelper(matrix, x1, m2 + 1, m1, y2, x2, y2, target) ||
                    // 右下矩阵
                    searchMatrixHelper(matrix, m1 + 1, m2 + 1, x2, y2, x2, y2, target);

        } else {
            // 右上矩阵
            return searchMatrixHelper(matrix, m1 + 1, y1, x2, m2, x2, y2, target) ||
                    // 左下矩阵
                    searchMatrixHelper(matrix, x1, m2 + 1, m1, y2, x2, y2, target) ||
                    // 左上矩阵
                    searchMatrixHelper(matrix, x1, y1, m1, m2, x2, y2, target);
        }
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println("true ?= " + searchMatrix(mat, 5));
        System.out.println("true ?= " + searchMatrix_1(mat, 5));
        System.out.println("true ?= " + searchMatrix_2(mat, 5));
        System.out.println("true ?= " + searchMatrix_bs(mat, 5));
        System.out.println("false ?= " + searchMatrix_bs(mat, 20));
        System.out.println("true ?= " + searchMatrix_bs(new int[][]{{-1, 3}}, 3));
        System.out.println("true ?= " + searchMatrix_bs(new int[][]{{1, 4}, {2, 5}}, 2));
    }
}
