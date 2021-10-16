package com.longluo.leetcode.string;

/**
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * 示例 1：
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * <p>
 * 示例 2：
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * <p>
 * 提示：
 * 输入的字符串长度不会超过 1000 。
 */
public class Problem647_countSubstrings {

    public static int countSubstrings(String s) {
        if (s == null) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int ans = 0;

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + countSubstrings("abc"));
        System.out.println("6 ?= " + countSubstrings("aaa"));
    }
}
