package com.longluo.contest.weekly_contest_341;

/**
 * https://leetcode.cn/contest/weekly-contest-341
 */

public class Problem3 {

    public static int addMinimum(String word) {
        int n = word.length();

        int ans = 0;

        char[] array = word.toCharArray();

        for (int i = 0; i < n; i++) {
            if (i < n - 2 && array[i] == 'a' && array[i + 1] == 'b' && array[i + 2] == 'c') {
                array[i] = ' ';
                array[i + 1] = ' ';
                array[i + 2] = ' ';
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'a' && (i + 1 < array.length && (array[i + 1] == 'b' || array[i + 1] == 'c'))) {
                ans++;
                array[i] = ' ';
                array[i + 1] = ' ';
            } else if (array[i] == 'b' && i + 1 < array.length && array[i + 1] == 'c') {
                ans++;
                array[i] = ' ';
                array[i + 1] = ' ';
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (Character.isLetter(array[i])) {
                ans += 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + addMinimum("aaabcb"));
        System.out.println("2 ?= " + addMinimum("b"));
        System.out.println("6 ?= " + addMinimum("aaa"));
        System.out.println("0 ?= " + addMinimum("abc"));
    }
}