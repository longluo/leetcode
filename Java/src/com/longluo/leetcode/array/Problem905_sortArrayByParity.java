package com.longluo.leetcode.array;

import java.util.Arrays;

/**
 * 905. 按奇偶排序数组
 * <p>
 * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 * 返回满足此条件的 任一数组 作为答案。
 * <p>
 * 示例 1：
 * 输入：nums = [3,1,2,4]
 * 输出：[2,4,3,1]
 * 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[0]
 * s
 * 提示：
 * 1 <= nums.length <= 5000
 * 0 <= nums[i] <= 5000
 * <p>
 * https://leetcode-cn.com/problems/sort-array-by-parity/
 */
public class Problem905_sortArrayByParity {

    // BF time: O(2 * n) space: O(n)
    public static int[] sortArrayByParity_bf(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int len = nums.length;
        int[] ans = new int[len];
        int idx = 0;
        for (int j = 0; j < len; j++) {
            if (nums[j] % 2 == 0) {
                ans[idx++] = nums[j];
            }
        }

        for (int j = 0; j < len; j++) {
            if (nums[j] % 2 == 1) {
                ans[idx++] = nums[j];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[2,4,3,1] ?= " + Arrays.toString(sortArrayByParity_bf(new int[]{3, 1, 2, 4})));
    }
}
