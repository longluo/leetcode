package com.longluo.leetcode.TwoPointers;

/**
 * 795. 区间子数组个数
 * <p>
 * 给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组，
 * 并返回满足条件的子数组的个数。
 * <p>
 * 生成的测试用例保证结果符合 32-bit 整数范围。
 * <p>
 * 示例 1：
 * 输入：nums = [2,1,4,3], left = 2, right = 3
 * 输出：3
 * 解释：满足条件的三个子数组：[2], [2, 1], [3]
 * <p>
 * 示例 2：
 * 输入：nums = [2,9,2,5,6], left = 2, right = 8
 * 输出：7
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 * 0 <= left <= right <= 10^9
 * <p>
 * https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/
 */
public class Problem795_numSubarrayBoundedMax {

    // BF time: O(n^2) space: O(1)
    // TLE
    public static int numSubarrayBoundedMax_bf(int[] nums, int left, int right) {
        int len = nums.length;

        int ans = 0;

        for (int i = 0; i < len; i++) {
            int max = nums[i];

            for (int j = i; j < len; j++) {
                max = Math.max(max, nums[j]);
                if (max >= left && max <= right) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // Two Pointers time: O(n) space: O(1)
    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int len = nums.length;

        int ans = 0;

        int start = 0;

        int p = -1;

        for (int i = 0; i < len; i++) {
            if (nums[i] > right) {
                start = i + 1;
            }

            if (nums[i] >= left) {
                p = i;
            }

            ans += p - start + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + numSubarrayBoundedMax_bf(new int[]{2, 1, 4, 3}, 2, 3));
        System.out.println("7 ?= " + numSubarrayBoundedMax_bf(new int[]{2, 9, 2, 5, 6}, 2, 8));

        System.out.println("3 ?= " + numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
        System.out.println("7 ?= " + numSubarrayBoundedMax(new int[]{2, 9, 2, 5, 6}, 2, 8));
    }
}
