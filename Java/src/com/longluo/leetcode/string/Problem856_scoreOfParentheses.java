package com.longluo.leetcode.string;

import java.util.Stack;

/**
 * 856. Score of Parentheses
 * <p>
 * Given a balanced parentheses string s, return the score of the string.
 * The score of a balanced parentheses string is based on the following rule:
 * "()" has score 1.
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 * <p>
 * Example 1:
 * Input: s = "()"
 * Output: 1
 * <p>
 * Example 2:
 * Input: s = "(())"
 * Output: 2
 * <p>
 * Example 3:
 * Input: s = "()()"
 * Output: 2
 * <p>
 * Constraints:
 * 2 <= s.length <= 50
 * s consists of only '(' and ')'.
 * s is a balanced parentheses string.
 * <p>
 * https://leetcode.com/problems/score-of-parentheses/
 */
public class Problem856_scoreOfParentheses {

    public static int scoreOfParentheses(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int res = 0;
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        int idx = 0;
        while (idx < len) {
            while (idx < len && s.charAt(idx) == '(') {
                idx++;
                stack.push('(');
            }

            res += (int) Math.pow(2, stack.size() - 1);
            ;

            while (idx < len && !stack.empty() && s.charAt(idx) == ')') {
                idx++;
                stack.pop();
            }
        }

        return res;
    }

    public static int scoreOfParentheses_opt(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        int idx = 0;
        while (idx < len) {
            while (s.charAt(idx) == '(') {
                idx++;
                stack.push(1);
            }

            res += (int) Math.pow(2, stack.size() - 1);

            while (!stack.empty() && s.charAt(idx) == ')') {
                idx++;
                stack.pop();
            }
        }

        return res;
    }

    public static int scoreOfParentheses_stack(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(0);
            } else {
                int subBottom = stack.pop();
                int bottom = stack.pop();
                stack.push(bottom + Math.max(2 * subBottom, 1));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + scoreOfParentheses("()"));
        System.out.println("2 ?= " + scoreOfParentheses("(())"));
        System.out.println("4 ?= " + scoreOfParentheses("((()))"));
        System.out.println("2 ?= " + scoreOfParentheses("()()"));
    }
}
