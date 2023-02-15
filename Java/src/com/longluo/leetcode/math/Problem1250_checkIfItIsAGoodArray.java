package com.longluo.leetcode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1250. 检查「好数组」
 * <p>
 * 给你一个正整数数组 nums，你需要从中任选一些子集，然后将子集中每一个数乘以一个 任意整数，并求出他们的和。
 * 假如该和结果为 1，那么原数组就是一个「好数组」，则返回 True；否则请返回 False。
 * <p>
 * 示例 1：
 * 输入：nums = [12,5,7,23]
 * 输出：true
 * 解释：挑选数字 5 和 7。
 * 5*3 + 7*(-2) = 1
 * <p>
 * 示例 2：
 * 输入：nums = [29,6,10]
 * 输出：true
 * 解释：挑选数字 29, 6 和 10。
 * 29*1 + 6*(-3) + 10*(-1) = 1
 * <p>
 * 示例 3：
 * 输入：nums = [3,6]
 * 输出：false
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * <p>
 * https://leetcode.cn/problems/check-if-it-is-a-good-array/
 */
public class Problem1250_checkIfItIsAGoodArray {

    // Math time: O(nlogn + n^2) space: O(n)
    public static boolean isGoodArray_bf(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        if (Math.abs(nums[0]) == 1) {
            return true;
        }

        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= nums[0]; i++) {
            if (nums[0] % i == 0) {
                factors.add(i);
            }
        }

        for (int x : factors) {
            boolean flag = true;
            for (int i = 1; i < n; i++) {
                if (nums[i] % x != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isGoodArray_bf(new int[]{12, 5, 7, 23}));
        System.out.println("true ?= " + isGoodArray_bf(new int[]{29, 6, 10}));
        System.out.println("false ?= " + isGoodArray_bf(new int[]{3, 6}));
        System.out.println("true ?= " + isGoodArray_bf(new int[]{6, 10, 15}));
        System.out.println("false ?= " + isGoodArray_bf(new int[]{18, 18, 18, 15, 54, 45, 45, 45}));
    }
}
