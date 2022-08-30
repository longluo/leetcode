package com.longluo.top100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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
 * https://leetcode.cn/problems/decode-string/
 */
public class Problem394_decodeString {

    // Stack time: O(n) space: O(n)
    public static String decodeString_stack(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }

        Deque<StringBuilder> strStk = new ArrayDeque<>();
        Deque<Integer> cntStk = new ArrayDeque<>();

        StringBuilder ans = new StringBuilder(len);
        int idx = 0;
        int cnt = 0;
        while (idx < len) {
            char ch = s.charAt(idx);
            if (Character.isDigit(ch)) {
                cnt = 10 * cnt + (ch - '0');
            } else if (ch == '[') {
                cntStk.push(cnt);
                strStk.push(ans);
                ans = new StringBuilder();
                cnt = 0;
            } else if (ch == ']') {
                int repeat = cntStk.pop();
                StringBuilder tmp = ans;
                ans = strStk.pop();
                while (repeat > 0) {
                    repeat--;
                    ans.append(tmp);
                }
            } else {
                ans.append(ch);
            }

            idx++;
        }

        return ans.toString();
    }

    // Recursion time: O(n) space: O(n)
    public static String decodeString(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            queue.offer(ch);
        }

        return helper(queue);
    }

    private static String helper(Queue<Character> queue) {
        StringBuilder res = new StringBuilder(queue.size());
        int cnt = 0;
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            if (Character.isDigit(ch)) {
                cnt = 10 * cnt + (ch - '0');
            } else if (ch == '[') {
                String sub = helper(queue);
                while (cnt > 0) {
                    cnt--;
                    res.append(sub);
                }
            } else if (ch == ']') {
                break;
            } else if (Character.isLetter(ch)) {
                res.append(ch);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println("aaabcbc ?= " + decodeString_stack("3[a]2[bc]"));
        System.out.println("accaccacc ?= " + decodeString_stack("3[a2[c]]"));

        System.out.println("aaabcbc ?= " + decodeString("3[a]2[bc]"));
        System.out.println("accaccacc ?= " + decodeString("3[a2[c]]"));
    }
}
