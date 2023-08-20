package com.longluo.contest.weekly_contest_359;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/contest/weekly-contest-359
 */
public class Problem1 {

    public static boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }

        int n = words.size();
        for (int i = 0; i < n; i++) {
            if (words.get(i).charAt(0) != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<String> tst1 = new ArrayList<>();

        System.out.println("true ?= " + isAcronym(tst1, ""));

    }
}
