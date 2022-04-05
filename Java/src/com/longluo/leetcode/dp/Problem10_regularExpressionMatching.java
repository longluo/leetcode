package com.longluo.leetcode.dp;

/**
 * 10. Regular Expression Matching
 * <p>
 * Hard
 * <p>
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 * <p>
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Example 1:
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * <p>
 * Example 2:
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * <p>
 * Example 3:
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * <p>
 * Constraints:
 * 1 <= s.length <= 20
 * 1 <= p.length <= 30
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 * <p>
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class Problem10_regularExpressionMatching {

    public static boolean isMatch(String s, String p) {

        return true;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + isMatch("aa", "a"));
        System.out.println("true ?= " + isMatch("aa", "a*"));
    }
}
