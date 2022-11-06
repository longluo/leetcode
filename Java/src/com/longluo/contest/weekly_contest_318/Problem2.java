package com.longluo.contest.weekly_contest_318;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/
 */
public class Problem2 {

    // BF time: O(nk) space: O(k)
    // TLE
    public static long maximumSubarraySum_bf(int[] nums, int k) {
        int len = nums.length;

        long ans = 0;
        for (int i = 0; i <= len - k; i++) {
            long sum = 0;
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < k; j++) {
                if (set.contains(nums[i + j])) {
                    sum = 0;
                    break;
                }

                set.add(nums[i + j]);
                sum += nums[i + j];
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }

    // SlidingWindow time: O(n) space: O(k)
    public static long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;

        long ans = 0;

        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        for (int i = 0, j = 0; j <= len; j++) {
            if (j - i == k) {
                if (map.size() == k) {
                    ans = Math.max(ans, sum);
                }

                int cnt = map.getOrDefault(nums[i], 0);
                if (cnt > 1) {
                    map.put(nums[i], cnt - 1);
                } else {
                    map.remove(nums[i]);
                }
                sum -= nums[i];
                i++;
            }

            if (j == len) {
                break;
            }

            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            sum += nums[j];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("15 ?= " + maximumSubarraySum_bf(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
        System.out.println("0 ?= " + maximumSubarraySum_bf(new int[]{4, 4, 4}, 3));

        System.out.println("24 ?= " + maximumSubarraySum(new int[]{1, 1, 1, 7, 8, 9}, 3));
        System.out.println("15 ?= " + maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
        System.out.println("0 ?= " + maximumSubarraySum(new int[]{4, 4, 4}, 3));
    }
}
