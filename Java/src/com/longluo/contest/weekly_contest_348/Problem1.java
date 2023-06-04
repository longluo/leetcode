package com.longluo.contest.weekly_contest_348;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/contest/weekly-contest-348
 */
public class Problem1 {

    public static int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();

        for (char ch : s.toCharArray()) {
            set.add(ch);
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + minimizedStringLength("ipi"));
        System.out.println("3 ?= " + minimizedStringLength("aaabc"));
        System.out.println("3 ?= " + minimizedStringLength("aaaabc"));
        System.out.println("3 ?= " + minimizedStringLength("aaaabcc"));
        System.out.println("3 ?= " + minimizedStringLength("cbbd"));
        System.out.println("2 ?= " + minimizedStringLength("dddaaa"));
    }
}
