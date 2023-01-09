package com.longluo.contest.weekly_contest_326;

/**
 * https://leetcode.cn/contest/weekly-contest-326
 */
public class Problem1 {

    // Math time: O(logn) space: O(1)
    public static int countDigits(int num) {
        int ans = 0;

        int temp = num;

        while (temp > 0) {
            int digit = temp % 10;
            if (num % digit == 0) {
                ans++;
            }

            temp /= 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + countDigits(7));
        System.out.println("2 ?= " + countDigits(121));
        System.out.println("4 ?= " + countDigits(1248));
    }
}
