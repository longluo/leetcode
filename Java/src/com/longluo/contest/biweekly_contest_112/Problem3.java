package com.longluo.contest.biweekly_contest_112;

import java.util.*;

/**
 * https://leetcode.cn/contest/biweekly-contest-112
 */
public class Problem3 {

    public static long maxSum(List<Integer> nums, int m, int k) {
        int n = nums.size();

        Map<Integer, Integer> countMap = new HashMap<>();

        long sum = 0;

        for (int i = 0; i < k; i++) {
            int value = nums.get(i);
            sum += value;
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        }

        long ans = 0;

        if (countMap.size() >= m) {
            ans = Math.max(ans, sum);
        }

        int left = 0;
        int right = k;

        while (left < right && right < n) {
            int rVal = nums.get(right);

            countMap.put(rVal, countMap.getOrDefault(rVal, 0) + 1);
            sum += nums.get(right);

            int lVal = nums.get(left);

            if (countMap.get(lVal) > 1) {
                countMap.put(lVal, countMap.getOrDefault(lVal, 0) - 1);
            } else {
                countMap.remove(lVal);
            }
            sum -= nums.get(left);

            if (countMap.size() >= m) {
                ans = Math.max(ans, sum);
            }

            left++;
            right++;
        }

        return ans;
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
