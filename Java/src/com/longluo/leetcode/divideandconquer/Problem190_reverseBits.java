package com.longluo.leetcode.divideandconquer;

/**
 * 190. Reverse Bits
 * <p>
 * Easy
 * <p>
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * Note:
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case,
 * both input and output will be given as a signed integer type. They should not affect your implementation,
 * as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore,
 * in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 * <p>
 * Example 1:
 * Input: n = 00000010100101000001111010011100
 * Output:    964176192 (00111001011110000010100101000000)
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596,
 * so return 964176192 which its binary representation is 00111001011110000010100101000000.
 * <p>
 * Example 2:
 * Input: n = 11111111111111111111111111111101
 * Output:   3221225471 (10111111111111111111111111111111)
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293,
 * so return 3221225471 which its binary representation is 10111111111111111111111111111111.
 * <p>
 * Constraints:
 * The input must be a binary string of length 32
 * <p>
 * Follow up: If this function is called many times, how would you optimize it?
 * <p>
 * https://leetcode.com/problems/reverse-bits/
 */
public class Problem190_reverseBits {

    public static int reverseBits_fail(int n) {
        String str = Integer.toBinaryString(n);
        int len = str.length();
        char[] array = new char[32];
        for (int i = 0; i < len; i++) {
            array[32 - len + i] = str.charAt(i);
        }
        int left = 0;
        int right = 31;
        while (left < right) {
            char ch = array[left];
            array[left] = array[right];
            array[right] = ch;
            left++;
            right--;
        }

        String res = new String(array);
        return Integer.valueOf(res, 2);
    }

    public static int reverseBits_fast(int n) {
        return Integer.reverse(n);
    }

    public static int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32 & n != 0; i++) {
            ans = ans | ((n & 0x01) << (31 - i));
            n = n >>> 1;
        }

        return ans;
    }

    private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

    public static int reverseBits_divide(int n) {
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;

        return n >>> 16 | n << 16;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(0b00000000000000000000000000000001 << 32) + ", " + (0b01 << 31));
        System.out.println(Integer.toBinaryString(0b00000000000000000000000000000001 << 31) + ", " + (0b01 << 31));
        System.out.println(Integer.toBinaryString(0b00000000000000000000000000000001 << 16));
        System.out.println(Integer.toBinaryString(0b00000000000000000000000000000001 << 15));

        System.out.println("3221225472 (11000000000000000000000000000000) ?= " + reverseBits(0b11));
        System.out.println("3221225472 (11000000000000000000000000000000) ?= " + reverseBits_fast(0b11));

        System.out.println("964176192 (00111001011110000010100101000000) ?= " + reverseBits(0b00000010100101000001111010011100));
    }
}
