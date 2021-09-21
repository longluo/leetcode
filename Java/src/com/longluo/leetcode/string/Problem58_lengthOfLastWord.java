package com.longluo.leetcode.string;

/**
 * 58. 最后一个单词的长度
 * <p>
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * <p>
 * 示例 3：
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * <p>
 * 提示：
 * 1 <= s.length <= 10^4
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 * <p>
 * https://leetcode-cn.com/problems/length-of-last-word/
 */
public class Problem58_lengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        String[] arrays = s.trim().split("\\s+");
        return arrays[arrays.length - 1].length();
    }

    public static int lengthOfLastWord_1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int ans = 0;
        int idx = n - 1;
        while (idx >= 0) {
            while (idx >= 0 && s.charAt(idx) == ' ') {
                idx--;
            }

            while (idx >= 0 && s.charAt(idx) != ' ') {
                idx--;
                ans++;
            }

            break;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + lengthOfLastWord("Hello World"));
        System.out.println("5 ?= " + lengthOfLastWord_1("Hello World"));
        System.out.println("1 ?= " + lengthOfLastWord_1("a"));
    }
}
