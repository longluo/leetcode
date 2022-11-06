package com.longluo.contest.weekly_contest_318;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-318/
 */

/**
 * https://leetcode.cn/problems/apply-operations-to-an-array/
 */
public class Problem1 {

    // Simulate time: O(n) space: O(n)
    public static int[] applyOperations(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] += nums[i];
                nums[i + 1] = 0;
            }
        }

        int[] ans = new int[len];
        for (int i = 0, j = 0; i < len; i++) {
            if (nums[i] != 0) {
                ans[j] = nums[i];
                j++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[1, 4, 2, 0, 0, 0] ?= " + Arrays.toString(applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
        System.out.println("[1694, 399, 832, 1758, 412, 206, 272, 0, 0, 0, 0, 0, 0, 0] ?= " + Arrays.toString(applyOperations(new int[]{847, 847, 0, 0, 0, 399, 416, 416, 879, 879, 206, 206, 206, 272})));
    }
}
