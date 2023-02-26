package com.longluo.contest.weekly_contest_334;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-334
 */
public class Problem2 {

    public static int[] divisibilityArray(String word, int m) {
        int n = word.length();

        long prefix = 0;

        boolean flag = false;

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            int digit = ch - '0';

            prefix = prefix * 10 + digit;

            if (prefix < m && !flag) {
                ans[i] = prefix == 0 ? 1 : 0;
            } else {
                flag = true;
                if (prefix % m == 0) {
                    ans[i] = 1;
                } else {
                    ans[i] = 0;
                }
            }

            if (prefix > Integer.MAX_VALUE) {
                prefix = prefix % m;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println("[0, 1, 0, 1] ?= " + Arrays.toString(divisibilityArray("1010", 10)));
        System.out.println("[1, 1, 1] ?= " + Arrays.toString(divisibilityArray("000", 100)));
        System.out.println("[1, 1, 0, 0, 0, 1, 1, 0, 0] ?= " + Arrays.toString(divisibilityArray("998244353", 3)));
        System.out.println("[0,1,1,0,1,0,0,0,0,1,1,1,1,1,1,1] ?= " + Arrays.toString(divisibilityArray("4868438856666666", 6)));
    }
}
