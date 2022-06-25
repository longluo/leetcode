package com.longluo.offer_ii;

/**
 * 剑指 Offer II 018. 有效的回文
 * <p>
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 * 本题中，将空字符串定义为有效的 回文串 。
 * <p>
 * 示例 1:
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * <p>
 * 示例 2:
 * 输入: s = "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 * <p>
 * 提示：
 * 1 <= s.length <= 2 * 10^5
 * 字符串 s 由 ASCII 字符组成
 * <p>
 * 注意：本题与主站 125 题相同： https://leetcode.cn/problems/valid-palindrome/
 * <p>
 * https://leetcode.cn/problems/XltzEq/
 */
public class Offer2_18_isPalindrome {

    public static boolean isPalindrome(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch) || Character.isLetter(ch)) {
                sb.append(Character.toUpperCase(ch));
            }
        }

        if (sb.length() <= 1) {
            return true;
        }

        char[] array = sb.toString().toCharArray();
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            if (array[i] != array[n - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isPalindrome("A man, a plan, a canal: Panama"));
    }
}
