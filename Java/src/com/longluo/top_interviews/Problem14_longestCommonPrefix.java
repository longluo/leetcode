package com.longluo.top_interviews;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 14. Longest Common Prefix
 * Easy
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Constraints:
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 * <p>
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class Problem14_longestCommonPrefix {

    // BF Substring time: O(n^2) space: O(1)
    public static String longestCommonPrefix_bf(String[] strs) {
        int len = strs.length;
        String str = strs[0];
        String ans = "";
        int maxLen = 0;
        for (int i = 1; i <= str.length(); i++) {
            String prefix = str.substring(0, i);
            boolean match = true;
            for (int j = 1; j < len; j++) {
                if (!strs[j].startsWith(prefix)) {
                    match = false;
                    break;
                }
            }

            if (match && prefix.length() > maxLen) {
                maxLen = prefix.length();
                ans = prefix;
            }
        }

        return ans;
    }

    // Sort time: O(n^2) space: O(1)
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String ans = "";
        // Length as the first
        Arrays.sort(strs, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        int len = strs.length;
        for (int i = strs[0].length(); i >= 1; i--) {
            String prefix = strs[0].substring(0, i);
            boolean match = true;
            for (int j = 1; j < len; j++) {
                if (!strs[j].startsWith(prefix)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                ans = prefix;
                return ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("a ?= " + longestCommonPrefix_bf(new String[]{"a"}));
        System.out.println("a ?= " + longestCommonPrefix_bf(new String[]{"a", "ab"}));
        System.out.println("fl ?= " + longestCommonPrefix_bf(new String[]{"flower", "flow", "flight"}));
        System.out.println("fl ?= " + longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(" ?= " + longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
