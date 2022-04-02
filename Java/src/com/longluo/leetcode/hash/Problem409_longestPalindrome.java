package com.longluo.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. 最长回文串
 * <p>
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 示例 1:
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * 示例 2:
 * 输入:s = "a"
 * 输入:1
 * <p>
 * 示例 3:
 * 输入:s = "bb"
 * 输入: 2
 * <p>
 * 提示:
 * 1 <= s.length <= 2000
 * s 只能由小写和/或大写英文字母组成
 * <p>
 * https://leetcode-cn.com/problems/longest-palindrome/
 */
public class Problem409_longestPalindrome {

    // HashMap + Greedy time: O(n) space: O(n)
    public static int longestPalindrome_hash(String s) {
        int ans = 0;
        boolean isOdd = false;
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        if (freq.size() == 1) {
            return s.length();
        }
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                ans += entry.getValue();
            } else {
                ans += entry.getValue() - 1;
                if (!isOdd) {
                    isOdd = true;
                    ans++;
                }
            }
        }

        return ans;
    }

    // bad than before.
    public static int longestPalindrome_hash_2(String s) {
        int ans = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            if (freq.getOrDefault(ch, 0) >= 2) {
                ans += 2;
                freq.put(ch, freq.getOrDefault(ch, 0) - 2);
            }
        }

        if (freq.size() == 1) {
            return s.length();
        }

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > 0) {
                ans += 1;
                return ans;
            }
        }

        return ans;
    }

    // Count time: O(n + 128) space: O(128) = O(1) Best
    public static int longestPalindrome_count(String s) {
        int ans = 0;
        boolean addOne = true;
        int[] count = new int[128];
        for (char ch : s.toCharArray()) {
            count[ch]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 == 0) {
                ans += count[i];
            } else {
                ans += count[i] - 1;
                if (addOne) {
                    ans++;
                    addOne = false;
                }
            }
        }

        return ans;
    }

    public static int longestPalindrome_count_opt(String s) {
        int ans = 0;
        int[] count = new int[128];
        for (char ch : s.toCharArray()) {
            count[ch]++;
        }

        for (int i = 0; i < count.length; i++) {
            ans += count[i] / 2 * 2;
            if (count[i] % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }

        return ans;
    }

    // Count Opt Better time: O(n) space O(128) = O(1)
    public static int longestPalindrome_count_better(String s) {
        int oddCnt = 0;
        int[] count = new int[128];
        for (char ch : s.toCharArray()) {
            count[ch]++;
        }

        for (int i : count) {
            if (i % 2 == 1) {
                oddCnt++;
            }
        }

        return oddCnt == 0 ? s.length() : s.length() - oddCnt + 1;
    }

    // Count Opt time: O(n) space O(128) = O(1)
    public static int longestPalindrome_count_best(String s) {
        int ans = 0;
        int[] count = new int[128];
        for (char ch : s.toCharArray()) {
            // Version 1
//            count[ch]++;
//            if (count[ch] % 2 == 0) {
//                ans += count[ch];
//                count[ch] = 0;
//            }

            // Version 2
            if ((count[ch] & 1) > 0) {
                ans += 2;
            }

            count[ch]++;
        }

        return ans < s.length() ? ans + 1 : ans;
    }

    public static void main(String[] args) {
        System.out.println("7 ?= " + longestPalindrome_count_better("abccccdd"));
        System.out.println("7 ?= " + longestPalindrome_count_best("abccccdd"));
    }
}
