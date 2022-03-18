package com.longluo.top_interviews;

/**
 * 69. Sqrt(x)
 * Easy
 * Given a non-negative integer x, compute and return the square root of x.
 * Since the return type is an integer, the decimal digits are truncated,
 * and only the integer part of the result is returned.
 * Note: You are not allowed to use any built-in exponent function or operator,
 * such as pow(x, 0.5) or x ** 0.5.
 * <p>
 * Example 1:
 * Input: x = 4
 * Output: 2
 * <p>
 * Example 2:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 * <p>
 * Constraints:
 * 0 <= x <= 2^31 - 1
 * <p>
 * https://leetcode.com/problems/sqrtx/
 */
public class Problem69_sqrtx {

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        for (int i = 0; i < x; i++) {
            long sum = i * i;
            long bigger = (long) (i + 1) * (i + 1);
            if (sum == x) {
                return i;
            } else if (sum < x && bigger > x) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + mySqrt(0));
        System.out.println("1 ?= " + mySqrt(1));
        System.out.println("2 ?= " + mySqrt(4));
        System.out.println("2 ?= " + mySqrt(8));
        System.out.println("46340 ?= " + mySqrt(2147483647));
    }
}
