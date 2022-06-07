package com.longluo.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * 提示：
 * 1 <= n <= 8
 * <p>
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Problem22_generateParenthesis {

    // BF time: O(2^n) space: O(2*n)
    public static List<String> generateParenthesis_bf(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        List<String> ans = new ArrayList<>();
        generateAll(new char[2 * n], 0, ans);
        return ans;
    }

    public static void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public static boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    // Backtrack time: O() space: O(n)
    public static List<String> generateParenthesis(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, StringBuilder sb, int left, int right, int num) {
        if (left == right && left == num) {
            ans.add(sb.toString());
            return;
        }

        if (left < right || left > num || right > num) {
            return;
        }

        sb.append('(');
        backtrack(ans, sb, left + 1, right, num);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        backtrack(ans, sb, left, right + 1, num);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println("[()] ?= " + generateParenthesis(1));
        System.out.println("[((())), (()()), (())(), ()(()), ()()()] ?= " + generateParenthesis(3));
        System.out.println("[((())), (()()), (())(), ()(()), ()()()] ?= " + generateParenthesis_bf(3));
    }
}
