package com.longluo.contest.weekly_contest_336;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/contest/weekly-contest-336
 */

/**
 * https://leetcode.cn/problems/count-the-number-of-vowel-strings-in-range/
 */
public class Problem1 {

    public static int vowelStrings(String[] words, int left, int right) {
        Set<Character> vowelSet = new HashSet<>();
        for (char ch : "aeiou".toCharArray()) {
            vowelSet.add(ch);
        }

        int ans = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (vowelSet.contains(word.charAt(0)) && vowelSet.contains(word.charAt(word.length() - 1))) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + vowelStrings(new String[]{"are", "amy", "u"}, 0, 2));
    }
}
