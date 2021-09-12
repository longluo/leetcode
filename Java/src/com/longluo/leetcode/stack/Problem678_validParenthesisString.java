package com.longluo.leetcode.stack;

/**
 * 678. 有效的括号字符串
 * <p>
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 * <p>
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: "(*)"
 * 输出: True
 * <p>
 * 示例 3:
 * 输入: "(*))"
 * 输出: True
 * <p>
 * 注意:
 * 字符串大小将在 [1，100] 范围内。
 * <p>
 * https://leetcode-cn.com/problems/valid-parenthesis-string/
 */
public class Problem678_validParenthesisString {

    public static boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                dp[i][i] = true;
            }
        }
        for (int i = 1; i < n; i++) {
            char c1 = s.charAt(i - 1), c2 = s.charAt(i);
            dp[i - 1][i] = (c1 == '(' || c1 == '*') && (c2 == ')' || c2 == '*');
        }
        for (int i = n - 3; i >= 0; i--) {
            char c1 = s.charAt(i);
            for (int j = i + 2; j < n; j++) {
                char c2 = s.charAt(j);
                if ((c1 == '(' || c1 == '*') && (c2 == ')' || c2 == '*')) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                for (int k = i; k < j && !dp[i][j]; k++) {
                    dp[i][j] = dp[i][k] && dp[k + 1][j];
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + checkValidString(""));
        System.out.println("true ?= " + checkValidString("()"));
        System.out.println("true ?= " + checkValidString("(*)"));
        System.out.println("true ?= " + checkValidString("(*))"));
    }
}
