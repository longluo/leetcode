package com.longluo.offer;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 示例:
 * 现有矩阵 matrix 如下：
 * {
 * {1,   4,  7, 11, 15},
 * {2,   5,  8, 12, 19},
 * {3,   6,  9, 16, 22},
 * {10, 13, 14, 17, 24},
 * {18, 21, 23, 26, 30}
 * }
 * <p>
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * <p>
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 */
public class Offer04_findNumberIn2DArray {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            if (binarySearch(matrix[i], target)) {
                return true;
            }
        }

        return false;
    }

    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][]{{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        System.out.println("true ?= " + findNumberIn2DArray(test1, 5));
        System.out.println("false ?= " + findNumberIn2DArray(test1, 20));
    }
}
