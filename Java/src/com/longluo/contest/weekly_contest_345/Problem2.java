package com.longluo.contest.weekly_contest_345;

/**
 * https://leetcode.cn/contest/weekly-contest-345
 */
public class Problem2 {

    public static boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;

        int[] orig = new int[n];

        orig[0] = 0;

        for (int i = 0; i < n - 2; i++) {
            int x = derived[i];
            orig[i + 1] = x == 1 ? 1 : 0;
        }

        boolean flag1 = false;

        for (int i = 0; i < n; i++) {

        }

        boolean flag2 = true;

        return flag1 || flag2;
    }

    public static void main(String[] args) {

    }
}
