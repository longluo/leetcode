package com.longluo.leetcode.bitmanipulation;

/**
 * 421. 数组中两个数的最大异或值
 * <p>
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 * <p>
 * 示例 1：
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：nums = [2,4]
 * 输出：6
 * <p>
 * 示例 4：
 * 输入：nums = [8,10,2]
 * 输出：10
 * <p>
 * 示例 5：
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 * <p>
 * 提示：
 * 1 <= nums.length <= 2 * 10^4
 * 0 <= nums[i] <= 2^31 - 1
 * <p>
 * https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
 */
public class Problem421_maximumXorOfTwoNumbersInAnArray {

    public static int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                ans = Math.max(ans, nums[i] ^ nums[j]);
            }
        }

        return ans;
    }

    public static int findMaximumXOR_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        /**
         *  pre[i]: num[0] ^ ... num[i]
         */
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] ^ nums[i];
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, pre[i] ^ nums[i] ^ pre[i - 1]);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("28 ?= " + findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
        System.out.println("28 ?= " + findMaximumXOR_2(new int[]{3, 10, 5, 25, 2, 8}));
        System.out.println("0 ?= " + findMaximumXOR(new int[]{0}));
        System.out.println("0 ?= " + findMaximumXOR_2(new int[]{0}));
        System.out.println("6 ?= " + findMaximumXOR(new int[]{2, 4}));
        System.out.println("6 ?= " + findMaximumXOR_2(new int[]{2, 4}));
        System.out.println("10 ?= " + findMaximumXOR(new int[]{8, 10, 2}));
        System.out.println("10 ?= " + findMaximumXOR_2(new int[]{8, 10, 2}));
        System.out.println("127 ?= " + findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}));
        System.out.println("127 ?= " + findMaximumXOR_2(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}));
    }
}
