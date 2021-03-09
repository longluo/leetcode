package com.longluo.leetcode.string;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class Problem125_isPalindrome {

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            while (left < n && left < right && !(Character.isDigit(s.charAt(left)) || Character.isAlphabetic(s.charAt(left)))) {
                left++;
            }

            while (right > 0 && left < right && !(Character.isDigit(s.charAt(right)) || Character.isAlphabetic(s.charAt(right)))) {
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

    public static void main(String[] args) {
        System.out.println("true ?= " + isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("false ?= " + isPalindrome("race a car"));
        System.out.println("true ?= " + isPalindrome("a."));
        System.out.println("true ?= " + isPalindrome(".,"));
    }
}
