package com.longluo.leetcode.array;

import java.util.Arrays;

/*
59. 螺旋矩阵 II
给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class Problem59_generateMatrix {

    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int count = 1;
        for (int cycle = 0; cycle <= n / 2; cycle++) {
            for (int i = cycle; i < n - cycle; i++) {
                ans[cycle][i] = count++;
                if (count > n * n) {
                    return ans;
                }
            }

            for (int j = cycle + 1; j < n - cycle; j++) {
                ans[j][n - cycle - 1] = count++;
                if (count > n * n) {
                    return ans;
                }
            }

            for (int k = n - cycle - 2; k >= cycle; k--) {
                ans[n - cycle - 1][k] = count++;
                if (count > n * n) {
                    return ans;
                }
            }

            for (int l = n - cycle - 2; l > cycle; l--) {
                ans[l][cycle] = count++;
                if (count > n * n) {
                    return ans;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}} ?= " + Arrays.asList(generateMatrix(3)));

    }
}
