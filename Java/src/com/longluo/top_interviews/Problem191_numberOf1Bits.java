package com.longluo.top_interviews;

/**
 * 191. Number of 1 Bits
 * <p>
 * Easy
 * <p>
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 * <p>
 * Note:
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case,
 * the input will be given as a signed integer type. It should not affect your implementation,
 * as the integer's internal binary representation is the same,
 * whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3,
 * the input represents the signed integer. -3.
 * <p>
 * Example 1:
 * Input: n = 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * Example 2:
 * <p>
 * Input: n = 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * <p>
 * Example 3:
 * Input: n = 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 * <p>
 * Constraints:
 * The input must be a binary string of length 32.
 * <p>
 * Follow up: If this function is called many times, how would you optimize it?
 * <p>
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class Problem191_numberOf1Bits {

    // Cycle time: O(k) space: O(1)
    public static int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            if ((n & 0x01) == 1) {
                cnt++;
            }

            n = n >>> 1;
        }

        return cnt;
    }

    // time: O(logn) space: O(1)
    public static int hammingWeight_log(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n & (n - 1);
            cnt++;
        }

        return cnt;
    }

    public static int hammingWeight_api(int n) {
        return Integer.bitCount(n);
    }

    public static int hammingWeight_divide(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
        return n;
    }

    public static int hammingWeight_lowbit(int n) {
        int ans = 0;
        for (int i = n; i != 0; i -= lowbit(i)) {
            ans++;
        }

        return ans;
    }

    public static int lowbit(int n) {
        return n & -n;
    }

    public static int hammingWeight_rec(int n) {
        return n == 0 ? 0 : 1 + hammingWeight_rec(n & (n - 1));
    }

    public static void main(String[] args) {
        System.out.println("1 " + Integer.toBinaryString(1 << 1));
        System.out.println("2 " + Integer.toBinaryString(1 << 2));
        System.out.println("31 " + Integer.toBinaryString(1 << 31));
        System.out.println("32 " + Integer.toBinaryString(1 << 32));

        System.out.println("1 " + Integer.toBinaryString(1 >> 1));
        System.out.println("2 " + Integer.toBinaryString(1 >> 2));
        System.out.println("31 " + Integer.toBinaryString(1 >> 31));
        System.out.println("32 " + Integer.toBinaryString(1 >> 32));

        System.out.println("0 ?= " + Integer.toBinaryString(0));
        System.out.println("1 ?= " + Integer.toBinaryString(1));
        System.out.println("-1 ?= " + Integer.toBinaryString(-1));

        System.out.println("3 ?= " + hammingWeight(11));
        System.out.println("3 ?= " + hammingWeight_api(11));
        System.out.println("3 ?= " + hammingWeight_divide(11));
        System.out.println("3 ?= " + hammingWeight_lowbit(11));
        System.out.println("3 ?= " + hammingWeight_rec(11));
        System.out.println("2 ?= " + hammingWeight_log(0b00000000000000000000000000000011));
        System.out.println("3 ?= " + hammingWeight_log(0b10000000000000000000000000000011));

        System.out.println("1 ?= " + hammingWeight_lowbit(0b100));
    }
}
