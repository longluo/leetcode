package com.longluo.leetcode.dp;

import java.util.Arrays;

/**
 * 413. 等差数列划分
 * <p>
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * 子数组 是数组中的一个连续序列。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 * <p>
 * 示例 2：
 * 输入：nums = [1]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 * <p>
 * https://leetcode-cn.com/problems/arithmetic-slices/
 */
public class Problem413_arithmeticSlices {

    // DP
    public static int numberOfArithmeticSlices_bf(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int ans = 0;
        int maxDiff = nums[len - 1] - nums[0];
        for (int i = 0; i <= maxDiff; i++) {

        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
