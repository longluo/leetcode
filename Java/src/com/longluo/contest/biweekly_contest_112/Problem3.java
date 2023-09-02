package com.longluo.contest.biweekly_contest_112;

import java.util.*;

/**
 * https://leetcode.cn/contest/biweekly-contest-112
 */
public class Problem3 {

    public static long maxSum(List<Integer> nums, int m, int k) {
        int n = nums.size();

        long max = 0;

        long sum = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            sum += nums.get(i);
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
        }

        if (map.size() >= m) {
            max = Math.max(max, sum);
        }

        int left = 0;
        int right = k;

        while (left < right && right < n) {
            map.put(nums.get(right), map.getOrDefault(nums.get(right), 0) + 1);
            sum += nums.get(right);
            if (map.get(nums.get(left)) > 1) {
                map.put(nums.get(left), map.getOrDefault(nums.get(left), 0) - 1);
            } else {
                map.remove(nums.get(left));
            }
            sum -= nums.get(left);

            if (map.size() >= m) {
                max = Math.max(max, sum);
            }

            left++;
            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        List<Integer> tst1 = new ArrayList<>();
        tst1.add(1);
        tst1.add(1);
        tst1.add(1);
        tst1.add(3);

        System.out.println("4 ?= " + maxSum(tst1, 2, 2));
    }
}
