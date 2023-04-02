package com.longluo.contest.weekly_contest_339;

/**
 * https://leetcode.cn/contest/weekly-contest-339
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/problems/count-the-number-of-beautiful-subarrays/
 */
public class Problem3 {

    public static int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;

        int[][] scores = new int[n][2];

        for (int i = 0; i < n; i++) {
            scores[i][0] = i;
            scores[i][1] = reward1[i] - reward2[i];
        }

        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });

        int ans = 0;

        for (int i = 0; i < k; i++) {
            ans += reward1[scores[i][0]];
        }

        for (int i = k; i < n; i++) {
            ans += reward2[scores[i][0]];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + miceAndCheese(new int[]{1, 1}, new int[]{1, 1}, 2));
        System.out.println("15 ?= " + miceAndCheese(new int[]{1, 1, 3, 4}, new int[]{4, 4, 1, 1}, 2));
    }
}