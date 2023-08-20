package com.longluo.contest.weekly_contest_357;

/**
 * https://leetcode.cn/contest/weekly-contest-357
 */
public class Problem1 {

    public static String finalString(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch != 'i') {
                sb.append(ch);
            } else {
                sb.reverse();
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("rtsng ?= " + finalString("string"));
        System.out.println("ponter ?= " + finalString("poiinter"));
    }
}
