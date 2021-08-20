package com.longluo.leetcode.twopointers;

/**
 * 345. 反转字符串中的元音字母
 * <p>
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1：
 * 输入："hello"
 * 输出："holle"
 * <p>
 * 示例 2：
 * 输入："leetcode"
 * 输出："leotcede"
 * <p>
 * 提示：
 * 元音字母不包含字母 "y" 。
 * <p>
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
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

    public static void main(String[] args) {
        System.out.println("holle ?= " + reverseVowels("hello"));
        System.out.println("leotcede ?= " + reverseVowels("leetcode"));
    }
}
