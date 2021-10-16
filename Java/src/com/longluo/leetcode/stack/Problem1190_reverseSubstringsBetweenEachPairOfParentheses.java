package com.longluo.leetcode.stack;

import java.util.Stack;

/**
 * 1190. 反转每对括号间的子串
 * <p>
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 * <p>
 * 示例 1：
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * <p>
 * 示例 2：
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * <p>
 * 示例 3：
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * <p>
 * 示例 4：
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 * <p>
 * 提示：
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 * <p>
 * https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 */
public class Problem1190_reverseSubstringsBetweenEachPairOfParentheses {

    public static String reverseParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int n = s.length();
        StringBuilder sb = new StringBuilder(n);
        Stack<String> stack = new Stack<>();
        int idx = 0;
        while (s.charAt(idx) != '(' && stack.empty()) {
            sb.append(s.charAt(idx));
            idx++;
        }

        return sb.toString();
    }

    private static String reverseString(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }

        StringBuilder sb = new StringBuilder(str.length());
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("dcba ?= " + reverseParentheses("(abcd)"));
        System.out.println("iloveu ?= " + reverseParentheses("(u(love)i)"));
        System.out.println("leetcode ?= " + reverseParentheses("(ed(et(oc))el)"));
        System.out.println("apmnolkjihgfedcbq ?= " + reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
}
