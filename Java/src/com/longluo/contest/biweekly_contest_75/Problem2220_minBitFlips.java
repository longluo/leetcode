package com.longluo.contest.biweekly_contest_75;

/**
 * 2220. 转换数字的最少位翻转次数
 * <p>
 * 一次 位翻转 定义为将数字 x 二进制中的一个位进行 翻转 操作，即将 0 变成 1 ，或者将 1 变成 0 。
 * <p>
 * 比方说，x = 7 ，二进制表示为 111 ，我们可以选择任意一个位（包含没有显示的前导 0 ）并进行翻转。
 * 比方说我们可以翻转最右边一位得到 110 ，或者翻转右边起第二位得到 101 ，或者翻转右边起第五位（这一位是前导 0 ）得到 10111 等等。
 * 给你两个整数 start 和 goal ，请你返回将 start 转变成 goal 的 最少位翻转 次数。
 * <p>
 * 示例 1：
 * 输入：start = 10, goal = 7
 * 输出：3
 * 解释：10 和 7 的二进制表示分别为 1010 和 0111 。我们可以通过 3 步将 10 转变成 7 ：
 * - 翻转右边起第一位得到：1010 -> 1011 。
 * - 翻转右边起第三位：1011 -> 1111 。
 * - 翻转右边起第四位：1111 -> 0111 。
 * 我们无法在 3 步内将 10 转变成 7 。所以我们返回 3 。
 * <p>
 * 示例 2：
 * 输入：start = 3, goal = 4
 * 输出：3
 * 解释：3 和 4 的二进制表示分别为 011 和 100 。我们可以通过 3 步将 3 转变成 4 ：
 * - 翻转右边起第一位：011 -> 010 。
 * - 翻转右边起第二位：010 -> 000 。
 * - 翻转右边起第三位：000 -> 100 。
 * 我们无法在 3 步内将 3 变成 4 。所以我们返回 3 。
 * <p>
 * 提示：
 * 0 <= start, goal <= 10^9
 * <p>
 * https://leetcode.cn/problems/minimum-bit-flips-to-convert-number/
 */
public class Problem2220_minBitFlips {

    // XOR time: O(32) space: O(1)
    public static int minBitFlips(int start, int goal) {
        if (start == goal) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += (start & 0x01) ^ (goal & 0x01);
            start = start >>> 1;
            goal = goal >>> 1;
        }

        return ans;
    }

    // XOR time: O(logn) space: O(1)
    public static int minBitFlips_opt(int start, int goal) {
        int ans = 0;
        int xor = start ^ goal;
        while (xor > 0) {
            ans += xor & 0x01;
            xor = xor >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + minBitFlips(10, 7));
        System.out.println("3 ?= " + minBitFlips_opt(10, 7));
    }
}
