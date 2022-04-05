package com.longluo.leetcode.bitmanipulation;

/**
 * 762. 二进制表示中质数个计算置位
 * <p>
 * 给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。
 * 计算置位位数 就是二进制表示中 1 的个数。
 * 例如， 21 的二进制表示 10101 有 3 个计算置位。
 * <p>
 * 示例 1：
 * 输入：left = 6, right = 10
 * 输出：4
 * 解释：
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 * 共计 4 个计算置位为质数的数字。
 * <p>
 * 示例 2：
 * 输入：left = 10, right = 15
 * 输出：5
 * 解释：
 * 10 -> 1010 (2 个计算置位, 2 是质数)
 * 11 -> 1011 (3 个计算置位, 3 是质数)
 * 12 -> 1100 (2 个计算置位, 2 是质数)
 * 13 -> 1101 (3 个计算置位, 3 是质数)
 * 14 -> 1110 (3 个计算置位, 3 是质数)
 * 15 -> 1111 (4 个计算置位, 4 不是质数)
 * 共计 5 个计算置位为质数的数字。
 * <p>
 * 提示：
 * 1 <= left <= right <= 10^6
 * 0 <= right - left <= 10^4
 * <p>
 * https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
 */
public class Problem762_countPrimeSetBits {

    // BF time: O(n^2) space: O(1)
    public static int countPrimeSetBits_bf(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            int cnt = 0;
            int num = i;
            for (int j = 0; j < 32 && num != 0; j++) {
                cnt += num & 0x01;
                num = num >>> 1;
            }

            if (isPrime(cnt)) {
                ans++;
            }
        }

        return ans;
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + countPrimeSetBits_bf(6, 10));
        System.out.println("5 ?= " + countPrimeSetBits_bf(10, 15));
    }
}
