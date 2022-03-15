package com.longluo.leetcode.string;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 1249. Minimum Remove to Make Valid Parentheses
 * <p>
 * Given a string s of '(' , ')' and lowercase English characters.
 * Your task is to remove the minimum number of parentheses ( '(' or ')',
 * in any positions ) so that the resulting parentheses string is valid and return any valid string.
 * Formally, a parentheses string is valid if and only if:
 * <p>
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * <p>
 * <p>
 * Example 1:
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * <p>
 * Example 2:
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * <p>
 * Example 3:
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 * <p>
 * Constraints:
 * 1 <= s.length <= 10^5
 * s[i] is either'(' , ')', or lowercase English letter.
 * <p>
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class Problem1249_minRemoveToMakeValid {

    public static String minRemoveToMakeValid(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }

        int len = s.length();
        StringBuilder sb = new StringBuilder(len);
        Stack<Integer> stack = new Stack<>();
        Set<Integer> idx = new HashSet<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
                idx.add(i);
            } else if (ch == ')') {
                if (!stack.empty()) {
                    idx.remove(stack.pop());
                } else {
                    idx.add(i);
                }
            }
        }

        while (!stack.empty()) {
            idx.add(stack.pop());
        }

        for (int i = 0; i < len; i++) {
            if (!idx.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("lee(t(c)o)de ?= " + minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(" ?= " + minRemoveToMakeValid("))(("));
    }
}
