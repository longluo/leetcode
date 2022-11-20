package com.longluo.contest.weekly_contest_320;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.cn/contest/weekly-contest-320
 */
public class Problem1 {

    // BF time: O(n^3) space: O(1)
    public static int unequalTriplets(int[] nums) {
        int len = nums.length;

        int ans = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    // Sort time: O(n^3) space: O(logn)
    public static int unequalTriplets_opt(int[] nums) {
        Arrays.sort(nums);

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    continue;
                }

                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] == nums[j]) {
                        continue;
                    }

                    ans++;
                }
            }
        }

        return ans;
    }

    // TreeMap/HashMap time: O(n) space: O(n)
    public static int unequalTriplets_best(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int ans = 0;

        int left = 0;
        int right = nums.length;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int cnt = entry.getValue();

            right -= cnt;
            ans += left * cnt * right;
            left += cnt;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + unequalTriplets(new int[]{4, 4, 2, 4, 3}));
        System.out.println("3 ?= " + unequalTriplets_opt(new int[]{4, 4, 2, 4, 3}));
        System.out.println("3 ?= " + unequalTriplets_best(new int[]{4, 4, 2, 4, 3}));
    }
}
