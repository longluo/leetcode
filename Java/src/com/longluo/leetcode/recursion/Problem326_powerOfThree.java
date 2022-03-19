package com.longluo.leetcode.recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * 326. 3的幂
 * <p>
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * <p>
 * 示例 1：
 * 输入：n = 27
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：n = 0
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：n = 9
 * 输出：true
 * <p>
 * 示例 4：
 * 输入：n = 45
 * 输出：false
 * <p>
 * 提示：
 * -2^31 <= n <= 2^31 - 1
 * <p>
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * <p>
 * https://leetcode-cn.com/problems/power-of-three/
 * <p>
 * https://leetcode.com/problems/power-of-three/
 */
public class Problem326_powerOfThree {

    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        }

        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }

            n /= 3;
        }

        return true;
    }

    /**
     * Recursive
     */
    public static boolean isPowerOfThree_rec(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else if (n == 2) {
            return false;
        }

        if (n % 3 == 0) {
            return isPowerOfThree_rec(n / 3);
        } else {
            return false;
        }
    }

    public static boolean isPowerOfThree_fast(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static boolean isPowerOfThree_table(int n) {
        if (n <= 0) {
            return false;
        }

        int[] nums = {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n) {
                return true;
            }
        }

        return false;
    }

    public static int powerOfThree(int n) {
        return (int) Math.pow(3, n);
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + isPowerOfThree(0));
        System.out.println("true ?= " + isPowerOfThree(1));
        System.out.println("true ?= " + isPowerOfThree(3));
        System.out.println("false ?= " + isPowerOfThree(6));
        System.out.println("true ?= " + isPowerOfThree(9));
        System.out.println("true ?= " + isPowerOfThree(27));
        System.out.println("false ?= " + isPowerOfThree(45));
        System.out.println("true ?= " + isPowerOfThree_rec(3));
        System.out.println("false ?= " + isPowerOfThree_rec(45));

        for (int i = 0; i < 10000; i++) {
            if (powerOfThree(i) < Integer.MAX_VALUE) {
                System.out.print(powerOfThree(i) + ", ");
            }
        }
    }
}
