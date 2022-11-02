package com.longluo.contest.weekly_contest_293;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/maximum-consecutive-floors-without-special-floors/
 */
public class Problem2 {

    // Memory LE
    public static int maxConsecutive_bf(int bottom, int top, int[] special) {
        int floors = top - bottom + 1;

        boolean[] marked = new boolean[floors];

        for (int x : special) {
            marked[x - bottom] = true;
        }

        int max = 0;
        int cnt = 0;

        for (int i = 0; i < floors; i++) {
            if (marked[i]) {
                cnt = 0;
                continue;
            }

            cnt++;
            max = Math.max(max, cnt);
        }

        return max;
    }

    // TLE
    public static int maxConsecutive_opt(int bottom, int top, int[] special) {
        int len = special.length;

        Arrays.sort(special);

        int max = 0;
        int cnt = 0;

        for (int i = bottom, j = 0; i <= top; i++) {
            if (j < len && i == special[j]) {
                cnt = 0;
                j++;
                continue;
            }

            cnt++;
            max = Math.max(max, cnt);
        }

        return max;
    }

    // Sort time: O(nlogn) space: O(logn)
    public static int maxConsecutive(int bottom, int top, int[] special) {
        int len = special.length;

        Arrays.sort(special);

        int max = Math.max(special[0] - bottom, top - special[len - 1]);

        for (int i = 1; i < len; i++) {
            max = Math.max(max, special[i] - special[i - 1] - 1);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + maxConsecutive_bf(2, 2, new int[]{2}));
        System.out.println("3 ?= " + maxConsecutive_bf(2, 9, new int[]{4, 6}));

        System.out.println("0 ?= " + maxConsecutive(2, 2, new int[]{2}));
        System.out.println("3 ?= " + maxConsecutive(2, 9, new int[]{4, 6}));
        System.out.println("0 ?= " + maxConsecutive(6, 8, new int[]{7, 6, 8}));
        System.out.println("12 ?= " + maxConsecutive(28, 50, new int[]{35, 48}));

        System.out.println("3 ?= " + maxConsecutive_opt(2, 9, new int[]{4, 6}));
        System.out.println("0 ?= " + maxConsecutive_opt(6, 8, new int[]{7, 6, 8}));
    }
}
