package com.longluo.top100;

/**
 * 461. 汉明距离
 * <p>
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 * 示例 1：
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * <p>
 * 示例 2：
 * 输入：x = 3, y = 1
 * 输出：1
 * <p>
 * 提示：
 * 0 <= x, y <= 2^31 - 1
 * <p>
 * https://leetcode-cn.com/problems/hamming-distance/
 */
public class Problem461_hammingDistance {

    // BF time: O(32) space: O(1)
    public static int hammingDistance_bf(int x, int y) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += (x & 0x01) ^ (y & 0x01);
            x >>= 1;
            y >>= 1;
        }

        return ans;
    }

    // XOR time: O(32) space: O(1)
    public static int hammingDistance_xor(int x, int y) {
        int ans = 0;
        int res = x ^ y;
        for (int i = 0; i < 32; i++) {
            ans += res & 0x01;
            res >>= 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + hammingDistance_bf(3, 1));
        System.out.println("2 ?= " + hammingDistance_bf(1, 4));
        System.out.println("2 ?= " + hammingDistance_xor(1, 4));
    }
}
