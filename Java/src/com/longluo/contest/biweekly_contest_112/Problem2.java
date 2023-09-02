package com.longluo.contest.biweekly_contest_112;

/**
 * https://leetcode.cn/contest/biweekly-contest-112
 */
public class Problem2 {

    public static boolean checkStrings(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int[] oddcnt1 = new int[26];
        int[] oddcnt2 = new int[26];

        int[] evencnt1 = new int[26];
        int[] evencnt2 = new int[26];

        int n = s1.length();

        for (int i = 0; i < n; i += 2) {
            evencnt1[s1.charAt(i) - 'a']++;
            evencnt2[s2.charAt(i) - 'a']++;
        }

        for (int i = 1; i < n; i += 2) {
            oddcnt1[s1.charAt(i) - 'a']++;
            oddcnt2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (oddcnt1[i] != oddcnt2[i] || evencnt1[i] != evencnt2[i]) {
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
