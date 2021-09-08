package com.longluo.leetcode.bitmanipulation;

/**
 * 29. 两数相除
 * <p>
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * <p>
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 * <p>
 * 提示：
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是[−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回2^31 − 1。
 * <p>
 * https://leetcode-cn.com/problems/divide-two-integers/
 */
public class Problem29_divideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        long dividendLong = dividend;
        long divisorLong = divisor;

        boolean isNegative = false;
        if (dividendLong < 0 && divisorLong < 0) {
            dividendLong = -dividendLong;
            divisorLong = -divisorLong;
        } else if (dividendLong < 0 && divisorLong > 0) {
            isNegative = true;
            dividendLong = -dividendLong;
        } else if (dividendLong > 0 && divisorLong < 0) {
            isNegative = true;
            divisorLong = -divisorLong;
        }

        long ans = 0;
        while (dividendLong >= divisorLong) {
            dividendLong -= divisorLong;
            ans++;
        }

        if (isNegative) {
            ans = -ans;
        }

        if (ans > 2147483647) {
            return 2147483647;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        int val = Math.abs(-2147483648);
        System.out.println("val = " + val);
        System.out.println("2147483648 ?= " + Math.abs(-2147483648));
        System.out.println("3 ?= " + divide(10, 3));
        System.out.println("-2 ?= " + divide(7, -3));
        System.out.println("1 ?= " + divide(1, 1));
        System.out.println("2147483647 ?= " + divide(-2147483648, -1));
        System.out.println("-2147483648 ?= " + divide(-2147483648, 1));
        System.out.println("-1073741824 ?= " + divide(-2147483648, 2));
    }
}
