package com.longluo.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 1044. 最长重复子串
 * <p>
 * 给你一个字符串 s ，考虑其所有 重复子串 ：即，s 的连续子串，在 s 中出现 2 次或更多次。这些出现之间可能存在重叠。
 * 返回 任意一个 可能具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。
 * <p>
 * 示例 1：
 * 输入：s = "banana"
 * 输出："ana"
 * <p>
 * 示例 2：
 * 输入：s = "abcd"
 * 输出：""
 * <p>
 * 提示：
 * 2 <= s.length <= 3 * 10^4
 * s 由小写英文字母组成
 * <p>
 * https://leetcode-cn.com/problems/longest-duplicate-substring/
 */
public class Problem1044_longestDupSubstring {

    // BF time: O(n^4) space: O(n)
    // Timeout
    public static String longestDupSubstring_bf(String s) {
        if (s == null || s.length() <= 1) {
            return "";
        }

        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int maxLen = 0;
        String ans = "";
        for (int i = 0; i < len; i++) {
            sb.delete(0, sb.length());
            char ch = s.charAt(i);
            if (freq.getOrDefault(ch, 0) <= 1) {
                continue;
            }
            for (int j = i; j < len - sb.length(); j++) {
                sb.append(s.charAt(j));
                for (int k = i + 1; k < len; k++) {
                    String str = s.substring(k, len);
                    if (str.contains(sb.toString())) {
                        if (sb.length() >= maxLen) {
                            ans = sb.toString();
                        }
                        maxLen = Math.max(maxLen, sb.length());
                    }

                    break;
                }
            }
        }

        return ans;
    }

    // BF Opt time: O(n^3) space: O(n)
    // Timeout
    public static String longestDupSubstring_bf_opt(String s) {
        int len = s.length();
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int maxLen = 0;
        String ans = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - 1; i++) {
            char ch = s.charAt(i);
            if (cnt[ch - 'a'] <= 1) {
                continue;
            }

            for (int segLen = len - i; segLen > maxLen; segLen--) {
                sb.delete(0, sb.length());
                sb.append(s, i, i + segLen);
                String str = s.substring(i + 1, len);
                if (str.contains(sb.toString()) && sb.length() > maxLen) {
                    ans = sb.toString();
                    maxLen = Math.max(maxLen, sb.length());
                    break;
                }
            }
        }

        return ans;
    }

    // Binary Search time: O(n^2logn) space: O(n)
    // TimeOut
    public static String longestDupSubstring_bs(String s) {
        int len = s.length();
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        String ans = "";
        int maxLen = 0;

        for (int i = 0; i < len; i++) {
            if (cnt[s.charAt(i) - 'a'] < 2) {
                continue;
            }

            int ret = binarySearch(s, i, maxLen + 1, len - 1 - i);
            if (ret > maxLen) {
                maxLen = ret;
                ans = s.substring(i, i + maxLen);
            }
        }

        return ans;
    }

    public static int binarySearch(String s, int idx, int left, int right) {
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String subStr = s.substring(idx, idx + mid);
            String rightSubStr = s.substring(idx + 1);
            if (rightSubStr.contains(subStr)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("a ?= " + longestDupSubstring_bf("aa"));
        System.out.println(" ?= " + longestDupSubstring_bf("abcd"));
        System.out.println("ana ?= " + longestDupSubstring_bf("banana"));
        System.out.println("ma ?= " + longestDupSubstring_bf("nnpxouomcofdjuujloanjimymadkuepightrfodmauhrsy"));

        System.out.println("a ?= " + longestDupSubstring_bf_opt("aa"));
        System.out.println("ana ?= " + longestDupSubstring_bf_opt("banana"));
        System.out.println("ma ?= " + longestDupSubstring_bf_opt("mymadmay"));
        System.out.println("ma ?= " + longestDupSubstring_bf_opt("nnpxouomcofdjuujloanjimymadkuepightrfodmauhrsy"));

        System.out.println("ana ?= " + longestDupSubstring_bs("banana"));
        System.out.println("ma ?= " + longestDupSubstring_bs("mymadmay"));
        System.out.println("ma ?= " + longestDupSubstring_bs("nnpxouomcofdjuujloanjimymadkuepightrfodmauhrsy"));
    }
}
