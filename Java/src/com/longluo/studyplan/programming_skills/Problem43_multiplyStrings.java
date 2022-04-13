package com.longluo.studyplan.programming_skills;

import java.math.BigInteger;

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

    // BigInteger time: O(m + n) space: O(1)
    public static String multiply_big(String num1, String num2) {
        BigInteger numA = new BigInteger(num1);
        BigInteger numB = new BigInteger(num2);
        BigInteger ans = numA.multiply(numB);
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println("56088 ?= " + multiply_big("123", "456"));

    }
}
