package com.longluo.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 416. 分割等和子集
 * <p>
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * <p>
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class Problem416_partitionEqualSubsetSum {

    // Backtracking time: O(2^n) space: O(n)
    // TimeOut
    public static boolean canPartition_bt(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }

        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        if (sum % 2 == 1) {
            return false;
        }

        return backtrack(nums, new ArrayList<>(), 0, sum / 2);
    }

    public static boolean backtrack(int[] nums, List<Integer> list, int idx, int remain) {
        if (remain == 0) {
            return true;
        }

        boolean flag = false;
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] > remain) {
                continue;
            }

            list.add(nums[i]);
            flag = backtrack(nums, list, i + 1, remain - nums[i]);
            if (flag) {
                break;
            }
            list.remove(list.size() - 1);
        }

        return flag;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + canPartition_bt(new int[]{1, 5, 11, 5}));
        System.out.println("false ?= " + canPartition_bt(new int[]{1, 2, 3, 5}));
    }
}
