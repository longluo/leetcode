package com.longluo.contest.weekly_contest_321;

/**
 * https://leetcode.cn/contest/weekly-contest-321
 */

/**
 * https://leetcode.cn/problems/find-the-pivot-integer/
 */
public class Problem1 {

    // Math time: O(n) space: O(1)
    public static int pivotInteger(int n) {
        int total = n * (n + 1) / 2;

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;

            if ((total + i) % 2 == 0 && (total + i) / 2 == sum) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + pivotInteger(1));
        System.out.println("-1 ?= " + pivotInteger(4));
        System.out.println("6 ?= " + pivotInteger(8));
    }
}
