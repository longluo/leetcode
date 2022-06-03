package com.longluo.top_interviews;

/**
 * 125. 验证回文串
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * <p>
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 * <p>
 * 提示：
 * 1 <= s.length <= 2 * 10^5
 * 字符串 s 由 ASCII 字符组成
 * <p>
 * https://leetcode.cn/problems/valid-palindrome/
 */
public class Problem125_validPalindrome {

    // Two Pointers time: O(n) space: O(1)
    public static boolean isPalindrome_tp(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        int len = s.length();
        int left = 0;
        int right = len - 1;
        while (left < right) {
            while (left < right && !(Character.isDigit(s.charAt(left)) || Character.isAlphabetic(s.charAt(left)))) {
                left++;
            }

            while (right > left && !(Character.isDigit(s.charAt(right)) || Character.isAlphabetic(s.charAt(right)))) {
                right--;
            }

            if (Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))) {
                return false;
            }

            while (left < right && Character.toUpperCase(s.charAt(left)) == Character.toUpperCase(s.charAt(right))) {
                left++;
                right--;
            }
        }

        return true;
    }

    // Recursion time: O(n) space: O(logn)
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right && !(Character.isDigit(s.charAt(left)) || Character.isAlphabetic(s.charAt(left)))) {
            left++;
        }

        while (right > left && !(Character.isDigit(s.charAt(right)) || Character.isAlphabetic(s.charAt(right)))) {
            right--;
        }

        if (left == right) {
            return true;
        }

        return Character.toUpperCase(s.charAt(left)) == Character.toUpperCase(s.charAt(right)) && isPalindrome(s.substring(left + 1, right));
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isPalindrome_tp("A man, a plan, a canal: Panama"));
        System.out.println("false ?= " + isPalindrome_tp("race a car"));

        System.out.println("true ?= " + isPalindrome_tp("a."));
        System.out.println("true ?= " + isPalindrome_tp(".,"));

        System.out.println("false ?= " + isPalindrome("ab"));
        System.out.println("true ?= " + isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("false ?= " + isPalindrome("race a car"));
    }
}
