package com.longluo.leetcode.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1464. 数组中两元素的最大乘积
 * <p>
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 * 请你计算并返回该式的最大值。
 * <p>
 * 示例 1：
 * 输入：nums = [3,4,5,2]
 * 输出：12
 * 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,5,4,5]
 * 输出：16
 * 解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
 * <p>
 * 示例 3：
 * 输入：nums = [3,7]
 * 输出：12
 * <p>
 * 提示：
 * 2 <= nums.length <= 500
 * 1 <= nums[i] <= 10^3
 * <p>
 * https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/
 */
public class Problem1464_maxProduct {

    // BF time: O(n^2) space: O(1)
    public static int maxProduct_bf(int[] nums) {
        int len = nums.length;
        int maxans = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                maxans = Math.max(maxans, (nums[i] - 1) * (nums[j] - 1));
            }
        }

        return maxans;
    }

    // Sort time: O(nlogn) space: O(logn)
    public static int maxProduct_sort(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return (nums[len - 1] - 1) * (nums[len - 2] - 1);
    }

    // PQ time: O(nlogn) space: O(logn)
    public static int maxProduct_pq(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int x : nums) {
            pq.offer(x);
        }
        return (pq.poll() - 1) * (pq.poll() - 1);
    }

    public static void main(String[] args) {
        System.out.println("12 ?= " + maxProduct_bf(new int[]{3, 4, 5, 2}));
        System.out.println("12 ?= " + maxProduct_sort(new int[]{3, 4, 5, 2}));
        System.out.println("12 ?= " + maxProduct_pq(new int[]{3, 4, 5, 2}));
    }
}
