package com.longluo.leetcode.math;

/**
 * 1780. Check if Number is a Sum of Powers of Three
 * Medium
 * Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three.
 * Otherwise, return false.
 * An integer y is a power of three if there exists an integer x such that y == 3x.
 * <p>
 * Example 1:
 * Input: n = 12
 * Output: true
 * Explanation: 12 = 3^1 + 3^2
 * <p>
 * Example 2:
 * Input: n = 91
 * Output: true
 * Explanation: 91 = 3^0 + 3^2 + 3^4
 * <p>
 * Example 3:
 * Input: n = 21
 * Output: false
 * <p>
 * Constraints:
 * 1 <= n <= 10^7
 * <p>
 * https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
 */
public class Problem1780_checkPowersOfThree {

    public static boolean checkPowersOfThree(int n) {
        int[] nums = {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969};
        int idx = nums.length - 1;
        while (idx >= 0 && n > 0) {
            while (idx >= 0 && nums[idx] > n) {
                idx--;
            }

            if (nums[idx] == n) {
                return true;
            }

            n -= nums[idx];
            idx--;
        }

        return false;
    }

    public static int powerOfThree(int n) {
        return (int) Math.pow(3, n);
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + checkPowersOfThree(1));
        System.out.println("false ?= " + checkPowersOfThree(2));
        System.out.println("true ?= " + checkPowersOfThree(3));
        System.out.println("true ?= " + checkPowersOfThree(12));
        System.out.println("false ?= " + checkPowersOfThree(21));
        System.out.println("true ?= " + checkPowersOfThree(91));

        for (int i = 0; i < 60; i++) {
            if (powerOfThree(i) <= 10000000) {
                System.out.print(powerOfThree(i) + ", ");
            }
        }
    }
}
