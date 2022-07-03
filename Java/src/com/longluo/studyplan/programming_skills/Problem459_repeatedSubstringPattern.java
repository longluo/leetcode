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

    // Opt time: O(n) space: O(n)
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

    // KMP
    // TODO: 2022/5/11
    public static boolean repeatedSubstringPattern_kmp(String s) {
        int len = s.length();
        if (len <= 1) {
            return false;
        }
        
        return false;
    }

    public static int kmp(String src, String pat) {
        if (pat == null || pat.length() == 0) {
            return 0;
        }

        int sLen = src.length();
        int pLen = pat.length();

        int[] next = new int[pLen];
        for (int right = 1, left = 0; right < pLen; right++) {
            while (left > 0 && pat.charAt(left) != pat.charAt(right)) {
                left = next[left - 1];
            }

            if (pat.charAt(left) == pat.charAt(right)) {
                left++;
            }

            next[right] = left;
        }

        for (int i = 0, j = 0; i < sLen; i++) {
            while (j > 0 && src.charAt(i) != pat.charAt(j)) {
                j = next[j - 1];
            }

            if (src.charAt(i) == pat.charAt(j)) {
                j++;
            }

            if (j == pLen) {
                return i - pLen + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + repeatedSubstringPattern_bf("abab"));

        System.out.println("false ?= " + repeatedSubstringPattern("a"));
        System.out.println("true ?= " + repeatedSubstringPattern("bb"));
        System.out.println("true ?= " + repeatedSubstringPattern("abab"));
        System.out.println("false ?= " + repeatedSubstringPattern("aba"));
        System.out.println("true ?= " + repeatedSubstringPattern("abcabcabcabc"));

        System.out.println("false ?= " + repeatedSubstringPattern("aba"));
        System.out.println("true ?= " + repeatedSubstringPattern_kmp("abcabcabcabc"));
        System.out.println("true ?= " + repeatedSubstringPattern_kmp("babbabbabbabbab"));
    }
}
