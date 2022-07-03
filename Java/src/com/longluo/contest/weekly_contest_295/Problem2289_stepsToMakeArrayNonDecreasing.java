package com.longluo.contest.weekly_contest_295;

/**
 * 6080. 使数组按非递减顺序排列
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 。在一步操作中，移除所有满足 nums[i - 1] > nums[i] 的 nums[i] ，其中 0 < i < nums.length 。
 * <p>
 * 重复执行步骤，直到 nums 变为 非递减 数组，返回所需执行的操作数。
 * <p>
 * 示例 1：
 * 输入：nums = [5,3,4,4,7,3,6,11,8,5,11]
 * 输出：3
 * 解释：执行下述几个步骤：
 * - 步骤 1 ：[5,3,4,4,7,3,6,11,8,5,11] 变为 [5,4,4,7,6,11,11]
 * - 步骤 2 ：[5,4,4,7,6,11,11] 变为 [5,4,7,11,11]
 * - 步骤 3 ：[5,4,7,11,11] 变为 [5,7,11,11]
 * [5,7,11,11] 是一个非递减数组，因此，返回 3 。
 * <p>
 * 示例 2：
 * 输入：nums = [4,5,7,7,13]
 * 输出：0
 * 解释：nums 已经是一个非递减数组，因此，返回 0 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * <p>
 * https://leetcode.cn/problems/steps-to-make-array-non-decreasing/
 */
public class Problem2289_stepsToMakeArrayNonDecreasing {

    // TODO: 2022/5/29
    public static int totalSteps(int[] nums) {
        if (isAscendArray(nums)) {
            return 0;
        }

        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                for (int j = i + 1; j < len; j++) {
                    if (nums[j] < nums[i]) {
                        ans = Math.max(ans, j - i);
                    } else {
                        break;
                    }
                }
            }
        }

        return ans;
    }

    public static boolean isAscendArray(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + totalSteps(new int[]{5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11}));
        System.out.println("0 ?= " + totalSteps(new int[]{4, 5, 7, 7, 13}));
    }
}
