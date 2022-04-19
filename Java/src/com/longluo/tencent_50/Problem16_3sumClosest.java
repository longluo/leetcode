package com.longluo.tencent_50;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * <p>
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 示例 2：
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * <p>
 * 提示：
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -10^4 <= target <= 10^4
 * <p>
 * https://leetcode-cn.com/problems/3sum-closest/
 */
public class Problem16_3sumClosest {

    // BF time: O(n^3) space: O(1)
    public static int threeSumClosest_bf(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        int max = Integer.MAX_VALUE;
        int len = nums.length;
        int ans = target;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        return sum;
                    } else if (Math.abs(sum - target) < max) {
                        max = Math.abs(sum - target);
                        ans = sum;
                    }
                }
            }
        }

        return ans;
    }

    // Two Pointers time: O(n^2) space: O(1)
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        int len = nums.length;
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        if (nums[0] > target && target > 0) {
            return ans;
        } else if (nums[len - 1] <= target && target < 0) {
            return nums[len - 3] + nums[len - 2] + nums[len - 1];
        }

        for (int i = 0; i < len; i++) {
            if (i > 1 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }

                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else {
                    left++;
                    while (left > right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + threeSumClosest_bf(new int[]{-1, 2, 1, -4}, 1));
        System.out.println("2 ?= " + threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println("-101 ?= " + threeSumClosest(new int[]{-100, -98, -2, -1}, -101));
    }
}
