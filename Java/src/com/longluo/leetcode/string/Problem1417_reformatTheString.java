package com.longluo.leetcode.string;

/**
 * 1417. 重新格式化字符串
 * <p>
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 * <p>
 * 示例 1：
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 * <p>
 * 示例 2：
 * 输入：s = "leetcode"
 * 输出：""
 * 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 * <p>
 * 示例 3：
 * 输入：s = "1229857369"
 * 输出：""
 * 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
 * <p>
 * 示例 4：
 * 输入：s = "covid2019"
 * 输出："c2o0v1i9d"
 * <p>
 * 示例 5：
 * 输入：s = "ab123"
 * 输出："1a2b3"
 * <p>
 * 提示：
 * 1 <= s.length <= 500
 * s 仅由小写英文字母和/或数字组成。
 * <p>
 * https://leetcode.cn/problems/reformat-the-string/
 */
public class Problem1417_reformatTheString {

    // Simulate time: O(n) space: O(n)
    public static String reformat(String s) {
        StringBuilder letter = new StringBuilder();
        StringBuilder digit = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                letter.append(ch);
            } else {
                digit.append(ch);
            }
        }

        if (Math.abs(letter.length() - digit.length()) > 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder(s.length());
        int letterIdx = 0;
        int digitIdx = 0;
        if (letter.length() >= digit.length()) {
            sb.append(letter.charAt(letterIdx++));
        } else {
            sb.append(digit.charAt(digitIdx++));
        }

        while (letterIdx < letter.length() && digitIdx < digit.length()) {
            if (letterIdx > digitIdx) {
                sb.append(digit.charAt(digitIdx++));
                sb.append(letter.charAt(letterIdx++));
            } else if (digitIdx > letterIdx) {
                sb.append(letter.charAt(letterIdx++));
                sb.append(digit.charAt(digitIdx++));
            }
        }

        if (letterIdx < letter.length()) {
            sb.append(letter.charAt(letterIdx));
        } else if (digitIdx < digit.length()) {
            sb.append(digit.charAt(digitIdx));
        }

        return sb.toString();
    }

    // Two Pointers time: O(n) space: O(1)
    public static String reformat_opt(String s) {
        int len = s.length();
        int letterCnt = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                letterCnt++;
            }
        }

        int digitCnt = len - letterCnt;
        if (Math.abs(letterCnt - digitCnt) > 1) {
            return "";
        }

        boolean flag = letterCnt > digitCnt;
        char[] array = s.toCharArray();
        for (int i = 0, j = 1; i < len; i += 2) {
            if (Character.isLetter(array[i]) != flag) {
                while (Character.isLetter(array[j]) != flag) {
                    j += 2;
                }

                char temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        return new String(array);
    }

    public static void main(String[] args) {
        System.out.println("a0b1c2 ?= " + reformat("a0b1c2"));
        System.out.println("c2o0v1i9d ?= " + reformat_opt("covid2019"));
    }
}
