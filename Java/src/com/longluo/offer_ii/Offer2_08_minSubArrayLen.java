package com.longluo.offer_ii;

/**
 * 剑指 Offer II 008. 和大于等于 target 的最短子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * <p>
 * 进阶：
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 * <p>
 * 注意：本题与主站 209 题相同：https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * <p>
 * https://leetcode-cn.com/problems/2VG8Kg/
 */
public class Offer2_08_minSubArrayLen {

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            if (sum >= target) {
                ans = 1;
                break;
            }
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            ans = 0;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println("1 ?= " + minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println("0 ?= " + minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println("3 ?= " + minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }
}
