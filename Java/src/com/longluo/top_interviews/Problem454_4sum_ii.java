package com.longluo.top_interviews;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 * <p>
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * <p>
 * 示例 2：
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1
 * <p>
 * 提示：
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28
 * <p>
 * https://leetcode.com/problems/4sum-ii/
 */
public class Problem454_4sum_ii {

    // BF time: O(n^4) space: O(1)
    public static int fourSumCount_bf(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                for (int k = 0; k < nums3.length; k++) {
                    for (int l = 0; l < nums4.length; l++) {
                        if (nums1[i] + nums2[j] == -nums3[k] - nums4[l]) {
                            ans++;
                        }
                    }
                }
            }
        }

        return ans;
    }

    // Hash time: O(n^3) space: O(n)
    public static int fourSumCount_tp(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        int len = nums1.length;
        Map<Integer, Integer> map4 = new HashMap<>();
        for (int num : nums4) {
            map4.put(num, map4.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    long sum = nums1[i] + nums2[j] + nums3[k];
                    int target = (int) (-sum);
                    if (map4.containsKey(target)) {
                        ans += map4.get(target);
                    }
                }
            }
        }

        return ans;
    }

    // Hash time: O(n^3) space: O(4*n)
    public static int fourSumCount_hash(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        int len = nums1.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Map<Integer, Integer> map3 = new HashMap<>();
        Map<Integer, Integer> map4 = new HashMap<>();

        for (int i = 0; i < len; i++) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
            map3.put(nums3[i], map3.getOrDefault(nums3[i], 0) + 1);
            map4.put(nums4[i], map4.getOrDefault(nums4[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry1 : map1.entrySet()) {
            for (Map.Entry<Integer, Integer> entry2 : map2.entrySet()) {
                for (Map.Entry<Integer, Integer> entry3 : map3.entrySet()) {
                    long sum = entry1.getKey() + entry2.getKey() + entry3.getKey();
                    int target = (int) -sum;
                    if (map4.containsKey(target)) {
                        ans += entry1.getValue() * entry2.getValue() * entry3.getValue() * map4.get(target);
                    }
                }
            }
        }

        return ans;
    }

    // Hash time: O(n^2) space: O(n^2)
    public static int fourSumCount_hash_opt(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        Map<Integer, Integer> mapAB = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                mapAB.put(num1 + num2, mapAB.getOrDefault(num1 + num2, 0) + 1);
            }
        }

        for (int num3 : nums3) {
            for (int num4 : nums4) {
                if (mapAB.containsKey(-num3 - num4)) {
                    ans += mapAB.get(-num3 - num4);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + fourSumCount_bf(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
        System.out.println("2 ?= " + fourSumCount_tp(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
        System.out.println("2 ?= " + fourSumCount_hash_opt(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
}
