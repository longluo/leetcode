package com.longluo.leetcode.prefixsum;

/**
 * 1413. 逐步求和得到正数的最小值
 * <p>
 * 给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
 * 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
 * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
 * <p>
 * 示例 1：
 * 输入：nums = [-3,2,-3,4,2]
 * 输出：5
 * 解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
 * 累加求和
 * startValue = 4 | startValue = 5 | nums
 * (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
 * (1 +2 ) = 3  | (2 +2 ) = 4    |   2
 * (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
 * (0 +4 ) = 4  | (1 +4 ) = 5    |   4
 * (4 +2 ) = 6  | (5 +2 ) = 7    |   2
 * <p>
 * 示例 2：
 * 输入：nums = [1,2]
 * 输出：1
 * 解释：最小的 startValue 需要是正数。
 * <p>
 * 示例 3：
 * 输入：nums = [1,-2,-3]
 * 输出：5
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 * <p>
 * https://leetcode-cn.com/problems/minimum-value-to-get-positive-step-by-step-sum/
 */
public class Problem1413_minStartValue {

    public static int minStartValue(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 1;
        }

        int ans = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 1) {
                ans = Math.max(ans, 1 - sum);
            }
        }

        if (ans < 1) {
            return 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + minStartValue(new int[]{-3, 2, -3, 4, 2}));
        System.out.println("1 ?= " + minStartValue(new int[]{1, 2}));
        System.out.println("5 ?= " + minStartValue(new int[]{1, -2, -3}));
    }
}
