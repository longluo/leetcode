package com.longluo.lcci;

/**
 * 面试题 01.09. 字符串轮转
 * <p>
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 * <p>
 * 示例1:
 * 输入：s1 = "waterbottle", s2 = "erbottlewat"
 * 输出：True
 * <p>
 * 示例2:
 * 输入：s1 = "aa", s2 = "aba"
 * 输出：False
 * <p>
 * 提示：
 * 字符串长度在[0, 100000]范围内。
 * <p>
 * 说明:
 * 你能只调用一次检查子串的方法吗？
 * <p>
 * https://leetcode.cn/problems/string-rotation-lcci/
 */
public class Lcci_01_09_stringRotation {

    // BF time: O(n^2) space: O(1)
    public static boolean isFlipedString_bf(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        int len = s1.length();

        for (int i = 0; i < len; i++) {
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                if (s1.charAt((i + j) % len) != s2.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return true;
            }
        }

        return false;
    }

    // Best time: O(n) space: O(n)
    public static boolean isFlipedString(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        String s = s2 + s2;
        return s.contains(s1);
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isFlipedString("waterbottle", "erbottlewat"));
        System.out.println("false ?= " + isFlipedString("aa", "aba"));

        System.out.println("true ?= " + isFlipedString_bf("waterbottle", "erbottlewat"));
        System.out.println("false ?= " + isFlipedString_bf("aa", "aba"));
    }
}
