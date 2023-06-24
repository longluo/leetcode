package com.longluo.contest.biweekly_contest_107;

/**
 * https://leetcode.cn/contest/biweekly-contest-107
 */
public class Problem2 {

    public static int longestString(int x, int y, int z) {
        int ans = 2 * z;

        if (x == y) {
            ans += 4 * x;
        } else {
            ans += 4 * Math.min(x, y) + 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("12 ?= " + longestString(2, 5, 1));
        System.out.println("14 ?= " + longestString(3, 2, 2));
    }
}
