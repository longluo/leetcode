package com.longluo.top100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

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

    // BF Opt time: O(n^2) space: O(n)
    // AC
    public static int longestValidParentheses_bf_opt(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int len = s.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ')') {
                continue;
            }

            int count = 0;

            for (int j = i; j < len; j++) {
                if (s.charAt(j) == '(') {
                    count++;
                } else {
                    count--;
                }

                if (count < 0) {
                    break;
                }

                if (count == 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }

    // DP
    public static int longestValidParentheses_dp(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int max = 0;
        int len = s.length();
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }

                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }

    // Stack  time: O(n) space: O(n)
    public static int longestValidParentheses_stack(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int max = 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }

    // Best
    public static int longestValidParentheses_best(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int len = s.length();
        int max = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                max = Math.max(max, 2 * left);
            }

            if (right > left) {
                left = right = 0;
            }
        }

        left = right = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                max = Math.max(max, 2 * left);
            }

            if (right > left) {
                left = right = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + longestValidParentheses_bf(""));
        System.out.println("2 ?= " + longestValidParentheses_bf("(()"));
        System.out.println("4 ?= " + longestValidParentheses_bf(")()())"));
        System.out.println("4 ?= " + longestValidParentheses_bf_opt(")()())"));

        System.out.println("4 ?= " + longestValidParentheses_dp(")()())"));

        System.out.println("2 ?= " + longestValidParentheses_stack("(()"));
        System.out.println("4 ?= " + longestValidParentheses_stack(")()())"));

        System.out.println("2 ?= " + longestValidParentheses_best("(()"));
        System.out.println("4 ?= " + longestValidParentheses_best(")()())"));
    }
}
