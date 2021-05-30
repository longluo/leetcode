package com.longluo.leetcode.bitmanipulation;

/**
 * 231. 2 的幂
 * <p>
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 * <p>
 * 示例 1：
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 * <p>
 * 示例 2：
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 * <p>
 * 示例 3：
 * 输入：n = 3
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：n = 4
 * 输出：true
 * <p>
 * 示例 5：
 * 输入：n = 5
 * 输出：false
 * <p>
 * 提示：
 * -2^31 <= n <= 2^31 - 1
 * <p>
 * 进阶：你能够不使用循环/递归解决此问题吗？
 * <p>
 * https://leetcode-cn.com/problems/power-of-two/
 */
public class Problem231_powerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        }

        while (n > 1) {
            if (n % 2 > 0) {
                return false;
            }
            n /= 2;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isPowerOfTwo(1));
        System.out.println("false ?= " + isPowerOfTwo(3));
        System.out.println("false ?= " + isPowerOfTwo(5));
        System.out.println("true ?= " + isPowerOfTwo(16));
    }
}
