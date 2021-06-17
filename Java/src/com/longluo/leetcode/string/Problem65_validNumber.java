package com.longluo.leetcode.string;

/**
 * 65. 有效数字
 * <p>
 * 有效数字（按顺序）可以分成以下几个部分：
 * <p>
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 小数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分有效数字列举如下：
 * <p>
 * ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 * 部分无效数字列举如下：
 * <p>
 * ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
 * <p>
 * 示例 1：
 * 输入：s = "0"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "e"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：s = "."
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：s = ".1"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。
 * <p>
 * https://leetcode-cn.com/problems/valid-number/
 */
public class Problem65_validNumber {

    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (!isValidChar(s.charAt(i))) {
                return false;
            }
        }

        if (s.indexOf('e') == -1 && s.indexOf('E') == -1) {
            return isInteger(s) || isDecimal(s);
        }

        int eIndex = Math.max(s.indexOf('e'), s.indexOf('E'));
        String numStrBeforeE = s.substring(0, eIndex);
        String numStrAfterE = s.substring(eIndex + 1);
        if (isInteger(numStrAfterE) && (isInteger(numStrBeforeE) || isDecimal(numStrBeforeE))) {
            return true;
        }

        return false;
    }

    public static boolean isValidChar(char ch) {
        if (Character.isDigit(ch) || ch == '+' || ch == '-' || ch == 'e' || ch == 'E' || ch == '.') {
            return true;
        }

        return false;
    }

    public static boolean isDigit(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isInteger(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            return isDigit(str.substring(1));
        }

        return isDigit(str);
    }

    public static boolean isDecimal(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        int index = 0;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            index = 1;
        }

        if (index < str.length() && str.charAt(index) == '.') {
            return isDigit(str.substring(index + 1));
        }

        if (str.indexOf('.') != -1) {
            int dotPos = str.indexOf('.');
            if (dotPos == str.length() - 1) {
                return isDigit(str.substring(index, dotPos));
            }

            return isDigit(str.substring(index, dotPos)) && isDigit(str.substring(dotPos + 1));
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isNumber("0"));
        System.out.println("false ?= " + isNumber("e"));
        System.out.println("false ?= " + isNumber("."));
        System.out.println("true ?= " + isNumber(".1"));
        System.out.println("true ?= " + isNumber("0089"));
        System.out.println("true ?= " + isNumber("-0.1"));
        System.out.println("true ?= " + isNumber("+3.14"));
        System.out.println("true ?= " + isNumber("5."));
        System.out.println("true ?= " + isNumber("-.8"));
        System.out.println("true ?= " + isNumber("2e10"));
        System.out.println("true ?= " + isNumber("-90E3"));
        System.out.println("true ?= " + isNumber("3e+7"));
        System.out.println("true ?= " + isNumber("+6e-1"));
        System.out.println("true ?= " + isNumber("53.5e93"));
        System.out.println("true ?= " + isNumber("-123.456e789"));
        System.out.println("false ?= " + isNumber("abc"));
        System.out.println("false ?= " + isNumber("1a"));
        System.out.println("false ?= " + isNumber("1e"));
        System.out.println("false ?= " + isNumber("e3"));
        System.out.println("false ?= " + isNumber("e3"));
        System.out.println("false ?= " + isNumber("99e2.5"));
        System.out.println("false ?= " + isNumber("--6"));
        System.out.println("false ?= " + isNumber("-+3"));
        System.out.println("false ?= " + isNumber("95a54e53"));
        System.out.println("false ?= " + isNumber("-E3"));
    }
}
