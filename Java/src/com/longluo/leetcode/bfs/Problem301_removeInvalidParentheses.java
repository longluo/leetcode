package com.longluo.leetcode.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 301. 删除无效的括号
 * <p>
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 * <p>
 * 示例 1：
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 * <p>
 * 示例 2：
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 * <p>
 * 示例 3：
 * 输入：s = ")("
 * 输出：[""]
 * <p>
 * 提示：
 * 1 <= s.length <= 25
 * s 由小写英文字母以及括号 '(' 和 ')' 组成
 * s 中至多含 20 个括号
 * <p>
 * https://leetcode-cn.com/problems/remove-invalid-parentheses/
 */
public class Problem301_removeInvalidParentheses {

    public static List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        Set<String> ans = new HashSet<>();
        int len = s.length();
        int lremove = 0;
        int rremove = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                lremove++;
            } else if (s.charAt(i) == ')') {
                if (lremove > 0) {
                    lremove--;
                } else {
                    rremove++;
                }
            }
        }

        backtrack(s, ans, 0, 0, 0, lremove, rremove);
        return new ArrayList<>(ans);
    }

    public static void backtrack(String str, Set<String> res, int start, int lcnt, int rcnt, int lremove, int rremove) {
        if (lremove == 0 && rremove == 0) {
            if (isValidString(str)) {
                res.add(str);
            }
            return;
        }

        for (int i = start; i < str.length(); i++) {
            if (lremove + rremove > str.length()) {
                break;
            }

            if (lremove > 0 && str.charAt(i) == '(') {
                backtrack(str.substring(0, i) + str.substring(i + 1), res, i, lcnt + 1, rcnt, lremove - 1, rremove);
            }

            if (rremove > 0 && str.charAt(i) == ')') {
                backtrack(str.substring(0, i) + str.substring(i + 1), res, i, lcnt, rcnt + 1, lremove, rremove - 1);
            }
        }
    }

    public static boolean isValidString(String str) {
        int len = str.length();
        int lcnt = 0;
        int rcnt = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == '(') {
                lcnt++;
            } else if (str.charAt(i) == ')') {
                rcnt++;
                if (lcnt < rcnt) {
                    return false;
                }
            }
        }

        if (lcnt == rcnt) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("[] ?= " + removeInvalidParentheses(")("));
        System.out.println("[(())(), ()()()] ?= " + removeInvalidParentheses("()())()"));
        System.out.println("[(a())(), (a)()()] ?= " + removeInvalidParentheses("(a)())()"));
    }
}
