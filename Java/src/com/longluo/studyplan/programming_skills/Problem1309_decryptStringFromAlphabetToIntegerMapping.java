package com.longluo.studyplan.programming_skills;

/**
 * 1309. 解码字母到整数映射
 * <p>
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 * <p>
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
 * 返回映射之后形成的新字符串。
 * <p>
 * 题目数据保证映射始终唯一。
 * <p>
 * 示例 1：
 * 输入：s = "10#11#12"
 * 输出："jkab"
 * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * <p>
 * 示例 2：
 * 输入：s = "1326#"
 * 输出："acz"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s[i] 只包含数字（'0'-'9'）和 '#' 字符。
 * s 是映射始终存在的有效字符串。
 * <p>
 * https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 */
public class Problem1309_decryptStringFromAlphabetToIntegerMapping {

    // BF from Right to Left time: O(n) space: O(1)
    public static String freqAlphabets_bf(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = len - 1; i >= 0; ) {
            char ch = s.charAt(i);
            if (ch == '#') {
                int num = s.charAt(i - 1) - '0' + 10 * (s.charAt(i - 2) - '0');
                sb.append((char) ('a' + num - 1));
                i -= 3;
            } else if (ch >= '1' && ch <= '9') {
                sb.append((char)('a' + ch - '1'));
                i--;
            }
        }

        return sb.reverse().toString();
    }

    // BF from Left to Right time: O(n) space: O(1)
    public String freqAlphabets_leftToRight(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (i + 2 < len && s.charAt(i + 2) == '#') {
                sb.append((char)((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '1') + 'a'));
                i += 2;
            } else {
                sb.append((char)(s.charAt(i) - '1' + 'a'));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("jkab ?= " + freqAlphabets_bf("10#11#12"));
    }
}
