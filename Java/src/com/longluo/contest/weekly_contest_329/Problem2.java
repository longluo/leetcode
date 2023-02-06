package com.longluo.contest.weekly_contest_329;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/contest/weekly-contest-329
 */
public class Problem2 {

    public static int[][] sortTheStudents(int[][] score, int k) {
        int m = score.length;
        int n = score[0].length;

        int[][] sorted = new int[m][2];

        for (int i = 0; i < m; i++) {
            sorted[i][0] = i;
            sorted[i][1] = score[i][k];
        }

        Arrays.sort(sorted, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = score[sorted[i][0]][j];
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}