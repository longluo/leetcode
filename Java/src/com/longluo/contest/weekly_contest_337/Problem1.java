package com.longluo.contest.weekly_contest_337;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-337
 */

public class Problem1 {

    public static int[] evenOddBit(int n) {
        int[] ans = new int[2];

        String s = Integer.toBinaryString(n);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(s.length() - 1 - i);
            if (i % 2 == 0) {
                ans[0] += ch == '1' ? 1 : 0;
            } else {
                ans[1] += ch == '1' ? 1 : 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[2, 0] ?= " + Arrays.toString(evenOddBit(17)));
        System.out.println("[0, 1] ?= " + Arrays.toString(evenOddBit(2)));
    }
}
