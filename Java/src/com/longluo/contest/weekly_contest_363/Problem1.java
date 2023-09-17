package com.longluo.contest.weekly_contest_363;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-363
 */
public class Problem1 {

    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (Integer.bitCount(i) == k) {
                sum += nums.get(i);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
//        System.out.println("13 ?= " + sumIndicesWithKSetBits(Arrays.asList(new int[]{5, 10, 1, 5, 2}), 1));
    }
}
