package com.longluo.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
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
 * https://leetcode.cn/problems/reverse-substrings-between-each-pair-of-parentheses/
 */
public class Problem1190_reverseSubstringsBetweenEachPairOfParentheses {

    // Stack time: O(n) space: O(n)
    public static String reverseParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int len = s.length();
        Deque<Character> st = new ArrayDeque<>();
        int idx = 0;
        while (idx < len) {
            char ch = s.charAt(idx);
            if (Character.isLetter(ch) || ch == '(') {
                st.push(ch);
            } else {
                Queue<Character> queue = new ArrayDeque<>();
                while (!st.isEmpty() && st.peek() != '(') {
                    queue.offer(st.pop());
                }

                st.pop();

                while (!queue.isEmpty()) {
                    st.push(queue.poll());
                }
            }

            idx++;
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("dcba ?= " + reverseParentheses("(abcd)"));
        System.out.println("iloveu ?= " + reverseParentheses("(u(love)i)"));
        System.out.println("leetcode ?= " + reverseParentheses("(ed(et(oc))el)"));
        System.out.println("apmnolkjihgfedcbq ?= " + reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
}
