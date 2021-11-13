package com.longluo.leetcode.string;

/**
 * 520. 检测大写字母
 * <p>
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：word = "USA"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：word = "FlaG"
 * 输出：false
 * <p>
 * 提示：
 * 1 <= word.length <= 100
 * word 由小写和大写英文字母组成
 * <p>
 * https://leetcode-cn.com/problems/detect-capital/
 */
public class Problem520_detectCapital {

    public static boolean detectCapitalUse(String word) {
        if (word == null || word.length() <= 1) {
            return true;
        }

        int len = word.length();
        int upperCnt = 0;
        int index = 0;

        for (int i = 0; i < len; i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                upperCnt++;
                index = i;
            }
        }

        if (len == upperCnt) {
            return true;
        }

        if (upperCnt == 1 && index == 0) {
            return true;
        }

        if (upperCnt == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + detectCapitalUse("USA"));
        System.out.println("true ?= " + detectCapitalUse("GG"));
        System.out.println("false ?= " + detectCapitalUse("FlaG"));
        System.out.println("false ?= " + detectCapitalUse("TtTG"));
        System.out.println("true ?= " + detectCapitalUse("Leetcode"));
        System.out.println("false ?= " + detectCapitalUse("ffffffffffffffffffffF"));
    }
}
