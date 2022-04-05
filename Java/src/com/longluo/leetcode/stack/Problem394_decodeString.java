package com.longluo.leetcode.stack;

import java.util.Stack;

/**
 * 394. 字符串解码
 * <p>
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * <p>
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * <p>
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * <p>
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * <p>
 * 提示：
 * 1 <= s.length <= 30
 * s 由小写英文字母、数字和方括号 '[]' 组成
 * s 保证是一个 有效 的输入。
 * s 中所有整数的取值范围为 [1, 300]
 * <p>
 * https://leetcode-cn.com/problems/decode-string/
 */
public class Problem394_decodeString {

    public static String decodeString(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }

        Stack<String> stk = new Stack<>();
        int idx = 0;
        int num = 0;
        while (idx < len) {
            char ch = s.charAt(idx);
            while (num == 0 && Character.isLetter(s.charAt(idx))) {
                idx++;
            }

            while (idx < len && Character.isDigit(s.charAt(idx))) {
                idx++;
                num = 10 * num + ch - '0';
            }

            stk.push("" + num);
            num = 0;
            if (s.charAt(idx) == '[') {
                idx++;
                StringBuilder sb = new StringBuilder();
                while (idx < len && Character.isLetter(s.charAt(idx))) {
                    sb.append(s.charAt(idx));
                    idx++;
                }
                stk.push(sb.toString());
            } else if (s.charAt(idx) == ']') {
                idx++;
            }
        }

        return "";
    }

    public static String mergeString(String str, int repeat) {
        if (str.length() == 0 || repeat <= 1) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= repeat; i++) {
            sb.append(str);
        }

        return sb.toString();
    }

    public static String decodeString_rec(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }

        int bal = 0;
        int num = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

        }

        return "";
    }

    public static String helper(String str, int repeat) {
        int len = str.length();
        if (len <= 1) {
            return str;
        }

        int num = 0;
        int bal = 0;
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (num == 0 && Character.isLetter(ch)) {
                sb.append(ch);
                continue;
            }

            if (Character.isDigit(ch)) {
                num = 10 * num + ch - '0';
            }

            if (bal == 0 && ch == '[') {
                left = i;
                bal++;
            } else if (ch == ']') {
                bal--;
                if (bal == 0) {

                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("aaabcbc ?= " + decodeString("3[a]2[bc]"));
        System.out.println("accaccacc ?= " + decodeString("3[a2[c]]"));
    }
}
