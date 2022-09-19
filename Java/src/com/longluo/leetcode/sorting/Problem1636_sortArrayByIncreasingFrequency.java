package com.longluo.leetcode.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1636. 按照频率将数组升序排序
 * <p>
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * <p>
 * 请你返回排序后的数组。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 * <p>
 * 示例 2：
 * 输入：nums = [2,3,1,3,2]
 * 输出：[1,3,3,2,2]
 * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
 * <p>
 * 示例 3：
 * 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
 * 输出：[5,-1,4,4,-6,-6,1,1,1]
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 * <p>
 * https://leetcode.cn/problems/sort-array-by-increasing-frequency/
 */
public class Problem1636_sortArrayByIncreasingFrequency {

    // Sort + HashMap time: O(nlogn) space: O(n)
    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int x : nums) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }

        int len = nums.length;
        int[][] sorted = new int[len][2];
        for (int i = 0; i < len; i++) {
            sorted[i][0] = nums[i];
            sorted[i][1] = freqMap.get(nums[i]);
        }

        Arrays.sort(sorted, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o1[1] - o2[1];
        });

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = sorted[i][0];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[3,1,1,2,2,2] ?= " + Arrays.toString(frequencySort(new int[]{1, 1, 2, 2, 2, 3})));
    }
}
