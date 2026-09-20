package com.longluo.contest.biweekly_contest_153;

/**
 * 3498. 字符串的反转度
 */
public class Problem1 {

    public static int reverseDegree(String s) {
        int ans = 0;

        char[] array = s.toCharArray();

        for (int i = 0; i < array.length; i++) {
            char x = array[i];
            int cur = x - 'a';
            ans += (i + 1) * (26 - cur);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("148 ?= " + reverseDegree("abc"));
        System.out.println("160 ?= " + reverseDegree("zaza"));
    }
}
