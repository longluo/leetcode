package com.longluo.studyplan.programming_skills;

/**
 * 709. 转换成小写字母
 * <p>
 * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
 * <p>
 * 示例 1：
 * 输入：s = "Hello"
 * 输出："hello"
 * <p>
 * 示例 2：
 * 输入：s = "here"
 * 输出："here"
 * <p>
 * 示例 3：
 * 输入：s = "LOVELY"
 * 输出："lovely"
 * <p>
 * 提示：
 * 1 <= s.length <= 100
 * s 由 ASCII 字符集中的可打印字符组成
 * <p>
 * https://leetcode-cn.com/problems/to-lower-case/
 */
public class Problem709_toLowerCase {

    // BF StringBuilder time: O(n) space: O(1)
    public static String toLowerCase_bf(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                ch = (char) (ch + 32);
            }

            sb.append(ch);
        }

        return sb.toString();
    }

    // API time: O(n) space: O(1)
    public static String toLowerCase_api(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(Character.toLowerCase(ch));
        }

        return sb.toString();
    }

    // API 1 Line Code time: O(n) space: O(1)
    public static String toLowerCase_api_1Line(String s) {
        return s.toLowerCase();
    }

    // Best time: O(n) space: O(1)
    public static String toLowerCase_best(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch >= 65 && ch <= 90) {
                ch |= 32;
            }

            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
