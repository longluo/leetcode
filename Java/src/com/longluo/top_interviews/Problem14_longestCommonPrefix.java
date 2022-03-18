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

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String ans = "";
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });
        int len = strs.length;
        for (int i = strs[0].length(); i >= 1; i--) {
            String prefix = strs[0].substring(0, i);
            boolean flag = true;
            for (int j = 1; j < len; j++) {
                if (!strs[j].startsWith(prefix)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans = prefix;
                return ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("fl ?= " + longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(" ?= " + longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
