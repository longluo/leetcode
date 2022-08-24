package com.longluo.top_interviews;

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
 * https://leetcode.com/problems/power-of-three/
 */
public class Problem326_powerOfThree {

    // BF time: O(logn) space: O(1)
    public static boolean isPowerOfThree_bf(int n) {
        if (n <= 0) {
            return false;
        }

        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }

            n /= 3;
        }

        return true;
    }

    // Recursion
    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else if (n == 2) {
            return false;
        }

        if (n % 3 == 0) {
            return isPowerOfThree(n / 3);
        } else {
            return false;
        }
    }

    // Divide time: O(logn) space: O(1)
    public static boolean isPowerOfThree_opt(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    //
    public static boolean isPowerOfThree_fast(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    // Table time: O(1) space: O(1)
    public static boolean isPowerOfThree_table(int n) {
        int[] nums = {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n) {
                return true;
            }
        }

        return false;
    }

    public static boolean isPowerOfThree_set(int n) {
        if (n == 1 || n == 3 || n == 9 || n == 27 || n == 81 || n == 243 || n == 729 || n == 2187 || n == 6561 || n == 19683 || n == 59049 || n == 177147 || n == 531441 || n == 1594323 || n == 4782969 || n == 14348907 || n == 43046721 || n == 129140163 || n == 387420489 || n == 1162261467) {
            return true;
        }

        return false;
    }

    // Table time: O(1) space: O(1)
    public static boolean isPowerOfThree_swith(int n) {
        switch (n) {
            case 1:
            case 3:
            case 9:
            case 27:
            case 81:
            case 243:
            case 729:
            case 2187:
            case 6561:
            case 19683:
            case 59049:
            case 177147:
            case 531441:
            case 1594323:
            case 4782969:
            case 14348907:
            case 43046721:
            case 129140163:
            case 387420489:
            case 1162261467:
                return true;

            default:
                return false;
        }
    }

    public static int powerOfThree(int n) {
        return (int) Math.pow(3, n);
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + isPowerOfThree_bf(0));
        System.out.println("false ?= " + isPowerOfThree_opt(0));
        System.out.println("true ?= " + isPowerOfThree_table(1));
        System.out.println("true ?= " + isPowerOfThree_set(3));
        System.out.println("false ?= " + isPowerOfThree_swith(6));
        System.out.println("true ?= " + isPowerOfThree_fast(9));
        System.out.println("true ?= " + isPowerOfThree(3));
        System.out.println("false ?= " + isPowerOfThree(45));

        for (int i = 0; i < 10000; i++) {
            if (powerOfThree(i) < Integer.MAX_VALUE) {
                System.out.print(powerOfThree(i) + ", ");
            }
        }
    }
}
