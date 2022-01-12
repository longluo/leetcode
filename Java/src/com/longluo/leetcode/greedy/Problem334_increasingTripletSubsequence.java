package com.longluo.leetcode.greedy;

/**
 * 334. 递增的三元子序列
 * <p>
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；
 * 否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 * <p>
 * 示例 2：
 * 输入：nums = [5,4,3,2,1]
 * 输出：false
 * 解释：不存在满足题意的三元组
 * <p>
 * 示例 3：
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 * <p>
 * 提示：
 * 1 <= nums.length <= 5 * 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * <p>
 * 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？
 * <p>
 * https://leetcode-cn.com/problems/increasing-triplet-subsequence/
 */
public class Problem334_increasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] < nums[j] && nums[j] < nums[k]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean increasingTriplet_better(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] <= nums[i]) {
                    continue;
                }
                for (int k = j + 1; k < len; k++) {
                    if (nums[k] <= nums[j]) {
                        continue;
                    }
                    if (nums[i] < nums[j] && nums[j] < nums[k]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println("false ?= " + increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println("true ?= " + increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
    }
}
