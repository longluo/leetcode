package com.longluo.contest.weekly_contest_322;

/**
 * https://leetcode.cn/contest/weekly-contest-322
 */

public class Problem1 {

    public static boolean isCircularSentence(String sentence) {
        String[] words = sentence.split("\\s+");

        int len = words.length;

        for (int i = 0; i < len - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            if (cur.charAt(cur.length() - 1) != next.charAt(0)) {
                return false;
            }
        }

        if (words[0].charAt(0) != words[len - 1].charAt(words[len - 1].length() - 1)) {
            return false;
        }

        return true;
    }

    public static boolean isCircularSentence_opt(String sentence) {
        String[] array = sentence.split("\\s+");

        int n = array.length;
        if (array[0].charAt(0) != array[n - 1].charAt(array[n - 1].length() - 1)) {
            return false;
        }

        for (int i = 0; i < n - 1; i++) {
            String cur = array[i];
            String next = array[i + 1];
            if (cur.charAt(cur.length() - 1) != next.charAt(0)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isCircularSentence("eetcode"));
        System.out.println("false ?= " + isCircularSentence("Leetcode is cool"));
    }
}
