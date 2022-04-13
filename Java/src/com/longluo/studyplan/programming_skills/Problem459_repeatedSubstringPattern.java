package com.longluo.studyplan.programming_skills;

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

    // Substring time: O(n) space: O(n)
    public static boolean repeatedSubstringPattern_bf(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }

        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            if (len % i != 0) {
                continue;
            }

            String subStr = s.substring(0, i);
            boolean flag = true;
            for (int j = i; j < len; j += i) {
                String str = s.substring(j, j + i);
                if (!str.equals(subStr)) {
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

    // BF Cycle check time: O(n^2) space: O(1)
    public static boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }

        int len = s.length();
        for (int i = 1; i < len; i++) {
            if (len % i != 0) {
                continue;
            }

            boolean flag = true;
            int cycle = len / i;
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

    public static boolean repeatedSubstringPattern_opt(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }

        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            if (len % i == 0) {
                boolean match = true;
                for (int j = i; j < len; j++) {
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

    // TODO: 2022/4/13 KMP
    
    public static void main(String[] args) {
        System.out.println("true ?= " + repeatedSubstringPattern_bf("abab"));

        System.out.println("false ?= " + repeatedSubstringPattern("a"));
        System.out.println("true ?= " + repeatedSubstringPattern("bb"));
        System.out.println("true ?= " + repeatedSubstringPattern("abab"));
        System.out.println("false ?= " + repeatedSubstringPattern("aba"));
        System.out.println("true ?= " + repeatedSubstringPattern("abcabcabcabc"));
    }
}
