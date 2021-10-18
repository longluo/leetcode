package com.longluo.top_interviews;

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

    public static List<String> generateParenthesis(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        List<String> ans = new ArrayList<>();
        backtrace(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public static void backtrace(List<String> ans, StringBuilder sb, int left, int right, int num) {
        if (left == right && left == num) {
            ans.add(sb.toString());
            return;
        }

        if (left < right || left > num || right > num) {
            return;
        }

        sb.append('(');
        backtrace(ans, sb, left + 1, right, num);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        backtrace(ans, sb, left, right + 1, num);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println("[()] ?= " + generateParenthesis(1));
        System.out.println("[((())), (()()), (())(), ()(()), ()()()] ?= " + generateParenthesis(3));
    }
}
