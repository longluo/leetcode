package com.longluo.offer_ii;

/**
 * 剑指 Offer II 002. 二进制加法
 * <p>
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * 输入: a = "11", b = "10"
 * 输出: "101"
 * <p>
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * <p>
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/
 * <p>
 * https://leetcode-cn.com/problems/JFETK5/
 */
public class Offer2_02_addBinary {

    public static String addBinary(String a, String b) {
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        int lenA = arrA.length;
        int lenB = arrB.length;
        int i = lenA - 1;
        int j = lenB - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int tempA = 0;
            int tempB = 0;
            if (i >= 0) {
                tempA = arrA[i] - '0';
                i--;
            }
            if (j >= 0) {
                tempB = arrB[j] - '0';
                j--;
            }
            int sum = tempA + tempB + carry;
            if (sum == 2) {
                carry = 1;
                sum = 0;
            } else if (sum == 3) {
                carry = 1;
                sum = 1;
            } else {
                carry = 0;
            }

            sb.append(sum);
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("101 ?= " + addBinary("11", "10"));
        System.out.println("10101 ?= " + addBinary("1010", "1011"));
        System.out.println("1000 ?= " + addBinary("1", "111"));
    }
}
