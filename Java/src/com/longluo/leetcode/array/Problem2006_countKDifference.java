package com.longluo.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 2006. 差的绝对值为 K 的数对数目
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
 * <p>
 * |x| 的值定义为：
 * <p>
 * 如果 x >= 0 ，那么值为 x 。
 * 如果 x < 0 ，那么值为 -x 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,2,1], k = 1
 * 输出：4
 * 解释：差的绝对值为 1 的数对为：
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * <p>
 * 示例 2：
 * 输入：nums = [1,3], k = 3
 * 输出：0
 * 解释：没有任何数对差的绝对值为 3 。
 * <p>
 * 示例 3：
 * 输入：nums = [3,2,1,5,4], k = 2
 * 输出：3
 * 解释：差的绝对值为 2 的数对为：
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * <p>
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 1 <= k <= 99
 * <p>
 * https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k/
 */
public class Problem2006_countKDifference {

    public static int countKDifference(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int ans = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static int countKDifference_hash(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int ans = 0;
        int len = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (freq.containsKey(num + k) || freq.containsKey(num - k)) {
                ans += freq.getOrDefault(num + k, 0);
                ans += freq.getOrDefault(num - k, 0);
            }
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return ans;
    }

    public static int countKDifference_count(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int ans = 0;
        int[] array = new int[101];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num + k <= 100) {
                ans += array[num + k];
            }
            if (num - k >= 1) {
                ans += array[num - k];
            }
            array[num]++;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
