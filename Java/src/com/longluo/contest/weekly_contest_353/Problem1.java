package com.longluo.contest.weekly_contest_353;

/**
 * https://leetcode.cn/contest/weekly-contest-353
 */
public class Problem1 {

    public static int theMaximumAchievableX(int num, int t) {
        return num + 2 * t;
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + theMaximumAchievableX(4, 1));
        System.out.println("7 ?= " + theMaximumAchievableX(3, 2));
    }
}
