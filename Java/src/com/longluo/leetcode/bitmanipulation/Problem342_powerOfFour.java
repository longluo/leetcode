package com.longluo.leetcode.bitmanipulation;

/**
 * 342. 4的幂
 * <p>
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * <p>
 * 示例 1：
 * 输入：n = 16
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：n = 5
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：n = 1
 * 输出：true
 * <p>
 * 提示：
 * -2^31 <= n <= 2^31 - 1
 * <p>
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * <p>
 * https://leetcode-cn.com/problems/power-of-four/
 */
public class Problem342_powerOfFour {

    public static boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        }

        while (n > 1) {
            if (n % 4 != 0) {
                return false;
            }

            n /= 4;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isPowerOfFour(1));
        System.out.println("false ?= " + isPowerOfFour(5));
        System.out.println("true ?= " + isPowerOfFour(16));
    }
}
