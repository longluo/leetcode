package com.longluo.contest.biweekly_contest_77;

/**
 * https://leetcode.cn/contest/biweekly-contest-77/
 */

/**
 * https://leetcode.cn/problems/count-prefixes-of-a-given-string/
 */
public class Problem1 {

    public static int countPrefixes(String[] words, String s) {
        int ans = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + countPrefixes(new String[]{"a", "b", "c", "ab", "bc", "abc"}, "abc"));
        System.out.println("2 ?= " + countPrefixes(new String[]{"a", "a"}, "aa"));
    }
}
