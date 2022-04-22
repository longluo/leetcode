package com.longluo.studyplan.binary_search;

/**
 * 540. 有序数组中的单一元素
 * <p>
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 * 请你找出并返回只出现一次的那个数。
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
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
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 */
public class Problem540_singleElementInASortedArray {

    // BF time: O(n) space: O(1)
    public static int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums[0];
        }

        int len = nums.length;
        for (int i = 0; i < len; i += 2) {
            if (i == len - 1) {
                return nums[len - 1];
            } else if (i + 1 < len && nums[i + 1] != nums[i]) {
                return nums[i];
            }
        }

        return nums[0];
    }

    // BF Opt time: O(n) space: O(1)
    public static int singleNonDuplicate_opt(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i += 2) {
            if (nums[i + 1] != nums[i]) {
                return nums[i];
            }
        }

        return nums[len - 1];
    }

    // XOR Bit time: O(n) space: O(1)
    public static int singleNonDuplicate_bit(int[] nums) {
        int len = nums.length;
        int xor = 0;
        for (int i = 0; i < len; i++) {
            xor = xor ^ nums[i];
        }

        return xor;
    }

    // BinarySearch time: O(logn) space: O(1)
    public static int singleNonDuplicate_bs(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums[0];
        }

        int ans = 0;
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + singleNonDuplicate(new int[]{1, 1, 2}));
        System.out.println("2 ?= " + singleNonDuplicate_opt(new int[]{1, 1, 2}));
        System.out.println("2 ?= " + singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println("2 ?= " + singleNonDuplicate_bit(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println("10 ?= " + singleNonDuplicate_bs(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }
}
