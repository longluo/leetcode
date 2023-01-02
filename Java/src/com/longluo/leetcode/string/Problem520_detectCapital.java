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
 * https://leetcode.cn/problems/detect-capital/
 */
public class Problem520_detectCapital {

    //
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

    public static boolean detectCapitalUse_best(String word) {
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }

        // 无论第 1 个字母是否大写，其他字母必须与第 2 个字母的大小写相同
        for (int i = 2; i < word.length(); ++i) {
            if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1))) {
                return false;
            }
        }

        return true;
    }

    // Simulate time: O(n) space: O(1)
    public static boolean detectCapitalUse_opt(String word) {
        boolean isAllCapital = true;
        boolean firstCapital = true;
        boolean allLowercase = true;

        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                allLowercase = false;
                break;
            }
        }

        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                isAllCapital = false;
                break;
            }
        }

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if ((i == 0 && Character.isLowerCase(ch)) || (i > 0 && Character.isUpperCase(ch))) {
                firstCapital = false;
                break;
            }
        }

        return isAllCapital || firstCapital || allLowercase;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + detectCapitalUse("USA"));
        System.out.println("true ?= " + detectCapitalUse("GG"));
        System.out.println("false ?= " + detectCapitalUse("FlaG"));
        System.out.println("false ?= " + detectCapitalUse("TtTG"));
        System.out.println("true ?= " + detectCapitalUse("Leetcode"));
        System.out.println("false ?= " + detectCapitalUse("ffffffffffffffffffffF"));

        System.out.println("true ?= " + detectCapitalUse_opt("USA"));
        System.out.println("true ?= " + detectCapitalUse_opt("Leetcode"));
        System.out.println("true ?= " + detectCapitalUse_opt("leetcode"));
        System.out.println("false ?= " + detectCapitalUse_opt("FlaG"));
    }
}
