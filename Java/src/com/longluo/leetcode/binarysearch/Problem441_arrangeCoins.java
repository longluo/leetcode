package com.longluo.leetcode.binarysearch;

/**
 * 441. 排列硬币
 * <p>
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。
 * 阶梯的最后一行 可能 是不完整的。
 * <p>
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 * <p>
 * 示例 1：
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 * <p>
 * 示例 2：
 * 输入：n = 8
 * 输出：3
 * 解释：因为第四行不完整，所以返回 3 。
 * <p>
 * 提示：
 * 1 <= n <= 2^31 - 1
 * <p>
 * https://leetcode-cn.com/problems/arranging-coins/
 */
public class Problem441_arrangeCoins {

    // BF O(logn) O(1)
    public static int arrangeCoins_bf(int n) {
        int ans = 1;
        while (n >= ans) {
            n -= ans;
            ans++;
        }

        return ans - 1;
    }

    // BS O(logn) O(1)
    public static int arrangeCoins_bs(int n) {
        long left = 1;
        long right = ((long) n + 1) / 2;
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            long sum = mid * (mid + 1) / 2;
            if (sum <= n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return (int) left;
    }

    // Math O(1) O(1)
    public int arrangeCoins_math(int n) {
        int val = (int) (Math.sqrt((long) 8 * n + 1) - 1);
        return val / 2;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + arrangeCoins_bf(1));
        System.out.println("2 ?= " + arrangeCoins_bf(3));
        System.out.println("3 ?= " + arrangeCoins_bf(8));

        System.out.println("1 ?= " + arrangeCoins_bs(1));
        System.out.println("2 ?= " + arrangeCoins_bs(3));
        System.out.println("3 ?= " + arrangeCoins_bs(8));
        System.out.println("65535 ?= " + arrangeCoins_bs(2147483647));

        System.out.println((Integer.MAX_VALUE + 1) / 2);
    }
}
