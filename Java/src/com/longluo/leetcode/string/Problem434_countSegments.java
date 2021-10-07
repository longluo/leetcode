package com.longluo.leetcode.string;

/**
 * 434. 字符串中的单词数
 * <p>
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 * <p>
 * https://leetcode-cn.com/problems/number-of-segments-in-a-string/
 */
public class Problem434_countSegments {

    public static int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        String str = s.trim();
//        String[] strArr = s.trim().split(" ");
        if (str.length() > 0) {
            return str.split("\\s+").length;
        }

        return 0;
    }

    public static int countSegments_1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int count = 0;
        int idx = 0;
        while (idx < n) {
            while (idx < n && s.charAt(idx) == ' ') {
                idx++;
            }

            if (idx < n && s.charAt(idx) != ' ') {
                count++;

                while (idx < n && s.charAt(idx) != ' ') {
                    idx++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + countSegments(""));
        System.out.println("0 ?= " + countSegments_1(""));
        System.out.println("5 ?= " + countSegments("Hello, my name is John"));
        System.out.println("5 ?= " + countSegments_1("Hello, my name is John"));
        System.out.println("0 ?= " + countSegments("  "));
        System.out.println("0 ?= " + countSegments_1("  "));
        System.out.println("3 ?= " + countSegments_1("a, b, c"));
    }
}
