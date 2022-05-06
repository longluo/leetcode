package com.longluo.top100;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * <p>
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * <p>
 * 示例 2:
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * <p>
 * 提示：
 * 2 <= nums.length <= 10^5
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 * <p>
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * <p>
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 */
public class Problem238_productOfArrayExceptSelf {

    // BF time: O(n^2) space: O(1)
    // TimeOut
    public static int[] productExceptSelf_bf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int product = 1;
            for (int j = 0; j < i; j++) {
                product *= nums[j];
            }
            for (int j = i + 1; j < len; j++) {
                product *= nums[j];
            }

            ans[i] = product;
        }

        return ans;
    }

    // Prefix time: O(3 * n) = O(n) space: O(n)
    public static int[] productExceptSelf_prefix(int[] nums) {
        int len = nums.length;

        int[] left = new int[len + 1];
        int[] right = new int[len + 1];

        left[0] = 1;
        // Left[i] = nums[0] * nums[1] ... nums[i]
        for (int i = 0; i < len; i++) {
            left[i + 1] = nums[i] * left[i];
        }
        right[len] = 1;
        // right[i] = nums[len - 1] * nums[len - 2] ... nums[i]
        for (int i = len - 1; i >= 0; i--) {
            right[i] = nums[i] * right[i + 1];
        }

        int[] ans = new int[len];
        ans[0] = right[1];
        ans[len - 1] = left[len - 1];
        for (int i = 1; i < len - 1; i++) {
            ans[i] = left[i] * right[i + 1];
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println("[24,12,8,6] ?= " + Arrays.toString(productExceptSelf_bf(new int[]{1, 2, 3, 4})));
        System.out.println("[0,0,9,0,0] ?= " + Arrays.toString(productExceptSelf_bf(new int[]{-1, 1, 0, -3, 3})));

        System.out.println("[12,16,24,48,24] ?= " + Arrays.toString(productExceptSelf_prefix(new int[]{4, 3, 2, 1, 2})));
        System.out.println("[24,12,8,6] ?= " + Arrays.toString(productExceptSelf_prefix(new int[]{1, 2, 3, 4})));
        System.out.println("[0,0,9,0,0] ?= " + Arrays.toString(productExceptSelf_prefix(new int[]{-1, 1, 0, -3, 3})));
    }
}
