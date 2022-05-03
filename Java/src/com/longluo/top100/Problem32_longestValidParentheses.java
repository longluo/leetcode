package com.longluo.top100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 * <p>
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * 示例 1：
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * <p>
 * 示例 2：
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * <p>
 * 示例 3：
 * 输入：s = ""
 * 输出：0
 * <p>
 * 提示：
 * 0 <= s.length <= 3 * 10^4
 * s[i] 为 '(' 或 ')'
 * <p>
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class Problem32_longestValidParentheses {

    // BF time: O(n^3) space: O(n)
    // TimeOut
    public static int longestValidParentheses_bf(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ')') {
                continue;
            }

            for (int j = len; j >= i + 2; j--) {
                if ((j - i) % 2 == 1) {
                    continue;
                }
                String subStr = s.substring(i, j);
                if (checkValid(subStr)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }

        return ans;
    }

    public static boolean checkValid(String s) {
        if (s == null || s.length() <= 1 || s.length() % 2 == 1) {
            return false;
        }

        Deque<Character> stk = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stk.push(ch);
            } else if (ch == ')' && stk.isEmpty()) {
                return false;
            } else if (ch == ')') {
                stk.pop();
            }
        }

        return stk.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + longestValidParentheses_bf(""));
        System.out.println("2 ?= " + longestValidParentheses_bf("(()"));
        System.out.println("4 ?= " + longestValidParentheses_bf(")()())"));
    }
}
