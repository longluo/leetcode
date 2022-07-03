package com.longluo.offer_ii;

/**
 * 剑指 Offer II 019. 最多删除一个字符得到回文
 * <p>
 * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
 * <p>
 * 示例 1:
 * 输入: s = "aba"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "abca"
 * 输出: true
 * 解释: 可以删除 "c" 字符 或者 "b" 字符
 * <p>
 * 示例 3:
 * 输入: s = "abc"
 * 输出: false
 * <p>
 * 提示:
 * 1 <= s.length <= 10^5
 * s 由小写英文字母组成
 * <p>
 * 注意：本题与主站 680 题相同： https://leetcode.cn/problems/valid-palindrome-ii/
 * <p>
 * https://leetcode.cn/problems/RQku0D/
 */
public class Offer2_019_validPalindrome {

    //
    public static boolean validPalindrome(String s) {
        int len = s.length();

        int left = 0;
        int right = len - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }

        if (left == len / 2) {
            return true;
        }

        return check(s, left + 1, right) || check(s, left, right - 1);
    }

    public static boolean check(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + validPalindrome("a"));
        System.out.println("true ?= " + validPalindrome("ab"));
        System.out.println("true ?= " + validPalindrome("aba"));
        System.out.println("true ?= " + validPalindrome("abca"));
        System.out.println("false ?= " + validPalindrome("abc"));
        System.out.println("true ?= " + validPalindrome("agcupuuffuupucuga"));
        System.out.println("true ?= " + validPalindrome("ebcbbececabbacecbbcbe"));
    }
}
