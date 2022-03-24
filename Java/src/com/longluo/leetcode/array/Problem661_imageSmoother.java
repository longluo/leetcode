package com.longluo.leetcode.array;

import com.longluo.datastructure.ArrayUtils;

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

    public static int[][] imageSmoother_prefixSum(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] sum = new int[m + 10][n + 10];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + img[i - 1][j - 1];
            }
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int a = Math.max(0, i - 1), b = Math.max(0, j - 1);
                int c = Math.min(m - 1, i + 1), d = Math.min(n - 1, j + 1);
                int cnt = (c - a + 1) * (d - b + 1);
                int tot = sum[c + 1][d + 1] - sum[a][d + 1] - sum[c + 1][b] + sum[a][b];
                ans[i][j] = tot / cnt;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(ArrayUtils.print2DArray(imageSmoother(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}})));

    }
}
