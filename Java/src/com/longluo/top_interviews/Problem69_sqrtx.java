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

    // BF O(n) O(1)
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

    // Exp O(1) O(1)
    public static int mySqrt_exp(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    // Newton's Method O(logx) O(1)
    public static int mySqrt_newton(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x;
        double x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }

        return (int) x0;
    }

    // Binary Search O(nlogn) O(1)
    public static int mySqrt_bs(int x) {
        if (x <= 1) {
            return x;
        }

        int left = 1;
        int right = x / 2;
        while (left < right) {
            int mid = left + (right - left) / 2;
            long product = (long) mid * mid;
            long bigger = (long) (mid + 1) * (mid + 1);
            if (bigger < x) {
                left = mid + 1;
            } else if (product > x) {
                right = mid;
            } else if (product <= x && x < bigger) {
                return mid;
            } else if (bigger == x) {
                return mid + 1;
            }
        }

        return left;
    }

    // Binary Search O(logx) O(1)
    public static int mySqrt_bs_opt(int x) {
        if (x <= 1) {
            return x;
        }

        int left = 1;
        int right = x / 2;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + mySqrt(0));
        System.out.println("1 ?= " + mySqrt(1));
        System.out.println("2 ?= " + mySqrt(4));
        System.out.println("2 ?= " + mySqrt(8));

        System.out.println("46340 ?= " + mySqrt(2147483647));
        System.out.println("2 ?= " + mySqrt_newton(8));

        System.out.println("2 ?= " + mySqrt_bs(8));
        System.out.println("6 ?= " + mySqrt_bs(36));
        System.out.println("6 ?= " + mySqrt_bs_opt(36));
        System.out.println("46340 ?= " + mySqrt_bs(2147483647));
    }
}
