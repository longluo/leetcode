package com.longluo.leetcode.array;

/**
 * 219. 存在重复元素 II
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 0 <= k <= 10^5
 * <p>
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 */
public class Problem219_containsDuplicate_ii {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k <= 0) {
            return false;
        }

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) {
                    if (Math.abs(i - j) <= k) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println("true ?= " + containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println("false ?= " + containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
