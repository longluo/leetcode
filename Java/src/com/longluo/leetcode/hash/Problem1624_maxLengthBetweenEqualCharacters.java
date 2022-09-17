package com.longluo.leetcode.hash;

import java.util.Arrays;

/**
 * 1624. 两个相同字符之间的最长子字符串
 * <p>
 * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * <p>
 * 示例 1：
 * 输入：s = "aa"
 * 输出：0
 * 解释：最优的子字符串是两个 'a' 之间的空子字符串。
 * <p>
 * 示例 2：
 * 输入：s = "abca"
 * 输出：2
 * 解释：最优的子字符串是 "bc" 。
 * <p>
 * 示例 3：
 * 输入：s = "cbzxy"
 * 输出：-1
 * 解释：s 中不存在出现出现两次的字符，所以返回 -1 。
 * <p>
 * 示例 4：
 * 输入：s = "cabbac"
 * 输出：4
 * 解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
 * <p>
 * 提示：
 * 1 <= s.length <= 300
 * s 只含小写英文字母
 * <p>
 * https://leetcode.cn/problems/largest-substring-between-two-equal-characters/
 */
public class Problem1624_maxLengthBetweenEqualCharacters {

    // Count time: O(n) space: O(26)
    public static int maxLengthBetweenEqualCharacters(String s) {
        int[][] count = new int[26][2];

        int ans = -1;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (count[ch - 'a'][0] > 0) {
                ans = Math.max(ans, i - count[ch - 'a'][1] - 1);
            } else {
                count[ch - 'a'][0]++;
                count[ch - 'a'][1] = i;
            }
        }

        return ans;
    }

    // Count Opt time: O(n) space: O(26)
    public static int maxLengthBetweenEqualCharacters_opt(String s) {
        int[] count = new int[26];
        Arrays.fill(count, -1);

        int ans = -1;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (count[ch - 'a'] >= 0) {
                ans = Math.max(ans, i - count[ch - 'a'] - 1);
            } else {
                count[ch - 'a'] = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + maxLengthBetweenEqualCharacters("abca"));
        System.out.println("-1 ?= " + maxLengthBetweenEqualCharacters("cbzxy"));

        System.out.println("-1 ?= " + maxLengthBetweenEqualCharacters_opt("cbzxy"));
    }
}
