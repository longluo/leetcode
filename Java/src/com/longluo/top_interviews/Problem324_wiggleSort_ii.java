package com.longluo.top_interviews;

import java.util.Arrays;

/**
 * 324. 摆动排序 II
 * <p>
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 * <p>
 * 示例 1：
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * <p>
 * 示例 2：
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 * <p>
 * 提示：
 * 1 <= nums.length <= 5 * 10^4
 * 0 <= nums[i] <= 5000
 * 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
 * <p>
 * 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 * <p>
 * https://leetcode.com/problems/wiggle-sort-ii/
 */
public class Problem324_wiggleSort_ii {

    // Sort time: O(nlogn) space: O(n)
    public static void wiggleSort(int[] nums) {
        int len = nums.length;

        int[] sorted = new int[len];
        System.arraycopy(nums, 0, sorted, 0, len);

        Arrays.sort(sorted);

        int idx = len - 1;

        for (int i = 1; i < len; i += 2) {
            nums[i] = sorted[idx--];
        }

        for (int i = 0; i < len; i += 2) {
            nums[i] = sorted[idx--];
        }
    }

    public static void main(String[] args) {
        int[] tst1 = new int[]{1, 5, 1, 1, 6, 4};
        wiggleSort(tst1);
        System.out.println("[1,6,1,5,1,4] ?= " + Arrays.toString(tst1));

        int[] tst2 = new int[]{1, 3, 2, 2, 3, 1};
        wiggleSort(tst2);
        System.out.println("[2,3,1,3,1,2] ?= " + Arrays.toString(tst2));

        int[] tst3 = new int[]{1, 1, 2, 1, 2, 2, 1};
        wiggleSort(tst3);
        System.out.println("[1,2,1,2,1,2,1] ?= " + Arrays.toString(tst3));
    }
}
