package com.longluo.top_interviews;

/**
 * 344. 反转字符串
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * <p>
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * https://leetcode.com/problems/reverse-string/
 */
public class Problem344_reverseString {

    // Two Pointers O(n) O(1)
    public static void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }

        int n = s.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }

    // Two Pointers Opt O(n) O(1)
    public static void reverseString_tp_opt(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }

        int n = s.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }

    // User Recursive O(n) O(n / 2)
    public static void reverseString_rec(char[] s) {
        reverse(s, 0, s.length - 1);
    }

    public static void reverse(char[] str, int begin, int end) {
        if (begin >= end) {
            return;
        }

        char ch = str[begin];
        str[begin] = str[end];
        str[end] = ch;

        reverse(str, begin + 1, end - 1);
    }

    public static void main(String[] args) {
        reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
        reverseString_tp_opt(new char[]{'h', 'e', 'l', 'l', 'o'});
        reverseString_rec(new char[]{'H', 'a', 'n', 'n', 'a', 'h'});
    }
}
