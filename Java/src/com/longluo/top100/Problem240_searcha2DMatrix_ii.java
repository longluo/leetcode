package com.longluo.top100;

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
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class Problem240_searcha2DMatrix_ii {

    // BF O(m*n) O(1)
    public static boolean searchMatrix_bf(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    // BF O(m*n) O(1)
    public static boolean searchMatrix_bf_opt(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        if (matrix[0][0] > target || matrix[row - 1][col - 1] < target) {
            return false;
        }

        for (int i = 0; i < row; i++) {
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

    // Row Binary Search O(m*logn) O(1)
    public static boolean searchMatrix_bs_row(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        if (matrix[0][0] > target || matrix[row - 1][col - 1] < target) {
            return false;
        }

        for (int i = 0; i < row; i++) {
            if (matrix[i][col - 1] < target) {
                continue;
            }

            if (binarySearchRow(matrix[i], target)) {
                return true;
            }
        }

        return false;
    }

    public static boolean binarySearchRow(int[] arr, int target) {
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

    // 2D Coord Axis From Right O(m+n) O(1)
    public static boolean searchMatrix_coord_right(int[][] matrix, int target) {
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

    // 2D Coord Axis From Left O(m+n) O(1) Faster then From Right
    public static boolean searchMatrix_coord_left(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        if (matrix[0][0] > target || matrix[row - 1][col - 1] < target) {
            return false;
        }

        int i = row - 1;
        int j = 0;
        while (i >= 0 && j < col) {
            if (target > matrix[i][j]) {
                j++;
            } else if (target < matrix[i][j]) {
                i--;
            } else {
                return true;
            }
        }

        return false;
    }

    // Global Binary Search O() O(1)
    // TODO: 2022/3/31
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

    // Diagonal, Row, Col Binary Search O(min(M,N)(logM+logN)) O(1)
    public static boolean searchMatrix_bs_3d(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        if (matrix[0][0] > target || matrix[row - 1][col - 1] < target) {
            return false;
        }

        int index = diagonalBinarySearch(matrix, target);
        if (matrix[index][index] == target) {
            return true;
        }

        for (int i = 0; i <= index; i++) {
            boolean rowResult = rowBinarySearch(matrix, i, col - 1, target);
            boolean colResult = colBinarySearch(matrix, i, row - 1, target);
            if (rowResult || colResult) {
                return true;
            }
        }

        return false;
    }

    public static int diagonalBinarySearch(int[][] matrix, int target) {
        int minVal = Math.min(matrix.length, matrix[0].length);
        int left = 0;
        int right = minVal;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return Math.min(left, minVal - 1);
    }

    public static boolean rowBinarySearch(int[][] matrix, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[start][mid] == target) {
                return true;
            } else if (matrix[start][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static boolean colBinarySearch(int[][] matrix, int start, int end, int target) {
        int left = start + 1;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][start] == target) {
                return true;
            } else if (matrix[mid][start] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println("true ?= " + searchMatrix_bf(mat, 5));
        System.out.println("true ?= " + searchMatrix_bs_row(mat, 5));
        System.out.println("true ?= " + searchMatrix_coord_left(mat, 5));
        System.out.println("true ?= " + searchMatrix_bs(mat, 5));
        System.out.println("false ?= " + searchMatrix_bs(mat, 20));
        System.out.println("true ?= " + searchMatrix_bs(new int[][]{{-1, 3}}, 3));
        System.out.println("true ?= " + searchMatrix_bs(new int[][]{{1, 4}, {2, 5}}, 2));
        System.out.println("true ?= " + searchMatrix_bs_3d(new int[][]{{1, 4}, {2, 5}}, 2));
        System.out.println("true ?= " + searchMatrix_bs_3d(new int[][]{{-5}}, -5));
        System.out.println("false ?= " + searchMatrix_bs_3d(new int[][]{{-1, 3}}, 1));
        System.out.println("true ?= " + searchMatrix_bs_3d(new int[][]{{-1, 3}}, 3));
    }
}
