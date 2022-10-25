package com.longluo.algorithm;

/**
 * Bitwise Set
 */
public class BitManipulation {

    public static int countBits(int num) {
        int ans = 0;
        while (num != 0) {
            num &= num - 1;
            ans++;
        }

        return ans;
    }

    public static int countBits_for(int num) {
        int ans = 0;
        for (int i = 0; i < 32 & num != 0; i++) {
            ans += num & 0x01;
            num = num >>> 1;
        }

        return ans;
    }

    /**
     * The Lower 1 of the bits.
     *
     * @param num
     * @return
     */
    public static int lowBit(int num) {
        return num & (-num);
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + countBits(6));
        System.out.println("2 ?= " + countBits_for(6));
        System.out.println("1 ?= " + lowBit(7));
        System.out.println("0 ?= " + lowBit(6));
        System.out.println("12 = " + Integer.toBinaryString(12) + ", lowbit(" + 12 + ") = " + lowBit(12));
        System.out.println(Integer.bitCount(60) + " ?= " + countBits(60));
    }
}
