package com.longluo.offer_ii;

/**
 * 剑指 Offer II 070. 排序数组中只出现一次的数字
 * <p>
 * 给定一个只包含整数的有序数组 nums，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。
 * <p>
 * 示例 1:
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 * <p>
 * 提示:
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 * <p>
 * 进阶: 采用的方案可以在 O(log n) 时间复杂度和 O(1) 空间复杂度中运行吗？
 * <p>
 * 注意：本题与主站 540 题相同：https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 * <p>
 * https://leetcode-cn.com/problems/skFtm2/
 */
public class Offer2_70_singleNonDuplicate {

    public static int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums[0];
        }

        int n = nums.length;
        int idx = 0;
        while (idx < n) {
            while (idx < n - 1 && nums[idx + 1] == nums[idx]) {
                idx += 2;
            }

            if (idx == n - 1) {
                return nums[n - 1];
            }

            if (idx < n - 1 && nums[idx + 1] > nums[idx]) {
                return nums[idx];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println("10 ?= " + singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        System.out.println("2 ?= " + singleNonDuplicate(new int[]{1, 1, 2}));
    }
}
