package com.longluo.leetcode.twopointers;

/**
 * 917. 仅仅反转字母
 * <p>
 * 给你一个字符串 s ，根据下述规则反转字符串：
 * <p>
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 * <p>
 * 示例 1：
 * 输入：s = "ab-cd"
 * 输出："dc-ba"
 * <p>
 * 示例 2：
 * 输入：s = "a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * <p>
 * 示例 3：
 * 输入：s = "Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 * <p>
 * 提示
 * 1 <= s.length <= 100
 * s 仅由 ASCII 值在范围 [33, 122] 的字符组成
 * s 不含 '\"' 或 '\\'
 * <p>
 * https://leetcode-cn.com/problems/reverse-only-letters/
 */
public class Problem917_reverseOnlyLetters {

    public static String reverseOnlyLetters(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int len = s.length();
        char[] res = new char[len];
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            while (!Character.isLetter(s.charAt(left))) {
                res[left] = s.charAt(left);
                left++;
            }

            while (!Character.isLetter(s.charAt(right))) {
                res[right] = s.charAt(right);
                right--;
            }

            res[left] = s.charAt(right);
            res[right] = s.charAt(left);
            left++;
            right--;
        }

        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println("dc-ba ?= " + reverseOnlyLetters("ab-cd"));
        System.out.println("j-Ih-gfE-dCba ?= " + reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println("Qedo1ct-eeLg=ntse-T! ?= " + reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
