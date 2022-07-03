package com.longluo.leetcode.math;

import java.lang.reflect.Array;

/**
 * 564. 寻找最近的回文数
 * <p>
 * 给定一个表示整数的字符串 n ，返回与它最近的回文整数（不包括自身）。如果不止一个，返回较小的那个。
 * “最近的”定义为两个整数差的绝对值最小。
 * <p>
 * 示例 1:
 * 输入: n = "123"
 * 输出: "121"
 * <p>
 * 示例 2:
 * 输入: n = "1"
 * 输出: "0"
 * 解释: 0 和 2是最近的回文，但我们返回最小的，也就是 0。
 * <p>
 * 提示:
 * 1 <= n.length <= 18
 * n 只由数字组成
 * n 不含前导 0
 * n 代表在 [1, 10^18 - 1] 范围内的整数
 * <p>
 * https://leetcode-cn.com/problems/find-the-closest-palindrome/
 */
public class Problem564_findTheClosestPalindrome {

    public static String nearestPalindromic(String n) {
        int len = n.length();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = -1;
        }
        if (len <= 1) {
            int num = Integer.parseInt(n);
            return "" + (num - 1);
        }

        for (int i = 0; i < len / 2; i++) {
            int num = n.charAt(i) - '0';
            res[i] = num;
        }

        if (len % 2 == 1) {
            res[len / 2] = n.charAt(len / 2) - '0';
            for (int i = len / 2 + 1; i < len; i++) {
                int num = n.charAt(i) - '0';
                if (i == len - 1) {
                    if (res[0] < num) {
                        res[i] = res[0];
                    }
                } else {
                    if (num >= res[i - len / 2]) {
                        res[i] = res[i - len / 2];
                    } else {
                        for (int j = len / 2; j < len; i++) {
                            if (res[j] > 0) {
                                res[j] = res[j] - 1;
                            } else {

                            }
                        }
                    }
                }
            }
        } else {
            for (int i = len / 2; i < len; i++) {
                int num = n.charAt(i) - '0';
                if (i == len - 1) {
                    if (res[0] < num) {
                        res[i] = res[0];
                    } else {

                    }
                } else {
                    if (num >= res[i - len / 2]) {
                        res[i] = res[i - len / 2];
                    } else {
                        for (int j = len / 2; j < len; i++) {
                            if (res[j] > 0) {
                                res[j] = res[j] - 1;
                            } else {

                            }
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(res[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + nearestPalindromic("1"));
        System.out.println("1 ?= " + nearestPalindromic("2"));
        System.out.println("9 ?= " + nearestPalindromic("10"));
        System.out.println("9 ?= " + nearestPalindromic("11"));
        System.out.println("11 ?= " + nearestPalindromic("12"));
        System.out.println("22 ?= " + nearestPalindromic("23"));
        System.out.println("88 ?= " + nearestPalindromic("99"));
        System.out.println("99 ?= " + nearestPalindromic("100"));
        System.out.println("121 ?= " + nearestPalindromic("123"));
        System.out.println("1221 ?= " + nearestPalindromic("1213"));
    }
}
