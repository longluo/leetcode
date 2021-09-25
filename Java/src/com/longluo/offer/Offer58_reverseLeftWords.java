package com.longluo.offer;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * <p>
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * <p>
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 * <p>
 * 限制：
 * 1 <= k < s.length <= 10000
 * <p>
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class Offer58_reverseLeftWords {

    public static String reverseLeftWords(String s, int k) {
        if (s == null || s.length() <= 1 || k == 0) {
            return s;
        }

        int len = s.length();
        int shift = k % len;
        if (shift == 0) {
            return s;
        }

        char[] array = s.toCharArray();
        char[] res = new char[len];
        for (int i = 0; i < len; i++) {
            res[i] = array[(i + shift) % len];
        }

        return new String(res);
    }

    public static String reverseLeftWords_1(String s, int k) {
        if (s == null || s.length() <= 1 || k == 0) {
            return s;
        }

        int len = s.length();
        String res = s.substring(k, len) + s.substring(0, k);
        return res;
    }

    public static void main(String[] args) {
        System.out.println("cdefgab ?= " + reverseLeftWords("abcdefg", 2));
        System.out.println("cdefgab ?= " + reverseLeftWords_1("abcdefg", 2));
        System.out.println("umghlrlose ?= " + reverseLeftWords("lrloseumgh", 6));
        System.out.println("umghlrlose ?= " + reverseLeftWords_1("lrloseumgh", 6));
    }
}
