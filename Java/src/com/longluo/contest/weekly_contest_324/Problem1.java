package com.longluo.contest.weekly_contest_324;

/**
 * https://leetcode.cn/contest/weekly-contest-324
 */

/**
 * https://leetcode.cn/problems/count-pairs-of-similar-strings/
 */
public class Problem1 {

    // BF time: O(n^3) space: O(C)
    public static int similarPairs(String[] words) {
        int len = words.length;

        int ans = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (check(words[i], words[j])) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private static boolean check(String a, String b) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (char ch : a.toCharArray()) {
            cnt1[ch - 'a']++;
        }

        for (char ch : b.toCharArray()) {
            cnt2[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((cnt1[i] == 0 && cnt2[i] > 0) || (cnt1[i] > 0 && cnt2[i] == 0)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + similarPairs(new String[]{"aba", "aabb", "abcd", "bac", "aabc"}));
        System.out.println("3 ?= " + similarPairs(new String[]{"aabb", "ab", "ba"}));
    }
}
