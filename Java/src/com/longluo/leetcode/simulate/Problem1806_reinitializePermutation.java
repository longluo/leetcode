package com.longluo.leetcode.simulate;

/**
 * 1806. 还原排列的最少操作步数
 * <p>
 * 给你一个偶数 n ，已知存在一个长度为 n 的排列 perm ，其中 perm[i] == i（下标 从 0 开始 计数）。
 * <p>
 * 一步操作中，你将创建一个新数组 arr ，对于每个 i ：
 * <p>
 * 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
 * 如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
 * 然后将 arr 赋值给 perm 。
 * <p>
 * 要想使 perm 回到排列初始值，至少需要执行多少步操作？返回最小的 非零 操作步数。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * 解释：最初，perm = [0,1]
 * 第 1 步操作后，perm = [0,1]
 * 所以，仅需执行 1 步操作
 * <p>
 * 示例 2：
 * 输入：n = 4
 * 输出：2
 * 解释：最初，perm = [0,1,2,3]
 * 第 1 步操作后，perm = [0,2,1,3]
 * 第 2 步操作后，perm = [0,1,2,3]
 * 所以，仅需执行 2 步操作
 * <p>
 * 示例 3：
 * 输入：n = 6
 * 输出：4
 * <p>
 * 提示：
 * 2 <= n <= 1000
 * n 是一个偶数
 * <p>
 * https://leetcode.cn/problems/minimum-number-of-operations-to-reinitialize-a-permutation/
 */
public class Problem1806_reinitializePermutation {

    // Simulate time: O(n) space: O(n)
    public static int reinitializePermutation(int n) {
        int[] perm = new int[n];

        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }

        int ans = 1;

        while (true) {
            int[] array = perm.clone();

            for (int i = 1; i < n; i++) {
                if (i % 2 == 0) {
                    array[i] = perm[i / 2];
                } else {
                    array[i] = perm[n / 2 + (i - 1) / 2];
                }
            }

            if (check(array)) {
                break;
            }

            perm = array;
            ans++;
        }

        return ans;
    }

    private static boolean check(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i != array[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + reinitializePermutation(2));
        System.out.println("2 ?= " + reinitializePermutation(4));
        System.out.println("4 ?= " + reinitializePermutation(6));
    }
}
