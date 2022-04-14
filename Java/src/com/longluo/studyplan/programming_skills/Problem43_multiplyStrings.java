package com.longluo.studyplan.programming_skills;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 43. 字符串相乘
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 提示：
 * 1 <= num1.length, num2.length <= 200
 * num1 和 num2 只能由数字组成。
 * num1 和 num2 都不包含任何前导零，除了数字0本身。
 * <p>
 * https://leetcode-cn.com/problems/multiply-strings/
 */
public class Problem43_multiplyStrings {

    // BigInteger time: O(m * n) space: O(m + n)
    public static String multiply_big(String num1, String num2) {
        BigInteger numA = new BigInteger(num1);
        BigInteger numB = new BigInteger(num2);
        BigInteger ans = numA.multiply(numB);
        return ans.toString();
    }

    // Simulate time: O(m * n) space: O(m + n)
    public static String multiply_simu(String num1, String num2) {
        int lenA = num1.length();
        int lenB = num2.length();
        if (lenA == 0 || lenB == 0) {
            return "0";
        }

        int[] res = new int[lenA + lenB];
        int p = 0;
        int q = 0;
        for (int i = lenA - 1; i >= 0; i--) {
            int carry = 0;
            int numA = num1.charAt(i) - '0';
            q = 0;
            for (int j = lenB - 1; j >= 0; j--) {
                int numB = num2.charAt(j) - '0';
                int sum = numA * numB + res[p + q] + carry;
                res[p + q] = sum % 10;
                carry = sum / 10;
                q++;
            }

            if (carry > 0) {
                res[p + q] += carry;
            }
            p++;
        }

        int len = res.length - 1;
        while (len >= 0 && res[len] == 0) {
            len--;
        }

        if (len == -1) {
            return "0";
        }

        StringBuilder sb = new StringBuilder(len);
        while (len >= 0) {
            sb.append(res[len]);
            len--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("56088 ?= " + multiply_big("123", "456"));
        System.out.println("56088 ?= " + multiply_simu("123", "456"));
        System.out.println("0 ?= " + multiply_simu("0", "0"));
    }
}
