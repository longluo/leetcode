package com.longluo.leetcode.math;

/**
 * 633. 平方数之和
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

    public static boolean judgeSquareSum(int c) {
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

    public static boolean judgeSquareSum_tp(int c) {
        int left = 0;
        int right = (int) Math.ceil(Math.sqrt(c));

        while (left <= right) {
            int sum = left * left + right * right;
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

    public static void main(String[] args) {
        System.out.println("true ?= " + judgeSquareSum(0));
        System.out.println("true ?= " + judgeSquareSum_tp(0));
        System.out.println("true ?= " + judgeSquareSum(1));
        System.out.println("true ?= " + judgeSquareSum_tp(1));
        System.out.println("true ?= " + judgeSquareSum(2));
        System.out.println("true ?= " + judgeSquareSum_tp(2));
        System.out.println("false ?= " + judgeSquareSum(3));
        System.out.println("false ?= " + judgeSquareSum_tp(3));
        System.out.println("true ?= " + judgeSquareSum(4));
        System.out.println("true ?= " + judgeSquareSum_tp(4));
        System.out.println("true ?= " + judgeSquareSum(5));
        System.out.println("true ?= " + judgeSquareSum_tp(5));
        System.out.println("true ?= " + judgeSquareSum(8));
        System.out.println("true ?= " + judgeSquareSum_tp(8));
        System.out.println("false ?= " + judgeSquareSum(999999999));
        System.out.println("false ?= " + judgeSquareSum_tp(999999999));
        System.out.println("false ?= " + judgeSquareSum(2147482647));
        System.out.println("false ?= " + judgeSquareSum_tp(2147482647));
    }
}
