package com.longluo.contest.biweekly_contest_106;

import java.util.HashSet;

/**
 * https://leetcode.cn/contest/
 */
public class Problem1 {

    public static boolean isFascinating(int n) {
        if (n > 333 || n % 10 == 0) {
            return false;
        }

        StringBuilder ans = new StringBuilder();

        ans.append(n).append(2 * n).append(3 * n);

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            char ch = ans.charAt(i);

            if (set.contains(ch) || ch == '0') {
                return false;
            }

            set.add(ch);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isFascinating(192));
        System.out.println("false ?= " + isFascinating(100));
        System.out.println("false ?= " + isFascinating(999));
    }
}
