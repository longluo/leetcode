package com.longluo.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 1658. 将 x 减到 0 的最小操作数
 * <p>
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。
 * 请注意，需要 修改 数组以供接下来的操作使用。
 * <p>
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 * <p>
 * 示例 2：
 * 输入：nums = [5,6,7,8,9], x = 4
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：nums = [3,2,20,1,1,3], x = 10
 * 输出：5
 * 解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^4
 * 1 <= x <= 10^9
 * <p>
 * https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/
 */
public class Problem1658_minOperations {

    // PrefixSums + HashMap time: O(n) space: O(n)
    public static int minOperations_hashmap(int[] nums, int x) {
        int len = nums.length;
        int target = -x;

        for (int num : nums) {
            target += num;
        }

        if (target == 0) {
            return len;
        }

        int maxLen = -1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                maxLen = Math.max(maxLen, i - map.get(sum - target));
            }

            map.put(sum, i);
        }

        return maxLen == -1 ? -1 : len - maxLen;
    }

    // SlidingWindow time: O(n) space: O(1)
    public static int minOperations(int[] nums, int x) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int maxLen = -1;
        int left = 0;
        int right = 0;
        int currSum = 0;
        while (left < len) {
            if (right < len) {
                currSum += nums[right];
                right++;
            }

            while (currSum > sum - x && left < len) {
                currSum -= nums[left];
                left++;
            }

            if (currSum == sum - x) {
                maxLen = Math.max(maxLen, right - left);
            }

            if (right == len) {
                left++;
            }
        }

        return maxLen == -1 ? -1 : len - maxLen;
    }

    public static void main(String[] args) {
        System.out.println("-1 ?= " + minOperations(new int[]{1, 1}, 3));
        System.out.println("2 ?= " + minOperations(new int[]{1, 1, 4, 2, 3}, 5));
        System.out.println("5 ?= " + minOperations(new int[]{10, 1, 1, 1, 1, 1}, 5));
        System.out.println("-1 ?= " + minOperations(new int[]{5, 6, 7, 8, 9}, 4));
        System.out.println("5 ?= " + minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));

        System.out.println("1 ?= " + minOperations_hashmap(new int[]{5, 2, 3, 1, 1}, 5));
        System.out.println("-1 ?= " + minOperations_hashmap(new int[]{5, 6, 7, 8, 9}, 4));
        System.out.println("5 ?= " + minOperations_hashmap(new int[]{3, 2, 20, 1, 1, 3}, 10));
    }
}
