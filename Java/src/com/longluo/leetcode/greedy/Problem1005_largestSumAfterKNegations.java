package com.longluo.leetcode.greedy;

import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * <p>
 * 示例 1：
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * <p>
 * 示例 2：
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 * <p>
 * 示例 3：
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 104
 * -100 <= nums[i] <= 100
 * 1 <= k <= 104
 * <p>
 * https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/
 */
public class Problem1005_largestSumAfterKNegations {

    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                cnt++;
            }
            sum += nums[i];
        }

        for (int i = 0; i < len; i++) {
            if (cnt >= k) {
                sum += 2 * (-nums[i]);
                if (i == cnt - 1) {
                    break;
                }
            } else {

            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        System.out.println("6 ?= " + largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        System.out.println("13 ?= " + largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }
}
