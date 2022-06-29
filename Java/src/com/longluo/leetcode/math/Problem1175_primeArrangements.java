package com.longluo.leetcode.math;

/**
 * 1175. Prime Arrangements
 * <p>
 * Easy
 * <p>
 * Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)
 * (Recall that an integer is prime if and only if it is greater than 1, and cannot be written as a product of two positive integers both smaller than it.)
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 * <p>
 * Example 1:
 * Input: n = 5
 * Output: 12
 * Explanation: For example [1,2,5,4,3] is a valid permutation, but [5,2,3,4,1] is not because the prime number 5 is at index 1.
 * <p>
 * Example 2:
 * Input: n = 100
 * Output: 682289015
 * <p>
 * Constraints:
 * 1 <= n <= 100
 * <p>
 * https://leetcode.com/problems/prime-arrangements/
 */
public class Problem1175_primeArrangements {

    // Math time: O(n) space: O(1)
    public static int numPrimeArrangements(int n) {
        int MOD = 1_000_000_007;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                cnt++;
            }
        }

        long ans = 1;
        for (int i = 1; i <= cnt; i++) {
            ans = ans * i % MOD;
        }

        for (int i = 1; i <= (n - cnt); i++) {
            ans = ans * i % MOD;
        }

        return (int) ans;
    }

    public static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return n > 2;
    }

    public static void main(String[] args) {
        System.out.println("12 ?= " + numPrimeArrangements(5));
        System.out.println("682289015 ?= " + numPrimeArrangements(100));
    }
}
