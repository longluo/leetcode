package com.longluo.contest.biweekly_contest_112;

/**
 * https://leetcode.cn/contest/biweekly-contest-112
 */
public class Problem1 {

    public static boolean canBeEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int[] cnt1 = new int[26];

        int[] cnt2 = new int[26];

        for (int i = 0; i < 4; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) {
                return false;
            }
        }

        for (int i = 0; i < 4; i++) {
            char a1 = s1.charAt(i);
            char a2 = s2.charAt(i);

            if (a1 == a2) {
                continue;
            }

            boolean flag = false;

            for (int j = 0; j < 4; j++) {
                if (s2.charAt(j) == a1 && Math.abs(i - j) == 2) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + canBeEqual("abcd", "cdab"));
        System.out.println("false ?= " + canBeEqual("abcd", "dacb"));
    }
}
