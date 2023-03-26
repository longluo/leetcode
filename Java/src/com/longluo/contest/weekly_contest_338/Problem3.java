package com.longluo.contest.weekly_contest_338;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/contest/weekly-contest-338
 */

/**
 * https://leetcode.cn/problems/count-the-number-of-beautiful-subarrays/
 */
public class Problem3 {

    // BF time: O(mn) space: O(m)
    // TLE
    public static List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;

        List<Long> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            long cnt = 0;
            for (int j = 0; j < n; j++) {
                cnt += Math.abs(nums[j] - queries[i]);
            }

            ans.add(cnt);
        }

        return ans;
    }

    // PrefixSums + BinarySearch  time: O(nlogn + mlogn) space: O(n)
    public static List<Long> minOperations_opt(int[] nums, int[] queries) {
        int n = nums.length;

        Arrays.sort(nums);

        long[] prefixSums = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        List<Long> ans = new ArrayList<>();

        for (int x : queries) {
            int idx = Arrays.binarySearch(nums, x);

            long minusArea = 0;
            long plusArea = 0;

            if (idx >= 0) {
                minusArea = (long) x * idx - prefixSums[idx];
                plusArea = prefixSums[n] - prefixSums[idx] - (long) x * (n - idx);
            } else {
                minusArea = (long) x * (-idx - 1) - prefixSums[-idx - 1];
                plusArea = prefixSums[n] - prefixSums[-idx - 1] - (long) x * (n + idx + 1);
            }

            ans.add(minusArea + plusArea);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[14, 10] ?= " + minOperations(new int[]{3, 1, 6, 8}, new int[]{1, 5}));
        System.out.println("[20] ?= " + minOperations(new int[]{2, 9, 6, 3}, new int[]{10}));

        System.out.println("[14, 10] ?= " + minOperations_opt(new int[]{3, 1, 6, 8}, new int[]{1, 5}));
        System.out.println("[20] ?= " + minOperations_opt(new int[]{2, 9, 6, 3}, new int[]{10}));
    }
}