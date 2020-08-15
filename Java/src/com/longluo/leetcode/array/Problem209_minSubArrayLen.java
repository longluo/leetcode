package com.longluo.leetcode.array;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * <p>
 * 示例：
 * <p>
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 进阶：
 * <p>
 * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class Problem209_minSubArrayLen {

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        int ans = 0x7777777F;
        for (int i = 0; i < length; i++) {
            int sum = nums[i];
            if (sum == s) {
                return 1;
            } else if (sum > s) {
                continue;
            }

            for (int j = i + 1; j < length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    if (j - i + 1 < ans) {
                        ans = j - i + 1;
                    }
                }
            }
        }

        if (ans == 0x7777777F) {
            return 0;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
