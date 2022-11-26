package com.longluo.contest.biweekly_contest_88;

/**
 * https://leetcode.cn/contest/biweekly-contest-88/
 */
public class Problem1 {

    public static boolean equalFrequency(String word) {
        int len = word.length();
        if (len <= 3) {
            return true;
        }

        for (int i = 0; i < len; i++) {
            String s = word.substring(0, i) + word.substring(i + 1);
            if (isEqual(s)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isEqual(String s) {
        int[] cnt = new int[26];

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int freq = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) {
                continue;
            }

            if (freq > 0 && cnt[i] != freq) {
                return false;
            }

            freq = cnt[i];
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + equalFrequency("abcc"));
        System.out.println("false ?= " + equalFrequency("aazz"));
        System.out.println("false ?= " + equalFrequency("ddaccb"));
    }
}
