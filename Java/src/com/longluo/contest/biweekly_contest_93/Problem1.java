package com.longluo.contest.biweekly_contest_93;

/**
 * https://leetcode.cn/contest/biweekly-contest-93
 */

public class Problem1 {

    public static int maximumValue(String[] strs) {
        int max = 0;

        for (String s : strs) {
            boolean flag = true;
            for (char ch : s.toCharArray()) {
                if (Character.isLetter(ch)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                max = Math.max(max, Integer.parseInt(s));
            } else {
                max = Math.max(max, s.length());
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + maximumValue(new String[]{"alic3", "bob", "3", "4", "00000"}));
        System.out.println("1 ?= " + maximumValue(new String[]{"1", "01", "001", "0001"}));
    }
}
