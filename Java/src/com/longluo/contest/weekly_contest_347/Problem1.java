package com.longluo.contest.weekly_contest_347;

/**
 * https://leetcode.cn/contest/weekly-contest-347
 */
public class Problem1 {

    public static String removeTrailingZeros(String num) {
        StringBuilder sb = new StringBuilder(num);

        int n = num.length();

        for (int i = n - 1; i >= 0; i--) {
            if (num.charAt(i) == '0') {
                sb.deleteCharAt(i);
            } else {
                break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("123 ?= " + removeTrailingZeros("123"));
        System.out.println(" ?= " + removeTrailingZeros("00"));
        System.out.println("512301 ?= " + removeTrailingZeros("51230100"));
    }
}
