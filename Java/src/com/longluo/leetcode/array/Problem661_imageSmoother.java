package com.longluo.leetcode.array;

import com.longluo.datastructure.ArrayUtils;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/image-smoother/
 */
public class Problem661_imageSmoother {

    public static int[][] imageSmoother(int[][] img) {
        int row = img.length;
        int col = img[0].length;
        if (row <= 1 && col <= 1) {
            return img;
        }

        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int sum = 0;
                int cnt = 0;
                for (int m = i - 1; m <= i + 1; m++) {
                    for (int n = j - 1; n <= j + 1; n++) {
                        if ((m >= 0 && m < row) && (n >= 0 && n < col)) {
                            sum += img[m][n];
                            cnt++;
                        }
                    }
                }

                res[i][j] = sum / cnt;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(ArrayUtils.print2DArray(imageSmoother(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}})));

    }
}
