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

    public static boolean isPerfectSquare(int num) {
        if (num <= 0) {
            return false;
        }

        double root = Math.sqrt(num);
        int res = (int) root;
        if (res == root) {
            return true;
        }

        return false;
    }

    public static boolean isPerfectSquare_n(int num) {
        for (int i = 1; i * i <= num; i++) {
            if (i * i == num) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isPerfectSquare(16));
        System.out.println("false ?= " + isPerfectSquare(14));
    }
}
