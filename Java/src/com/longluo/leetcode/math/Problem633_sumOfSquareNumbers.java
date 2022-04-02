package com.longluo.leetcode.math;

/**
 * 633. 平方数之和
 * <p>
 * 给定一个非负整数c，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c 。
 * <p>
 * 示例 1：
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * <p>
 * 示例 2：
 * 输入：c = 3
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：c = 4
 * 输出：true
 * <p>
 * 示例 4：
 * 输入：c = 2
 * 输出：true
 * <p>
 * 示例 5：
 * 输入：c = 1
 * 输出：true
 * <p>
 * 提示：
 * 0 <= c <= 2^31 - 1
 * <p>
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 */
public class Problem633_sumOfSquareNumbers {

    // Math.sqrt time: O(sqrt(n)) space: O(1)
    public static boolean judgeSquareSum_sqrt(int c) {
        if (c < 0) {
            return false;
        } else if (c <= 2) {
            return true;
        }

        for (long i = 0; i * i <= c; i++) {
            double j = Math.sqrt(c - i * i);
            if (j == (int) j) {
                return true;
            }
        }

        return false;
    }

    // Math.sqrt time: O(sqrt(n)) space: O(1)
    public static boolean judgeSquareSum_sqrt_opt(int c) {
        if (c < 0) {
            return false;
        } else if (c <= 2) {
            return true;
        }

        for (long i = 0; i * i <= c; i++) {
            int remain = (int) Math.sqrt(c - i * i);
            if (remain * remain == c - i * i) {
                return true;
            }
        }

        return false;
    }

    // BF Sqrt
    public static boolean judgeSquareSum_bf_sqrt_opt(int c) {
        if (c < 0) {
            return false;
        } else if (c <= 2) {
            return true;
        }

        int rightMargin = (int) (Math.sqrt(0.5) * Math.sqrt(c));
        for (long i = 0; i <= rightMargin; i++) {
            double remain = Math.sqrt(c - i * i);
            if ((int) remain == remain) {
                return true;
            }
        }

        return false;
    }

    // Two Pointers time: O(sqrt(n)) space: O(1)
    public static boolean judgeSquareSum_tp(int c) {
        long left = 0;
        long right = (int) Math.ceil(Math.sqrt(c));
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum > c) {
                right--;
            } else if (sum < c) {
                left++;
            } else {
                return true;
            }
        }

        return false;
    }

    // BS time: O(sqrt(n)) space: O(1)
    public static boolean judgeSquareSum_bs(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        long mid = left + (right - left) / 2;
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
                if (left * left + mid * mid > c) {
                    right = mid - 1;
                }
            } else {
                left++;
            }

            mid = left + (right - left) / 2;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + judgeSquareSum_sqrt(0));
        System.out.println("true ?= " + judgeSquareSum_sqrt_opt(8));
        System.out.println("true ?= " + judgeSquareSum_tp(0));
        System.out.println("true ?= " + judgeSquareSum_sqrt(1));
        System.out.println("true ?= " + judgeSquareSum_tp(1));
        System.out.println("true ?= " + judgeSquareSum_sqrt(2));
        System.out.println("true ?= " + judgeSquareSum_tp(2));
        System.out.println("false ?= " + judgeSquareSum_sqrt(3));
        System.out.println("false ?= " + judgeSquareSum_tp(3));
        System.out.println("true ?= " + judgeSquareSum_sqrt(4));
        System.out.println("true ?= " + judgeSquareSum_tp(4));
        System.out.println("true ?= " + judgeSquareSum_sqrt(5));
        System.out.println("true ?= " + judgeSquareSum_tp(5));
        System.out.println("true ?= " + judgeSquareSum_sqrt(8));
        System.out.println("true ?= " + judgeSquareSum_tp(8));
        System.out.println("false ?= " + judgeSquareSum_sqrt(999999999));
        System.out.println("false ?= " + judgeSquareSum_tp(999999999));
        System.out.println("false ?= " + judgeSquareSum_sqrt(2147482647));
        System.out.println("false ?= " + judgeSquareSum_tp(2147482647));
    }
}
