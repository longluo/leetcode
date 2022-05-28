package com.longluo.contest.biweekly_contest_79;

public class Problem1 {

    public static boolean digitCount(String num) {
        int len = num.length();
        int[] cnt = new int[10];
        for (int i = 0; i < len; i++) {
            char ch = num.charAt(i);
            cnt[ch - '0']++;
        }

        for (int i = 0; i < len; i++) {
            int freq = num.charAt(i) - '0';
            if (cnt[i] != freq) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + digitCount("1210"));
        System.out.println("false ?= " + digitCount("030"));
    }
}
