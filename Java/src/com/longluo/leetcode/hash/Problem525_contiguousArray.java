package com.longluo.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * <p>
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <p>
 * 示例 1:
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * <p>
 * 示例 2:
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * nums[i] 不是 0 就是 1
 * <p>
 * https://leetcode-cn.com/problems/contiguous-array/
 */
public class Problem525_contiguousArray {

    // BF time: O(n^2) space: O(1)
    public static int findMaxLength(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int ans = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int zeroCnt = 0;
            int oneCnt = 0;
            for (int j = i; j < len; j++) {
                zeroCnt += nums[j] == 0 ? 1 : 0;
                oneCnt += nums[j] == 1 ? 1 : 0;

                if (zeroCnt == oneCnt) {
                    ans = Math.max(ans, 2 * zeroCnt);
                }
            }
        }

        return ans;
    }

    // PrefixSum + HashMap time: O(n) space: O(n)
    public static int findMaxLength_hash(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int ans = 0;
        int len = nums.length;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        int sum = 0;
        prefixMap.put(0, -1);
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                sum++;
            } else {
                sum--;
            }

            if (prefixMap.containsKey(sum)) {
                int prevIndex = prefixMap.get(sum);
                ans = Math.max(ans, i - prevIndex);
            } else {
                prefixMap.put(sum, i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + findMaxLength(new int[]{0, 1}));
        System.out.println("2 ?= " + findMaxLength_hash(new int[]{0, 1}));
        System.out.println("2 ?= " + findMaxLength(new int[]{0, 1, 0}));
        System.out.println("2 ?= " + findMaxLength_hash(new int[]{0, 1, 0}));
        System.out.println("4 ?= " + findMaxLength(new int[]{0, 1, 0, 1}));
        System.out.println("4 ?= " + findMaxLength_hash(new int[]{0, 1, 0, 1}));
        System.out.println("6 ?= " + findMaxLength_hash(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
    }
}
