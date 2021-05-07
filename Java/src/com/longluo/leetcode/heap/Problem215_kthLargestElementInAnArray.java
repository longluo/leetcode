package com.longluo.leetcode.heap;

import java.util.*;

/**
 * 215. 数组中的第K个最大元素
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第k个最大的元素，而不是第k个不同的元素。
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class Problem215_kthLargestElementInAnArray {

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println("4 ?= " + findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
