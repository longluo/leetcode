package com.longluo.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 * <p>
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
 * 提示:
 * 1 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * https://leetcode.com/problems/next-greater-element-ii/
 */
public class Problem503_nextGreaterElements {

    // BF time: O(n^2) space: O(1)
    public static int[] nextGreaterElements_bf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int len = nums.length;

        int[] ans = new int[len];

        Arrays.fill(ans, -1);

        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if (nums[(i + j) % len] > nums[i]) {
                    ans[i] = nums[(i + j) % len];
                    break;
                }
            }
        }

        return ans;
    }

    public static int[] nextGreaterElements_stack(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 2 * len - 1; i++) {
            while (!st.empty() && nums[st.peek()] < nums[i % len]) {
                ans[st.pop()] = nums[i % len];
            }

            st.push(i % len);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[-1] ?= " + Arrays.toString(nextGreaterElements_bf(new int[]{1})));
        System.out.println("[2, -1, 2] ?= " + Arrays.toString(nextGreaterElements_bf(new int[]{1, 2, 1})));

        System.out.println("[-1] ?= " + Arrays.toString(nextGreaterElements_stack(new int[]{1})));
        System.out.println("[2, -1, 2] ?= " + Arrays.toString(nextGreaterElements_stack(new int[]{1, 2, 1})));
    }
}
