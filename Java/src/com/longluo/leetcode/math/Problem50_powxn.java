package com.longluo.leetcode.math;

/**
 * 50. Pow(x, n)
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 * <p>
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * <p>
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * <p>
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 提示：
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * -10^4 <= xn <= 10^4
 * <p>
 * https://leetcode-cn.com/problems/powx-n/
 */
public class Problem50_powxn {

    public static double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        } else if (x == 0) {
            return 0;
        }

        double ans = x;
        boolean isNegative = false;
        long nLong = n;
        if (nLong < 0) {
            nLong = -nLong;
            isNegative = true;
        }

        for (int i = 1; i < nLong; i++) {
            ans = ans * x;
        }

        if (isNegative) {
            ans = 1 / ans;
        }

        return ans;
    }

    //
    public static double myPow_quick(double x, int n) {
        if (n == 0) {
            return 1.0;
        } else if (n > 0) {
            return quickMul(x, n);
        } else {
            return 1.0 / quickMul(x, -n);
        }
    }

    public static double quickMul(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double y = quickMul(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }

    public static double myPow_2(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public static double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public static double myPow_3(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul_iter(x, N) : 1.0 / quickMul_iter(x, -N);
    }

    public static double quickMul_iter(double x, long N) {
        double ans = 1.0;
        double x_mul = x;
        while (N > 0) {
            if (N % 2 == 1) {
                ans = ans * x_mul;
            }

            x_mul = x_mul * x_mul;
            N /= 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1024.00000 ?= " + myPow(2.00000, 10));
        System.out.println("9.26100 ?= " + myPow(2.10000, 3));
        System.out.println("0.25000 ?= " + myPow(2.00000, -2));
    }
}
