package com.longluo.leetcode.math;

/**
 * 390. 消除游戏
 * <p>
 * 列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
 * <p>
 * 从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
 * 重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
 * 不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * 给你整数 n ，返回 arr 最后剩下的数字。
 * <p>
 * 示例 1：
 * 输入：n = 9
 * 输出：6
 * 解释：
 * arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * arr = [2, 4, 6, 8]
 * arr = [2, 6]
 * arr = [6]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * <p>
 * 提示：
 * 1 <= n <= 10^9
 * <p>
 * https://leetcode-cn.com/problems/elimination-game/
 */
public class Problem390_eliminationGame {

    // BF time: O(nlogn) space: O(n)
    // Memory Out
    public static int lastRemaining_bf(int n) {
        if (n <= 2) {
            return n;
        }

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        int remain = n;
        boolean leftToRight = true;
        while (remain > 1) {
            boolean delete = true;
            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    if (nums[j] > 0) {
                        nums[j] = delete ? 0 : nums[j];
                        delete = !delete;
                    }
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    if (nums[j] > 0) {
                        nums[j] = delete ? 0 : nums[j];
                        delete = !delete;
                    }
                }
            }

            leftToRight = !leftToRight;
            remain >>= 1;
        }

        for (int x : nums) {
            if (x > 0) {
                return x;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        System.out.println(Math.log(9) / Math.log(2));

        System.out.println("1 ?= " + lastRemaining_bf(1));
        System.out.println("2 ?= " + lastRemaining_bf(2));
        System.out.println("2 ?= " + lastRemaining_bf(3));
        System.out.println("2 ?= " + lastRemaining_bf(4));
        System.out.println("2 ?= " + lastRemaining_bf(5));
        System.out.println("4 ?= " + lastRemaining_bf(6));
        System.out.println("4 ?= " + lastRemaining_bf(7));
        System.out.println("6 ?= " + lastRemaining_bf(8));
        System.out.println("6 ?= " + lastRemaining_bf(9));
        System.out.println("8 ?= " + lastRemaining_bf(10));
        System.out.println("8 ?= " + lastRemaining_bf(11));
        System.out.println("8 ?= " + lastRemaining_bf(12));
        System.out.println("8 ?= " + lastRemaining_bf(13));
        System.out.println("8 ?= " + lastRemaining_bf(14));
        System.out.println("8 ?= " + lastRemaining_bf(15));
        System.out.println("6 ?= " + lastRemaining_bf(16));
        
    }
}
