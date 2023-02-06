package com.longluo.contest.weekly_contest_329;

/**
 * https://leetcode.cn/contest/weekly-contest-329
 */
public class Problem1 {

    public static int alternateDigitSum(int n) {
        int ans = 0;

        String s = String.valueOf(n);

        int flag = 1;

        for (char ch : s.toCharArray()) {
            int digit = ch - '0';
            ans += flag * digit;
            flag = -1 * flag;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + alternateDigitSum(521));
        System.out.println("1 ?= " + alternateDigitSum(111));
    }
}