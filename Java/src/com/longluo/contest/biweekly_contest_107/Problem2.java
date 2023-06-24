package com.longluo.contest.biweekly_contest_107;

/**
 * https://leetcode.cn/contest/biweekly-contest-107
 */
public class Problem2 {

    public static int longestString(int x, int y, int z) {
        int ans = 0;

        if (x == y) {
            ans += 2 * (x + y);
        } else if (x > y) {
            ans += 2 * (2 * y + 1);
        } else {
            ans += 2 * (2 * x + 1);
        }

        ans += 2 * z;

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("12 ?= " + longestString(2, 5, 1));
        System.out.println("14 ?= " + longestString(3, 2, 2));
    }
}
