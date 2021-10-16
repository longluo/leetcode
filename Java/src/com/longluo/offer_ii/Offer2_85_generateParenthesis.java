package com.longluo.offer_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 085. 生成匹配的括号
 * <p>
 * 正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
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
 * 注意：本题与主站 22 题相同： https://leetcode-cn.com/problems/generate-parentheses/
 * <p>
 * https://leetcode-cn.com/problems/IDBivT/
 */
public class Offer2_85_generateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrace(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public static void backtrace(List<String> ans, StringBuilder sb, int left, int right, int number) {
        if (left > number || right > number || right > left) {
            return;
        }

        if (left == right && left == number) {
            ans.add(sb.toString());
            return;
        }

        sb.append('(');
        backtrace(ans, sb, left + 1, right, number);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        backtrace(ans, sb, left, right + 1, number);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println("[()] ?= " + generateParenthesis(1));
        System.out.println("[((())), (()()), (())(), ()(()), ()()()] ?= " + generateParenthesis(3));
    }
}
