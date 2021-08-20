package com.longluo.leetcode.twopointers;

/**
 * 541. 反转字符串 II
 * <p>
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * <p>
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * <p>
 * 提示：
 * 1 <= s.length <= 10^4
 * s 仅由小写英文组成
 * 1 <= k <= 10^4
 * <p>
 * https://leetcode-cn.com/problems/reverse-string-ii/
 */
public class Problem541_reverseString_ii {

    public static String reverseStr(String s, int k) {
        if (s == null || s.length() <= 1 || k <= 1) {
            return s;
        }

        int n = s.length();
        char[] arr = s.toCharArray();
        int cycle = n / (2 * k);
        for (int i = 0; i <= cycle; i++) {
            int left = i * 2 * k >= n - 1 ? n - 1 : i * 2 * k;
            int right = left + k - 1 >= n - 1 ? n - 1 : left + k - 1;
            while (left < right && right < n) {
                char temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
                right--;
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println("a ?= " + reverseStr("a", 1));
        System.out.println("ab ?= " + reverseStr("ab", 1));
        System.out.println("bacdfeg ?= " + reverseStr("abcdefg", 2));
        System.out.println("bacd ?= " + reverseStr("abcd", 2));
        System.out.println("cbacdefg ?= " + reverseStr("abcdefg", 3));
        System.out.println("gfedcba ?= " + reverseStr("abcdefg", 8));
    }
}
