package com.longluo.leetcode.dp;

import java.util.*;

/**
 * 1143. 最长公共子序列
 * <p>
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回0。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）
 * 后组成的新字符串。例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 * 示例 1：
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * <p>
 * 示例 2：
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * <p>
 * 示例 3：
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 * <p>
 * 提示：
 * 1 <= text1.length, text2.length <= 1000
 * text1 和 text2 仅由小写英文字符组成。
 * <p>
 * https://leetcode.cn/problems/longest-common-subsequence/
 */
public class Problem1143_longestCommonSubsequence {

    // Backtrack Opt
    // TLE
    public static int longestCommonSubsequence_bf(String text1, String text2) {
        if (text1.length() > text2.length()) {
            return longestCommonSubsequence_bf(text2, text1);
        }

        Set<String> seen = new HashSet<>();
        List<String> subStrList = new ArrayList<>();

        for (int i = 1; i <= text1.length(); i++) {
            backtrack(subStrList, seen, new StringBuilder(), text1, 0, i);
        }

        Collections.sort(subStrList, (s1, s2) -> s2.length() - s1.length());

        int max = 0;
        for (String subStr : subStrList) {
            if (check(subStr, text2)) {
                max = Math.max(max, subStr.length());
                break;
            }
        }

        return max;
    }

    private static void backtrack(List<String> res, Set<String> seen, StringBuilder path, String s, int idx, int len) {
        if (path.length() == len && !seen.contains(path.toString())) {
            seen.add(path.toString());
            res.add(path.toString());
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            path.append(s.charAt(i));
            backtrack(res, seen, path, s, i + 1, len);
            path.deleteCharAt(path.length() - 1);
        }
    }

    private static boolean check(String subStr, String s) {
        int p = 0;
        int q = 0;
        for (; p < subStr.length() && q < s.length(); ) {
            if (subStr.charAt(p) == s.charAt(q)) {
                p++;
                q++;
            } else {
                q++;
            }
        }

        return p == subStr.length() && q <= s.length();
    }

    // DP time: O(mn) space: O(mn)
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + longestCommonSubsequence_bf("abcde", "ace"));
        System.out.println("3 ?= " + longestCommonSubsequence_bf("abc", "abc"));
        System.out.println("0 ?= " + longestCommonSubsequence_bf("abc", "def"));
        System.out.println("1 ?= " + longestCommonSubsequence_bf("psnw", "vozsh"));

        System.out.println("3 ?= " + longestCommonSubsequence("abcde", "ace"));
    }
}
