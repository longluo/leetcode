package com.longluo.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * <p>
 * 注意: 输入数组的长度不会超过 10000。
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

    public static int[] nextGreaterElements_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int length = nums.length;
        int[] ans = new int[length];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 2 * length - 1; i++) {
            while (!st.empty() && nums[st.peek()] < nums[i % length]) {
                ans[st.pop()] = nums[i % length];
            }

            st.push(i % length);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[-1] ?= " + Arrays.toString(nextGreaterElements(new int[]{1})));
        System.out.println("[2, -1, 2] ?= " + Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));

        System.out.println("[-1] ?= " + Arrays.toString(nextGreaterElements_2(new int[]{1})));
        System.out.println("[2, -1, 2] ?= " + Arrays.toString(nextGreaterElements_2(new int[]{1, 2, 1})));
    }
}
