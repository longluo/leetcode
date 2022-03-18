package com.longluo.leetcode.string;

import java.util.Stack;

/**
 * 316. 去除重复字母
 * <p>
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters相同
 * <p>
 * 示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 * <p>
 * 示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * <p>
 * 提示：
 * 1 <= s.length <= 10^4
 * s 由小写英文字母组成
 * <p>
 * https://leetcode.com/problems/remove-duplicate-letters/
 */
public class Problem316_removeDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
        int len = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < len; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        boolean[] visited = new boolean[26];
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (!visited[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (cnt[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }

                visited[ch - 'a'] = true;
                sb.append(ch);
            }

            cnt[ch - 'a']--;
        }

        return sb.toString();
    }

    // Using Stack
    public static String removeDuplicateLetters_stk_1(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] inStack = new boolean[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (inStack[ch - 'a']) {
                continue;
            }

            stack.push(ch);
            inStack[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder(stack.size());
        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static String removeDuplicateLetters_stk_2(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] inStack = new boolean[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (inStack[ch - 'a']) {
                continue;
            }
            while (!stack.empty() && stack.peek() > ch) {
                inStack[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            inStack[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder(stack.size());
        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static String removeDuplicateLetters_stack(String s) {
        Stack<Character> stack = new Stack<>();
        int[] cnt = new int[26];
        boolean[] inStack = new boolean[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            cnt[ch - 'a']--;
            if (inStack[ch - 'a']) {
                continue;
            }
            while (!stack.empty() && stack.peek() > ch) {
                if (cnt[stack.peek() - 'a'] <= 0) {
                    break;
                }

                inStack[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            inStack[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder(stack.size());
        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("abc ?= " + removeDuplicateLetters("bcabc"));
        System.out.println("acdb ?= " + removeDuplicateLetters("cbacdcbc"));

        System.out.println("abc ?= " + removeDuplicateLetters_stack("bcabc"));
        System.out.println("acdb ?= " + removeDuplicateLetters_stack("cbacdcbc"));

        System.out.println("abc ?= " + removeDuplicateLetters_stk_1("bcabc"));
        System.out.println("abc ?= " + removeDuplicateLetters_stk_2("bcabc"));
        System.out.println("bac ?= " + removeDuplicateLetters_stack("bcac"));
    }
}
