package com.longluo.top_interviews;

/**
 * 8. String to Integer (atoi)
 * Medium
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer
 * (similar to C/C++'s atoi function).
 * The algorithm for myAtoi(string s) is as follows:
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'.
 * Read this character in if it is either. This determines if the final result is negative or positive respectively.
 * Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached.
 * The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0.
 * Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1],
 * then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231,
 * and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * <p>
 * Note:
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 * <p>
 * Example 1:
 * Input: s = "42"
 * Output: 42
 * Explanation: The underlined characters are what is read in, the caret is the current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 * ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 * ^
 * Step 3: "42" ("42" is read in)
 * ^
 * The parsed integer is 42.
 * Since 42 is in the range [-231, 231 - 1], the final result is 42.
 * <p>
 * Example 2:
 * Input: s = "   -42"
 * Output: -42
 * Explanation:
 * Step 1: "   -42" (leading whitespace is read and ignored)
 * ^
 * Step 2: "   -42" ('-' is read, so the result should be negative)
 * ^
 * Step 3: "   -42" ("42" is read in)
 * ^
 * The parsed integer is -42.
 * Since -42 is in the range [-231, 231 - 1], the final result is -42.
 * <p>
 * Example 3:
 * Input: s = "4193 with words"
 * Output: 4193
 * Explanation:
 * Step 1: "4193 with words" (no characters read because there is no leading whitespace)
 * ^
 * Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
 * ^
 * Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
 * ^
 * The parsed integer is 4193.
 * Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
 * <p>
 * Constraints:
 * 0 <= s.length <= 200
 * s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'
 * <p>
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class Problem8_stringToInteger_atoi {

    public static int myAtoi(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        int len = s.length();
        int sign = 1;
        int ans = 0;
        int idx = 0;

        while (idx < len && s.charAt(idx) == ' ') {
            idx++;
        }

        if (idx == len) {
            return 0;
        }

        if (s.charAt(idx) == '+' || s.charAt(idx) == '-') {
            sign = s.charAt(idx) == '-' ? -1 : 1;
            idx++;
        }

        while (idx < len) {
            char ch = s.charAt(idx);
            if (!Character.isDigit(ch)) {
                break;
            }

            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && (ch - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }

            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && (ch - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            ans = 10 * ans + sign * (ch - '0');
            idx++;
        }

        return ans;
    }

    public static int myAtoi_str(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        s = s.trim();
        boolean isNegative = false;
        long ans = 0;
        int len = s.length();
        int idx = 0;
        if (idx < len && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
            isNegative = s.charAt(idx) == '-';
            idx++;
        }

        while (idx < len) {
            char ch = s.charAt(idx);
            if (!Character.isDigit(ch)) {
                break;
            }

            if (ans > Integer.MAX_VALUE) {
                break;
            }
            ans = 10 * ans + ch - '0';
            idx++;
        }

        ans = isNegative ? -ans : ans;
        if (ans > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (ans < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println("-42  ?= " + myAtoi("+1"));
        System.out.println("2147483647  ?= " + myAtoi("2147483648"));
        System.out.println("2147483647  ?= " + myAtoi("9223372036854775808"));
        System.out.println("-42  ?= " + myAtoi("   -42"));
        System.out.println("3  ?= " + myAtoi("3.14159"));
        System.out.println("42  ?= " + myAtoi("42"));
        System.out.println("4193  ?= " + myAtoi("4193 with words"));
        System.out.println("0  ?= " + myAtoi("words and 987"));

        System.out.println("-42  ?= " + myAtoi_str("   -42"));
    }
}
