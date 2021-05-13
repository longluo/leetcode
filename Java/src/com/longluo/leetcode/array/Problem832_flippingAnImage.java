package com.longluo.leetcode.array;

/**
 * 832. 翻转图像
 * <p>
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * <p>
 * 示例 1：
 * 输入：[[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * <p>
 * 示例 2：
 * 输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * <p>
 * 提示：
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 * <p>
 * https://leetcode-cn.com/problems/flipping-an-image/
 */
public class Problem832_flippingAnImage {

    public static int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return A;
        }

        int row = A.length;
        int col = A[0].length;

        int[][] res = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = A[i][col - 1 - j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (res[i][j] == 0) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = 0;
                }
            }
        }

        return res;
    }

    public static int[][] flipAndInvertImage_2(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return A;
        }

        int row = A.length;
        int col = A[0].length;

        for (int i = 0; i < row; i++) {
            int left = 0;
            int right = col - 1;
            while (left < right) {
                if (A[i][left] == A[i][right]) {
                    A[i][left] ^= 1;
                    A[i][right] ^= 1;
                }
                left++;
                right--;
            }
            if (left == right) {
                A[i][left] ^= 1;
            }
        }

        return A;
    }

    public static void main(String[] args) {

    }
}
