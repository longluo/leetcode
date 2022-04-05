package com.longluo.leetcode.math;

/**
 * 650. 2 Keys Keyboard
 * Medium
 * There is only one character 'A' on the screen of a notepad.
 * You can perform two operations on this notepad for each step:
 * Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
 * Paste: You can paste the characters which are copied last time.
 * Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.
 * <p>
 * Example 1:
 * Input: n = 3
 * Output: 3
 * Explanation: Intitally, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 * <p>
 * Example 2:
 * Input: n = 1
 * Output: 0
 * <p>
 * Constraints:
 * 1 <= n <= 1000
 * <p>
 * https://leetcode.com/problems/2-keys-keyboard/
 */
public class Problem650_2_Keys_Keyboard {

    public static int minSteps(int n) {
        int ans = 0;
        for (int i = 2; i * i <= n; ++i) {
            while (n % i == 0) {
                n /= i;
                ans += i;
            }
        }
        if (n > 1) {
            ans += n;
        }

        return ans;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + minSteps(1));
        System.out.println("2 ?= " + minSteps(2));
        System.out.println("3 ?= " + minSteps(3));
        System.out.println("4 ?= " + minSteps(4));
        System.out.println("5 ?= " + minSteps(5));
        System.out.println("5 ?= " + minSteps(6));
        System.out.println("7 ?= " + minSteps(7));
        System.out.println("6 ?= " + minSteps(8));
        System.out.println("6 ?= " + minSteps(9));
        System.out.println("7 ?= " + minSteps(10));
    }
}
