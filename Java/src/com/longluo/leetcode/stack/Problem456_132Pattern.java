package com.longluo.leetcode.stack;

import com.longluo.datastructure.TreeNode;

import java.util.*;

/**
 * 456. 132 模式
 * <p>
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，
 * 并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * <p>
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * <p>
 * 示例 2：
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
 * <p>
 * 示例 3：
 * 输入：nums = [-1,3,2,0]
 * 输出：true
 * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 2 * 10^5
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * https://leetcode-cn.com/problems/132-pattern/
 */
public class Problem456_132Pattern {

    // BF time: O(n^3) space: O(1)
    // TimeOut
    public static boolean find132pattern_bf(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }

        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] < nums[k] && nums[k] < nums[j]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // BF time: O(n^2) space: O(1)
    // TimeOut
    public static boolean find132pattern_bf_opt(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }

        for (int j = 1; j < len - 1; j++) {
            int leftMin = Integer.MAX_VALUE;
            boolean leftFlag = false;
            for (int i = j - 1; i >= 0; i--) {
                if (nums[i] < nums[j]) {
                    leftFlag = true;
                    leftMin = Math.min(leftMin, nums[i]);
                }
            }

            int rightMax = Integer.MIN_VALUE;
            boolean rightFlag = false;
            for (int k = j + 1; k < len; k++) {
                if (nums[k] < nums[j]) {
                    rightFlag = true;
                    rightMax = Math.max(rightMax, nums[k]);
                }
            }

            if (leftFlag && rightFlag && leftMin < rightMax) {
                return true;
            }
        }

        return false;
    }

    // Find the Peak time: O(n) space: O(n)
    public static boolean find132pattern_map(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }

        TreeMap<Integer, Integer> rightMap = new TreeMap<>();
        for (int i = 2; i < len; i++) {
            rightMap.put(nums[i], rightMap.getOrDefault(nums[i], 0) + 1);
        }

        int leftMin = nums[0];
        for (int j = 1; j < len - 1; j++) {
            if (leftMin < nums[j]) {
                Integer numK = rightMap.ceilingKey(leftMin + 1);
                if (numK != null && numK < nums[j]) {
                    return true;
                }
            }

            leftMin = Math.min(leftMin, nums[j]);
            rightMap.put(nums[j + 1], rightMap.get(nums[j + 1]) - 1);
            if (rightMap.get(nums[j + 1]) == 0) {
                rightMap.remove(nums[j + 1]);
            }
        }

        return false;
    }

    // Stack time: O(n) space: O(n)
    public static boolean find132pattern_stack(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }

        Deque<Integer> stk = new ArrayDeque<>();
        int k = -1;
        for (int i = len - 1; i >= 0; i--) {
            if (k > -1 && nums[k] > nums[i]) {
                return true;
            }

            while (!stk.isEmpty() && nums[i] > nums[stk.peek()]) {
                k = stk.pop();
            }

            stk.push(i);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + find132pattern_bf(new int[]{1, 2, 3, 4}));

        System.out.println("true ?= " + find132pattern_bf_opt(new int[]{3, 5, 0, 3, 4}));
        System.out.println("false ?= " + find132pattern_bf_opt(new int[]{1, 2, 3, 4}));
        System.out.println("true ?= " + find132pattern_bf_opt(new int[]{3, 1, 4, 2}));

        System.out.println("true ?= " + find132pattern_map(new int[]{3, 1, 4, 2}));

        System.out.println("false ?= " + find132pattern_stack(new int[]{1, 2, 3, 4}));
        System.out.println("true ?= " + find132pattern_stack(new int[]{3, 1, 4, 2}));
        System.out.println("false ?= " + find132pattern_stack(new int[]{1, 0, 1, -4, -3}));
        System.out.println("true ?= " + find132pattern_stack(new int[]{-2, 1, 2, -2, 1, 2}));
    }
}
