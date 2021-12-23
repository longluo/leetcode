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

    public static String longestDupSubstring(String s) {
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
                        break;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("a ?= " + longestDupSubstring("aa"));
        System.out.println("ana ?= " + longestDupSubstring("banana"));
        System.out.println(" ?= " + longestDupSubstring("abcd"));
        System.out.println("ma ?= " + longestDupSubstring("mymadmay"));
        System.out.println("ma ?= " + longestDupSubstring("nnpxouomcofdjuujloanjimymadkuepightrfodmauhrsy"));
    }
}
