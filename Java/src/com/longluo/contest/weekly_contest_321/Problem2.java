package com.longluo.contest.weekly_contest_321;

/**
 * https://leetcode.cn/contest/weekly-contest-321
 */

/**
 * https://leetcode.cn/problems/append-characters-to-string-to-make-subsequence/
 */
public class Problem2 {

    // Two Pointers time: O(n) space: O(1)
    public static int appendCharacters(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        int i = 0;
        int j = 0;

        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        if (i <= sLen && j == tLen) {
            return 0;
        }

        return tLen - j;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + appendCharacters("coaching", "coding"));
        System.out.println("0 ?= " + appendCharacters("abcde", "a"));
        System.out.println("5 ?= " + appendCharacters("z", "abcde"));
    }
}
