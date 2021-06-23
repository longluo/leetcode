package com.longluo.offer;

/**
 * 剑指 Offer 15. 二进制中1的个数
 * <p>
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，
 * 有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * <p>
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * <p>
 * 示例 2：
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * <p>
 * 示例 3：
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 * <p>
 * 提示：
 * 输入必须是长度为 32 的 二进制串。
 * <p>
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class Offer15_erJinZhiZhong1DeGeShuLcof {

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 0x01) != 0) {
                count++;
            }
            n = n >> 1;
        }

        return count;
    }

    public static int hammingWeight_2(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + hammingWeight(9));
        System.out.println("2 ?= " + hammingWeight_2(9));
        System.out.println("1 ?= " + hammingWeight(1));
        System.out.println("1 ?= " + hammingWeight_2(1));
    }
}
