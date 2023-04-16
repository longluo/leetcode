package com.longluo.contest.weekly_contest_341;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.cn/contest/weekly-contest-341
 */
public class Problem1 {

    public static int[] rowAndMaximumOnes(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        int[] ans = new int[2];

        int cnt = 0;

        for (int i = 0; i < r; i++) {
            int sum = 0;

            for (int j = 0; j < c; j++) {
                sum += mat[i][j];
            }

            if (sum > cnt) {
                cnt = sum;
                ans[0] = i;
                ans[1] = cnt;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[0, 1] ?= " + Arrays.toString(rowAndMaximumOnes(new int[][]{{0, 1}, {1, 0}})));
        System.out.println("17 ?= " + Arrays.toString(rowAndMaximumOnes(new int[][]{{1, 2, 3}, {5, 17, 7}, {9, 11, 10}})));
    }
}
