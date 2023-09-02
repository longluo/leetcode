package com.longluo.contest.biweekly_contest_112;

/**
 * https://leetcode.cn/contest/biweekly-contest-112
 */
public class Problem2 {

    public static boolean checkStrings(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int len = s1.length();

        int[] odd1 = new int[26];
        int[] even1 = new int[26];

        int[] odd2 = new int[26];
        int[] even2 = new int[26];

        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                even1[s1.charAt(i) - 'a']++;
                even2[s2.charAt(i) - 'a']++;
            } else {
                odd1[s1.charAt(i) - 'a']++;
                odd2[s2.charAt(i) - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (odd1[i] != odd2[i] || even1[i] != even2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + checkStrings("abcdba", "cabdab"));
        System.out.println("false ?= " + checkStrings("abe", "bea"));
    }
}
