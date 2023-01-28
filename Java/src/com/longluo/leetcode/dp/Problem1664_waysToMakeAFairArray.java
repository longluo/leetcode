package com.longluo.leetcode.dp;

/**
 * 1664. 生成平衡数组的方案数
 * <p>
 * 给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。
 * 请注意剩下元素的下标可能会因为删除操作而发生改变。
 * <p>
 * 比方说，如果 nums = [6,1,7,4,1] ，那么：
 * <p>
 * 选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
 * 选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
 * 选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
 * 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。
 * <p>
 * 请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。
 * <p>
 * 示例 1：
 * 输入：nums = [2,1,6,4]
 * 输出：1
 * 解释：
 * 删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
 * 删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
 * 删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
 * 删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
 * 只有一种让剩余数组成为平衡数组的方案。
 * <p>
 * 示例 2：
 * 输入：nums = [1,1,1]
 * 输出：3
 * 解释：你可以删除任意元素，剩余数组都是平衡数组。
 * <p>
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：0
 * 解释：不管删除哪个元素，剩下数组都不是平衡数组。
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^4
 * <p>
 * https://leetcode.cn/problems/ways-to-make-a-fair-array/
 */
public class Problem1664_waysToMakeAFairArray {

    // BF time: O(n^2) space: O(1)
    // TLE
    public static int waysToMakeFair_bf(int[] nums) {
        int ans = 0;

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int evenSum = 0;
            int oddSum = 0;

            int temp = nums[i];

            nums[i] = 0;

            for (int j = 0, idx = 0; j < len; j++) {
                if (nums[j] == 0) {
                    continue;
                }

                if (idx % 2 == 0) {
                    evenSum += nums[j];
                } else {
                    oddSum += nums[j];
                }

                idx++;
            }

            if (evenSum == oddSum) {
                ans++;
            }

            nums[i] = temp;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + waysToMakeFair_bf(new int[]{2, 1, 6, 4}));
        System.out.println("3 ?= " + waysToMakeFair_bf(new int[]{1, 1, 1}));
        System.out.println("0 ?= " + waysToMakeFair_bf(new int[]{1, 2, 3}));
    }
}
