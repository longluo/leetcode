package com.longluo.leetcode.stack;

import java.util.Arrays;

/**
 *
 */
public class Problem503_nextGreaterElements {

    public static int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i + j < nums.length) {
                    if (nums[i + j] > nums[i]) {
                        ans[i] = nums[i + j];
                        break;
                    }
                } else {
                    if (nums[(i + j) % nums.length] > nums[i]) {
                        ans[i] = nums[(i + j) % nums.length];
                        break;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[2, -1, 2] ?= " + Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println("[-1] ?= " + Arrays.toString(nextGreaterElements(new int[]{1})));
    }
}
