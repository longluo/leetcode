package com.longluo.lcci;

/**
 * 面试题 16.05. 阶乘尾数
 * <p>
 * 设计一个算法，算出 n 阶乘有多少个尾随零。
 * <p>
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * <p>
 * 示例 2:
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(logn)。
 */
public class Lcci_16_05_trailingZeroes {

    public static int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + trailingZeroes(3));
        System.out.println("0 ?= " + trailingZeroes(2));
        System.out.println("1 ?= " + trailingZeroes(5));
        System.out.println("1 ?= " + trailingZeroes(6));
        System.out.println("1 ?= " + trailingZeroes(1808548329));
    }
}
