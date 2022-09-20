package com.longluo.contest.biweekly_contest_86;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1 {

    // HashMap time: O(n) space: O(n)
    public static boolean findSubarrays(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (map.containsValue(sum)) {
                return true;
            }

            map.put(i, sum);
        }

        return false;
    }

    // HashSet time: O(n) space: O(n)
    public static boolean findSubarrays_set(int[] nums) {
        int len = nums.length;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < len - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (!set.add(sum)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + findSubarrays(new int[]{4, 2, 4}));
        System.out.println("true ?= " + findSubarrays_set(new int[]{4, 2, 4}));
    }
}
