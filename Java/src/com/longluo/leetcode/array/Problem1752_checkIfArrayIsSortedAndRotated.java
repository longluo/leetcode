package com.longluo.leetcode.array;

import java.util.Arrays;

/**
 * 1752. 检查数组是否经排序和轮转得到
 * <p>
 * 给你一个数组 nums 。nums 的源数组中，所有元素与 nums 相同，但按非递减顺序排列。
 * <p>
 * 如果 nums 能够由源数组轮转若干位置（包括 0 个位置）得到，则返回 true ；否则，返回 false 。
 * <p>
 * 源数组中可能存在 重复项 。
 * <p>
 * 注意：我们称数组 A 在轮转 x 个位置后得到长度相同的数组 B ，当它们满足 A[i] == B[(i+x) % A.length] ，其中 % 为取余运算。
 * <p>
 * 示例 1：
 * 输入：nums = [3,4,5,1,2]
 * 输出：true
 * 解释：[1,2,3,4,5] 为有序的源数组。
 * 可以轮转 x = 3 个位置，使新数组从值为 3 的元素开始：[3,4,5,1,2] 。
 * <p>
 * 示例 2：
 * 输入：nums = [2,1,3,4]
 * 输出：false
 * 解释：源数组无法经轮转得到 nums 。
 * <p>
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：true
 * 解释：[1,2,3] 为有序的源数组。
 * 可以轮转 x = 0 个位置（即不轮转）得到 nums 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * <p>
 * https://leetcode.cn/problems/check-if-array-is-sorted-and-rotated/
 */
public class Problem1752_checkIfArrayIsSortedAndRotated {

    // BF time: O(nlogn) space: O(logn)
    public static boolean check(int[] nums) {
        int len = nums.length;

        int[] sorted = nums.clone();

        Arrays.sort(sorted);

        for (int i = 0; i < len; i++) {
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                if (nums[(j + i) % len] != sorted[j]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + check(new int[]{3, 4, 5, 1, 2}));
        System.out.println("false ?= " + check(new int[]{2, 1, 3, 4}));
    }
}
