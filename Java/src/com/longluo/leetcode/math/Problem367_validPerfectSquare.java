package com.longluo.leetcode.math;

/**
 * 367. 有效的完全平方数
 * <p>
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 * <p>
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 * <p>
 * 提示：
 * 1 <= num <= 2^31 - 1
 * <p>
 * https://leetcode-cn.com/problems/valid-perfect-square/
 */
public class Problem367_validPerfectSquare {

    // Use Math.sqrt O(logn) O(1)
    public static boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        double root = Math.sqrt(num);
        return (int) root == root;
    }

    public static boolean isPerfectSquare_sqrt(int num) {
        int x = (int) Math.sqrt(num);
        return x * x == num;
    }

    // BF O(n) O(1)
    public static boolean isPerfectSquare_bf(int num) {
        if (num < 0) {
            return false;
        }

        for (int i = 0; i <= (num + 1) / 2; i++) {
            long square = (long) i * i;
            if (square > num) {
                break;
            }
            if (square == num) {
                return true;
            }
        }

        return false;
    }

    // BF While O(sqrt(n)) O(1)
    public static boolean isPerfectSquare_bf_while(int num) {
        if (num < 0) {
            return false;
        }

        int x = 1;
        while (x <= (num + 1) / 2) {
            if (x * x == num) {
                return true;
            }

            x++;
        }

        return false;
    }

    // Binary Search O(logn) O(1)
    public static boolean isPerfectSquare_bs_2(int num) {
        int left = 1;
        int right = (num + 1) / 2;
        while (left < right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square <= num) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left * left == num;
    }

    public static boolean isPerfectSquare_bs(int num) {
        if (num < 0) {
            return false;
        }

        int low = 1;
        int high = (num + 1) / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid;
            if (square == num) {
                return true;
            } else if (square > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    // Math O(sqrt(N)) O(1)
    public static boolean isPerfectSquare_math(int num) {
        int x = 1;
        while (num > 0) {
            num -= x;
            x += 2;
        }

        return num == 0;
    }

    // Newton O(logx) O(1)
    public static boolean isPerfectSquare_newton(int num) {
        double C = num;
        double x0 = C;
        while (true) {
            double x1 = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - x1) < 1e-6) {
                break;
            }
            x0 = x1;
        }

        int x = (int) x0;
        return x * x == num;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isPerfectSquare(16));
        System.out.println("true ?= " + isPerfectSquare_bs(16));
        System.out.println("false ?= " + isPerfectSquare_bs(5));
        System.out.println("false ?= " + isPerfectSquare_bs(14));
        System.out.println("true ?= " + isPerfectSquare_bs(1));
        System.out.println("true ?= " + isPerfectSquare_bs(808201));
        System.out.println("false ?= " + isPerfectSquare(14));
        System.out.println("false ?= " + isPerfectSquare_bs(14));

        System.out.println("true ?= " + isPerfectSquare_newton(1));
        System.out.println("false ?= " + isPerfectSquare_newton(5));
        System.out.println("true ?= " + isPerfectSquare_newton(16));
    }
}
