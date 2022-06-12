package com.longluo.leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1695. 删除子数组的最大得分
 * <p>
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 * <p>
 * 返回 只删除一个 子数组可获得的 最大得分 。
 * <p>
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 * <p>
 * 示例 1：
 * 输入：nums = [4,2,4,5,6]
 * 输出：17
 * 解释：最优子数组是 [2,4,5,6]
 * <p>
 * 示例 2：
 * 输入：nums = [5,2,1,2,5,2,1,2,5]
 * 输出：8
 * 解释：最优子数组是 [5,2,1] 或 [1,2,5]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^4
 * <p>
 * https://leetcode.cn/problems/maximum-erasure-value/
 */
public class Problem1695_maximumErasureValue {

    // HashSet + SlidingWin time: O(n) space: O(n)
    public static int maximumUniqueSubarray(int[] nums) {
        int len = nums.length;
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int sum = 0;
        while (left <= right && right < len) {
            while (right < len && !set.contains(nums[right])) {
                set.add(nums[right]);
                sum += nums[right];
                right++;
            }

            ans = Math.max(ans, sum);

            while (left < right && right < len && set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
        }

        return ans;
    }

    // SlidingWin better time: O(n) space: O(n)
    public static int maximumUniqueSubarray_win(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int sum = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                sum += nums[i];
                max = Math.max(max, sum);
            } else {
                while (nums[j] != nums[i]) {
                    set.remove(nums[j]);
                    sum -= nums[j];
                    j++;
                }
                j++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("17 ?= " + maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
        System.out.println("8 ?= " + maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));

        System.out.println("8 ?= " + maximumUniqueSubarray_win(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));
    }
}
