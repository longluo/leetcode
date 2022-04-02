package com.longluo.leetcode.string;

import java.math.BigInteger;

/**
 * 415. 字符串相加
 * <p>
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 示例 1：
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * <p>
 * 示例 2：
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * <p>
 * 示例 3：
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * <p>
 * 提示：
 * 1 <= num1.length, num2.length <= 10^4
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * <p>
 * https://leetcode-cn.com/problems/add-strings/
 */
public class Problem415_addStrings {

    // BigInteger O(?) O(1)
    public static String addStrings_bigInteger(String num1, String num2) {
        BigInteger numA = new BigInteger(num1);
        BigInteger numB = new BigInteger(num2);
        BigInteger sum = numA.add(numB);
        return sum.toString();
    }

    // Simulate O(max(len1, len2) O(1)
    public static String addStrings_bf(String num1, String num2) {
        if (num1.length() > num2.length()) {
            return addStrings_bf(num2, num1);
        }

        int lenA = num1.length();
        int lenB = num2.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder(lenA + lenB);
        for (int i = 0; i < lenA; i++) {
            int digitA = num1.charAt(lenA - 1 - i) - '0';
            int digitB = num2.charAt(lenB - 1 - i) - '0';
            int sum = digitA + digitB + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        for (int i = lenA; i < lenB; i++) {
            int digit = num2.charAt(lenB - 1 - i) - '0' + carry;
            sb.append(digit % 10);
            carry = digit / 10;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    // Two Pointers O(max(len1, len2) O(1)
    public static String addStrings_tp(String num1, String num2) {
        int p = num1.length() - 1;
        int q = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder(p + q);
        int sum = 0;
        while (p >= 0 || q >= 0) {
            if (p >= 0 && q >= 0) {
                sum = num1.charAt(p) - '0' + num2.charAt(q) - '0' + carry;
                sb.append(sum % 10);
                carry = sum / 10;
                p--;
                q--;
            } else if (p >= 0 && q < 0) {
                sum = num1.charAt(p) - '0' + carry;
                sb.append(sum % 10);
                carry = sum / 10;
                p--;
            } else if (p < 0 && q >= 0) {
                sum = num2.charAt(q) - '0' + carry;
                sb.append(sum % 10);
                carry = sum / 10;
                q--;
            }
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    // Two Pointers Opt O(max(len1, len2) O(1)
    public static String addStrings_tp_opt(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + carry;
            ans.append(result % 10);
            carry = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println("134 ?= " + addStrings_bf("11", "123"));
        System.out.println("134 ?= " + addStrings_tp("11", "123"));
        System.out.println("134 ?= " + addStrings_tp_opt("11", "123"));
    }
}
