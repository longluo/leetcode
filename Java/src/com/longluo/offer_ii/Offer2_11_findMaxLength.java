package com.longluo.offer_ii;

/**
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * <p>
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <p>
 * 示例 1:
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * <p>
 * 示例 2:
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * nums[i] 不是 0 就是 1
 * <p>
 * 注意：本题与主站 525 题相同： https://leetcode-cn.com/problems/contiguous-array/
 * <p>
 * https://leetcode-cn.com/problems/A1NYOS/
 */
public class Offer2_11_findMaxLength {

    public static int findMaxLength(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                if (2 * sum == (j - i + 1)) {
                    int len = j - i + 1;
                    ans = Math.max(ans, len);
                }
            }
        }

        return ans;
    }

    public static int findMaxLength_prefix(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int n = nums.length;
        int ans = 0;
        for (int i = 0; i <= n; i++) {

        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + findMaxLength(new int[]{0, 1}));
        System.out.println("2 ?= " + findMaxLength(new int[]{0, 1, 0}));
        System.out.println("2 ?= " + findMaxLength_prefix(new int[]{0, 1, 0}));
    }
}
