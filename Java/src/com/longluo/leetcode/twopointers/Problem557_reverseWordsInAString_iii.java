package com.longluo.leetcode.twopointers;

/**
 * 557. 反转字符串中的单词 III
 * <p>
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1：
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * <p>
 * 示例 2:
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 * <p>
 * 提示：
 * 1 <= s.length <= 5 * 10^4
 * s 包含可打印的 ASCII 字符。
 * s 不包含任何开头或结尾空格。
 * s 里 至少 有一个词。
 * s 中的所有单词都用一个空格隔开。
 * <p>
 * https://leetcode.cn/problems/reverse-words-in-a-string-iii/
 */
public class Problem557_reverseWordsInAString_iii {

    // BF time: O(n)  space: O(n)
    public static String reverseWords_bf(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int len = s.length();
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        while (idx < len) {
            int start = idx;

            while (idx < len && s.charAt(idx) != ' ') {
                idx++;
            }

            for (int j = idx - 1; j >= start; j--) {
                sb.append(s.charAt(j));
            }

            while (idx < len && s.charAt(idx) == ' ') {
                sb.append(" ");
                idx++;
            }
        }

        return sb.toString();
    }

    // Two Pointers time: O(n) space: O(n)
    public static String reverseWords_tp(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int n = s.length();
        char[] arr = s.toCharArray();
        int idx = 0;
        while (idx < n) {
            int start = idx;
            while (idx < n && arr[idx] != ' ') {
                idx++;
            }

            int end = idx - 1;
            while (start < end && end < n) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }

            while (idx < n && arr[idx] == ' ') {
                idx++;
            }
        }

        return new String(arr);
    }

    // Regex Reverse Word O(n) O(n)
    public static String reverseWords_regex(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        String[] words = s.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            char[] wordArr = words[i].toCharArray();
            int left = 0;
            int right = wordArr.length - 1;
            while (left < right) {
                char temp = wordArr[right];
                wordArr[right] = wordArr[left];
                wordArr[left] = temp;
                left++;
                right--;
            }
            words[i] = new String(wordArr);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    // Reverse Reverse Word Opt O(n) O(n)
    public static String reverseWords_regex_opt(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        String[] words = s.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            words[i] = sb.reverse().toString();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("doG gniD ?= " + reverseWords_bf("God Ding"));
        System.out.println("a ?= " + reverseWords_tp("a"));
        System.out.println("a b ?= " + reverseWords_tp("a b"));
        System.out.println("ab ?= " + reverseWords_tp("ab"));
        System.out.println("ab  ?= " + reverseWords_tp("ab "));
        System.out.println("ba ab ?= " + reverseWords_tp("ab ba"));
        System.out.println("cba ?= " + reverseWords_tp("abc"));
        System.out.println("s'teL ekat edoCteeL tsetnoc ?= " + reverseWords_tp("Let's take LeetCode contest"));
        System.out.println("s'teL ekat edoCteeL tsetnoc ?= " + reverseWords_regex("Let's take LeetCode contest"));
    }
}
