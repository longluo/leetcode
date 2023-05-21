package com.longluo.contest.weekly_contest_346;


/**
 * https://leetcode.cn/contest/weekly-contest-346
 */
public class Problem3 {

    public static int punishmentNumber(int n) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i * i);

            if (backtrack(s, 0, i)) {
                ans += i * i;
            }
        }

        return ans;
    }

    private static boolean backtrack(String s, int start, int remain) {
        int n = s.length();

        if (start == n && remain == 0) {
            return true;
        }

        for (int i = start; i < n; i++) {
            int current = Integer.parseInt(s.substring(start, i + 1));
            if (current > remain) {
                continue;
            }

            if (backtrack(s, i + 1, remain - current)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + punishmentNumber(1));
        System.out.println("182 ?= " + punishmentNumber(10));
        System.out.println("1478 ?= " + punishmentNumber(37));
    }
}