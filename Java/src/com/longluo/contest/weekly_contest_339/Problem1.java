package com.longluo.contest.weekly_contest_339;

/**
 * https://leetcode.cn/contest/weekly-contest-339
 */
public class Problem1 {

    public static int findTheLongestBalancedSubstring(String s) {
        int n = s.length();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 2; i + j <= n; j += 2) {
                boolean flag = true;

                for (int k = 0; k < j / 2; k++) {
                    char ch = s.charAt(i + k);
                    if (ch == '1') {
                        flag = false;
                        break;
                    }
                }

                if (!flag) {
                    break;
                }

                for (int k = j / 2; k < j; k++) {
                    if (s.charAt(i + k) == '0') {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    ans = Math.max(ans, j);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + findTheLongestBalancedSubstring("01000111"));
        System.out.println("0 ?= " + findTheLongestBalancedSubstring("111"));
    }
}
