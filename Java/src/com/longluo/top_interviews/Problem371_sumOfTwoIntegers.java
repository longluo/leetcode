package com.longluo.top_interviews;

/**
 * 371. 两整数之和
 * <p>
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 -，计算并返回两整数之和。
 * <p>
 * 示例 1：
 * 输入：a = 1, b = 2
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：a = 2, b = 3
 * 输出：5
 * <p>
 * 提示：
 * -1000 <= a, b <= 1000
 * <p>
 * https://leetcode.com/problems/sum-of-two-integers/
 */
public class Problem371_sumOfTwoIntegers {

    // BF time: O(1) space: O(1)
    public static int getSum_bf(int a, int b) {
        return a + b;
    }

    // Bit time: O(log(max_int)) space: O(1)
    public static int getSum_bit(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }

        return a;
    }

    // Compute time: O(log(max_int)) space: O(1)
    public static int getSum_compute(int a, int b) {
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        int lower = 0;
        int carry = 0;
        while (true) {
            lower = a ^ b;
            carry = a & b;
            if (carry == 0) {
                break;
            }

            a = lower;
            b = carry << 1;
        }

        return lower;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + getSum_bf(2, 1));
        System.out.println("3 ?= " + getSum_bit(2, 1));
        System.out.println("3 ?= " + getSum_compute(2, 1));
    }
}
