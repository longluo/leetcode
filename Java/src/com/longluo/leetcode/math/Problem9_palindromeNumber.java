package com.longluo.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 9. Palindrome Number
 * Easy
 * Given an integer x, return true if x is palindrome integer.
 * An integer is a palindrome when it reads the same backward as forward.
 * For example, 121 is a palindrome while 123 is not.
 * <p>
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * <p>
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * <p>
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * Constraints:
 * -2^31 <= x <= 2^31 - 1
 * <p>
 * Follow up: Could you solve it without converting the integer to a string?
 * <p>
 * https://leetcode.com/problems/palindrome-number/
 */
public class Problem9_palindromeNumber {

    // BF + String time: O(logx) space: O(1)
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String str = String.valueOf(x);
        int len = str.length();
        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Math time: O(logx) space: O(1)
    public static boolean isPalindrome_math(int x) {
        if (x < 0) {
            return false;
        }

        List<Integer> digitList = new ArrayList<>();
        while (x > 0) {
            digitList.add(x % 10);
            x /= 10;
        }

        int left = 0;
        int right = digitList.size() - 1;
        while (left < right) {
            if (digitList.get(left) != digitList.get(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Best time: O(logx) space: O(1)
    public static boolean isPalindrome_best(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int revisited = 0;
        while (x > revisited) {
            revisited = revisited * 10 + x % 10;
            x /= 10;
        }

        return x == revisited || x == revisited / 10;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + isPalindrome(10));
        System.out.println("true ?= " + isPalindrome(121));
        System.out.println("false ?= " + isPalindrome(-121));

        System.out.println("true ?= " + isPalindrome_math(121));

        System.out.println("true ?= " + isPalindrome_best(121));
        System.out.println("true ?= " + isPalindrome_best(1221));
    }
}
