package com.longluo.contest.weekly_contest_369;

/**
 * https://leetcode.cn/contest/weekly-contest-369
 */
public class Problem3 {

    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int x = Math.abs(fx - sx);
        int y = Math.abs(fy - sy);

        int min = Math.max(x, y);

        if (min == 0) {
            return t != 1;
        }

        return t >= min;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isReachableAtTime(2, 4, 7, 7, 6));
        System.out.println("false ?= " + isReachableAtTime(3, 1, 7, 3, 3));
        System.out.println("true ?= " + isReachableAtTime(1, 1, 1, 3, 2));
        System.out.println("false ?= " + isReachableAtTime(1, 2, 1, 2, 1));
    }
}
