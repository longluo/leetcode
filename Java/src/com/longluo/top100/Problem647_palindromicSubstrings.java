package com.longluo.top100;

/**
 * 647. 回文子串
 * <p>
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * 示例 1：
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * <p>
 * 示例 2：
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 * <p>
 * https://leetcode-cn.com/problems/palindromic-substrings/
 */
public class Problem647_palindromicSubstrings {

    // BF time: O(n^3) space: O(1)
    public static int countSubstrings_bf(String s) {
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (validPalindromic(s, i, j)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static boolean validPalindromic(String str, int left, int right) {
        if (left > right) {
            return false;
        }

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // DP time: O(n^2) space: O(n^2)
    public static int countSubstrings_dp(String s) {
        int len = s.length();
        int ans = 0;
        boolean[][] dp = new boolean[len][len];

        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else if (i < len - 1 && j >= 1) {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(j) == s.charAt(i);
                }

                ans += dp[i][j] ? 1 : 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + countSubstrings_bf("abc"));
        System.out.println("3 ?= " + countSubstrings_dp("abc"));
    }
}
