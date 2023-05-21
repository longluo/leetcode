package com.longluo.contest.weekly_contest_346;


/**
 * https://leetcode.cn/contest/weekly-contest-346
 */
public class Problem2 {

    public static String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (chars[left] < chars[right]) {
                chars[right] = chars[left];
            } else if (chars[left] > chars[right]) {
                chars[left] = chars[right];
            }

            left++;
            right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println("efcfe ?= " + makeSmallestPalindrome("egcfe"));
        System.out.println("abba ?= " + makeSmallestPalindrome("abcd"));
        System.out.println("neven ?= " + makeSmallestPalindrome("seven"));
    }
}
