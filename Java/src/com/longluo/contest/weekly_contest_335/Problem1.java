package com.longluo.contest.weekly_contest_335;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-335
 */
public class Problem1 {

    public int passThePillow(int n, int time) {
        int remain = time % (2 * n - 2);

        if (remain < (n - 1)) {
            return remain + 1;
        }

        return 2 * n - remain - 1;
    }

    public static void main(String[] args) {

    }
}
