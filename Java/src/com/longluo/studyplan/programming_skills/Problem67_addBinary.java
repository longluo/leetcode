package com.longluo.studyplan.programming_skills;

/**
 * 67. 二进制求和
 * <p>
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * https://leetcode.cn/problems/add-binary/
 */
public class Problem67_addBinary {

    // Simulate time: O(m+n) space: O(m+n)
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                int sum = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
                sb.append(sum % 2);
                carry = sum / 2;

                i--;
                j--;
            } else if (i >= 0) {
                int sum = (a.charAt(i) - '0') + carry;
                sb.append(sum % 2);
                carry = sum / 2;

                i--;
            } else {
                int sum = (b.charAt(j) - '0') + carry;
                sb.append(sum % 2);
                carry = sum / 2;
                j--;
            }
        }

        if (carry > 0) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }

    // BF API time: O(n) space: O(1)
    // The Length Too long Failed
    // WA
    public static String addBinary_api(String a, String b) {
        long numA = Long.parseLong(a, 2);
        long numB = Long.parseLong(b, 2);
        return Long.toBinaryString(numA + numB);
    }

    // BF Simulate time: O(n) space: O(1)
    public static String addBinary_simu(String a, String b) {
        int p = a.length() - 1;
        int q = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (p >= 0 || q >= 0) {
            int numA = p >= 0 ? a.charAt(p) - '0' : 0;
            int numB = q >= 0 ? b.charAt(q) - '0' : 0;
            int sum = numA + numB + carry;
            carry = sum / 2;
            sb.append(sum % 2);
            p--;
            q--;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("100 ?= " + addBinary_api("11", "1"));
        System.out.println("10101 ?= " + addBinary_api("1010", "1011"));

        System.out.println("100 ?= " + addBinary_simu("11", "1"));
        System.out.println("10101 ?= " + addBinary_simu("1010", "1011"));

        System.out.println("100 ?= " + addBinary("11", "1"));
        System.out.println("11110 ?= " + addBinary("1111", "1111"));
        System.out.println("10101 ?= " + addBinary("1010", "1011"));
    }
}
