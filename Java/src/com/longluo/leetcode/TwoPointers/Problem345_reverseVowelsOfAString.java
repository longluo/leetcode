package com.longluo.leetcode.TwoPointers;

import java.util.HashSet;
import java.util.Set;

/**
 * 345. 反转字符串中的元音字母
 * <p>
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 * <p>
 * 示例 1：
 * 输入：s = "hello"
 * 输出："holle"
 * <p>
 * 示例 2：
 * 输入：s = "leetcode"
 * 输出："leotcede"
 * <p>
 * 提示：
 * 1 <= s.length <= 3 * 10^5
 * s 由 可打印的 ASCII 字符组成
 * <p>
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class Problem345_reverseVowelsOfAString {

    public static String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int left = 0;
        int right = s.length() - 1;
        int n = s.length();
        char[] array = s.toCharArray();
        while (left < right) {
            while (left < n && !isCharVowel(array[left])) {
                left++;
            }

            while (right > 0 && !isCharVowel(array[right])) {
                right--;
            }

            if (left < right) {
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                right--;
                left++;
            }
        }

        return new String(array);
    }

    private static boolean isCharVowel(char ch) {
        if (ch == 'A' || ch == 'a' || ch == 'E' || ch == 'e' || ch == 'I' || ch == 'i' || ch == 'O' || ch == 'o'
                || ch == 'U' || ch == 'u') {
            return true;
        }

        return false;
    }

    // Two Pointers time: O(n) space: O(n)
    public static String reverseVowels_tp(String s) {
        Set<Character> vowels = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int len = s.length();

        char[] array = s.toCharArray();

        for (int i = 0, j = len - 1; i < j; ) {
            if (!vowels.contains(array[i])) {
                i++;
                continue;
            }

            if (!vowels.contains(array[j])) {
                j--;
                continue;
            }

            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        return new String(array);
    }

    public static void main(String[] args) {
        System.out.println("holle ?= " + reverseVowels("hello"));
        System.out.println("leotcede ?= " + reverseVowels("leetcode"));

        System.out.println("holle ?= " + reverseVowels_tp("hello"));
        System.out.println("leotcede ?= " + reverseVowels_tp("leetcode"));
    }
}
