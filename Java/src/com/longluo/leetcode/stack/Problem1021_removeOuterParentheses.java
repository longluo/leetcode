package com.longluo.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1021. 删除最外层的括号
 * <p>
 * 有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 * <p>
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * <p>
 * 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * <p>
 * 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
 * <p>
 * 示例 1：
 * 输入：s = "(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * <p>
 * 示例 2：
 * 输入：s = "(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * <p>
 * 示例 3：
 * 输入：s = "()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 * <p>
 * 提示：
 * 1 <= s.length <= 10^5
 * s[i] 为 '(' 或 ')'
 * s 是一个有效括号字符串
 * <p>
 * https://leetcode.cn/problems/remove-outermost-parentheses/
 */
public class Problem1021_removeOuterParentheses {

    // Stack time: O(n) space: O(n)
    public static String removeOuterParentheses(String s) {
        int len = s.length();
        if (len <= 1) {
            return "";
        }

        Stack<Integer> stk = new Stack<>();
        List<int[]> idxList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stk.push(i);
            } else {
                int last = stk.pop();
                if (stk.empty()) {
                    idxList.add(new int[]{last, i});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] idx : idxList) {
            sb.append(s, idx[0] + 1, idx[1]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("()()() ?= " + removeOuterParentheses("(()())(())"));
        System.out.println("()()()()(()) ?= " + removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(" ?= " + removeOuterParentheses("()()"));
    }
}
