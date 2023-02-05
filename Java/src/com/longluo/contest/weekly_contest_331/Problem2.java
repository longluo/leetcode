package com.longluo.contest.weekly_contest_331;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/contest/weekly-contest-331
 */
public class Problem2 {

    // TLE
    public static int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length;

        Set<Character> set = new HashSet<>();
        for (char ch : "aeiou".toCharArray()) {
            set.add(ch);
        }

        int[] cnt = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (set.contains(word.charAt(0)) && set.contains(word.charAt(word.length() - 1))) {
                cnt[i] = 1;
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            for (int j = left; j <= right; j++) {
                ans[i] += cnt[j];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[2, 3, 0] ?= " + Arrays.toString(vowelStrings(new String[]{"aba", "bcb", "ece", "aa", "e"}, new int[][]{{0, 2}, {
                1, 4}, {1, 1}})));
    }
}
