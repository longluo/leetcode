package com.longluo.leetcode.stringmatching;

/**
 * 459. 重复的子字符串
 * <p>
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * <p>
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 * <p>
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * <p>
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 */
public class Problem459_repeatedSubstringPattern {

    public static boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int n = s.length();
        for (int i = 1; i < n; i++) {
            if (n % i != 0) {
                continue;
            }

            boolean flag = true;
            int cycle = n / i;
            for (int j = 0; j < cycle; j++) {
                for (int k = 0; k < i; k++) {
                    if (s.charAt(i * j + k) != s.charAt(k)) {
                        flag = false;
                        break;
                    }
                }

                if (!flag) {
                    break;
                }
            }

            if (flag) {
                return true;
            }
        }

        return false;
    }

    public static boolean repeatedSubstringPattern_1(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int n = s.length();
        for (int i = 1; i < n; i++) {
            if (n % i != 0) {
                continue;
            }

            boolean flag = true;
            int cycle = n / i;
            for (int j = 1; j < cycle; j++) {
                for (int k = 0; k < i; k++) {
                    if (s.charAt(i * j + k) != s.charAt(k)) {
                        flag = false;
                        break;
                    }
                }

                if (!flag) {
                    break;
                }
            }

            if (flag) {
                return true;
            }
        }

        return false;
    }

    public static boolean repeatedSubstringPattern_2(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + repeatedSubstringPattern("a"));
        System.out.println("true ?= " + repeatedSubstringPattern("bb"));
        System.out.println("true ?= " + repeatedSubstringPattern("abab"));
        System.out.println("false ?= " + repeatedSubstringPattern("aba"));
        System.out.println("false ?= " + repeatedSubstringPattern_1("aba"));
        System.out.println("true ?= " + repeatedSubstringPattern("abcabcabcabc"));
        System.out.println("true ?= " + repeatedSubstringPattern_1("abcabcabcabc"));
    }
}
