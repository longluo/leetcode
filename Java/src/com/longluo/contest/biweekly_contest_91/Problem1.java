package com.longluo.contest.biweekly_contest_91;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/contest/biweekly-contest-91
 */

/**
 * https://leetcode.cn/problems/number-of-distinct-averages/
 */
public class Problem1 {

    public static int distinctAverages(int[] nums) {
        int len = nums.length;

        Arrays.sort(nums);

        Set<Double> median = new HashSet<>();

        for (int i = 0; i < len / 2; i++) {
            double average = (nums[i] + nums[len - 1 - i]) / 2.0;
            median.add(average);
        }

        return median.size();
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + distinctAverages(new int[]{9, 5, 7, 8, 7, 9, 8, 2, 0, 7}));
    }
}
