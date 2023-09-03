package com.longluo.contest.weekly_contest_361;

/**
 * https://leetcode.cn/contest/weekly-contest-361
 */
public class Problem1 {

    public static int countSymmetricIntegers(int low, int high) {
        int ans = 0;

        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);

            int n = s.length();

            if (n % 2 == 0) {
                int left = 0;
                int right = 0;

                for (int j = 0; j < n / 2; j++) {
                    left += s.charAt(j) - '0';
                }

                for (int j = n / 2; j < n; j++) {
                    right += s.charAt(j) - '0';
                }

                if (left > 0 && left == right) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("9 ?= " + countSymmetricIntegers(1, 100));
        System.out.println("4 ?= " + countSymmetricIntegers(1200, 1230));
    }
}
