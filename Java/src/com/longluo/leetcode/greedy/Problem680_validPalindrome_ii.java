package com.longluo.leetcode.greedy;

/**
 * 680. 验证回文字符串 Ⅱ
 * <p>
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * 输入: s = "aba"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "abca"
 * 输出: true
 * 解释: 你可以删除c字符。
 * <p>
 * 示例 3:
 * 输入: s = "abc"
 * 输出: false
 * <p>
 * 提示:
 * 1 <= s.length <= 10^5
 * s 由小写英文字母组成
 * <p>
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 */
public class Problem680_validPalindrome_ii {

    // BF time: O(n) space: O(1) TimeOut
    public static boolean validPalindrome_bf(String s) {
        int len = s.length();
        if (len <= 2 || validPalindrome(s, 0, len - 1)) {
            return true;
        }

        for (int i = 0; i < len; i++) {
            String str = s.substring(0, i) + s.substring(i + 1, len);
            if (validPalindrome(str, 0, str.length() - 1)) {
                return true;
            }
        }

        return false;
    }

    // Two Pointers time: O(n) space: O(1)
    public static boolean validPalindrome_tp(String s) {
        int len = s.length();
        if (len <= 2) {
            return true;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1);
            } else {
                left++;
                right--;
            }
        }

        return true;
    }

    public static boolean validPalindrome(String s, int left, int right) {
        int len = s.length();
        if (left >= len || right < 0 || left > right) {
            return false;
        }

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // Recursive time: O(n) space: O(1) TimeOut
    public static boolean validPalindrome_recursive(String s) {
        return validPalindrome(s, 0, s.length() - 1, 1);
    }

    public static boolean validPalindrome(String s, int left, int right, int cnt) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (cnt > 0) {
                    return validPalindrome(s, left + 1, right, cnt - 1) || validPalindrome(s, left, right - 1, cnt - 1);
                } else {
                    return false;
                }
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + validPalindrome_bf("abca"));

        System.out.println("true ?= " + validPalindrome_tp("aba"));
        System.out.println("true ?= " + validPalindrome_tp("abca"));
        System.out.println("false ?= " + validPalindrome_tp("abc"));
        System.out.println("true ?= " + validPalindrome_tp("lcucncucul"));

        System.out.println("false ?= " + validPalindrome_recursive("abc"));
    }
}
