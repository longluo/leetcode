package com.longluo.leetcode.greedy;

/**
 * 1328. 破坏回文串
 * <p>
 * 给你一个由小写英文字母组成的回文字符串 palindrome ，请你将其中 一个 字符用任意小写英文字母替换，使得结果字符串的 字典序最小 ，
 * 且 不是 回文串。
 * <p>
 * 请你返回结果字符串。如果无法做到，则返回一个 空串 。
 * <p>
 * 如果两个字符串长度相同，那么字符串 a 字典序比字符串 b 小可以这样定义：在 a 和 b 出现不同的第一个位置上，
 * 字符串 a 中的字符严格小于 b 中的对应字符。例如，"abcc” 字典序比 "abcd" 小，因为不同的第一个位置是在第四个字符，
 * 显然 'c' 比 'd' 小。
 * <p>
 * 示例 1：
 * 输入：palindrome = "abccba"
 * 输出："aaccba"
 * 解释：存在多种方法可以使 "abccba" 不是回文，例如 "zbccba", "aaccba", 和 "abacba" 。
 * 在所有方法中，"aaccba" 的字典序最小。
 * <p>
 * 示例 2：
 * 输入：palindrome = "a"
 * 输出：""
 * 解释：不存在替换一个字符使 "a" 变成非回文的方法，所以返回空字符串。
 * <p>
 * 提示：
 * 1 <= palindrome.length <= 1000
 * palindrome 只包含小写英文字母。
 * <p>
 * https://leetcode.cn/problems/break-a-palindrome/
 */
public class Problem1328_breakAPalindrome {

    // Greedy time: O(n) space: O(n)
    public static String breakPalindrome(String palindrome) {
        if (palindrome == null || palindrome.length() <= 1) {
            return "";
        }

        int len = palindrome.length();
        char[] array = palindrome.toCharArray();
        for (int i = 0; i < len; i++) {
            if (i == len - 1 && array[i] == 'a') {
                array[i] = (char) ('a' + 1);
            } else if (array[i] > 'a') {
                if (len % 2 != 0 && i == len / 2 && array[i - 1] == 'a') {
                    continue;
                }

                array[i] = 'a';
                break;
            }
        }

        return new String(array);
    }

    // Opt time: O(n) space: O(n)
    public static String breakPalindrome_opt(String palindrome) {
        if (palindrome == null || palindrome.length() <= 1) {
            return "";
        }

        int len = palindrome.length();
        char[] array = palindrome.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            if (array[i] > 'a') {
                array[i] = 'a';
                return new String(array);
            }
        }

        array[len - 1] = 'b';

        return new String(array);
    }

    public static void main(String[] args) {
        System.out.println(" ?= " + breakPalindrome("a"));
        System.out.println(" ?= " + breakPalindrome("b"));
        System.out.println("ab ?= " + breakPalindrome("aa"));
        System.out.println("ab ?= " + breakPalindrome("bb"));
        System.out.println("abb ?= " + breakPalindrome("aba"));
        System.out.println("aabab ?= " + breakPalindrome("aabaa"));
        System.out.println("aaccba ?= " + breakPalindrome("abccba"));

        System.out.println("aaccba ?= " + breakPalindrome_opt("abccba"));
    }
}
