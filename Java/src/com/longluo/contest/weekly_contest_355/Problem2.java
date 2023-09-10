package com.longluo.contest.weekly_contest_355;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-355
 */
public class Problem2 {

    public static long maxArrayValue(int[] nums) {
        List<Long> list = new ArrayList<>();

        for (int x : nums) {
            list.add((long) x);
        }

        long ans = nums[0];

        while (true) {
            boolean flag = true;

            for (int i = list.size() - 1; i > 0; i--) {
                ans = Math.max(ans, list.get(i));

                if (list.get(i) >= list.get(i - 1)) {
                    long sum = list.get(i) + list.get(i - 1);
                    list.set(i - 1, sum);
                    list.remove(i);
                    flag = false;
                    break;
                }
            }

            if (flag) {
                break;
            }
        }

        return Math.max(ans, list.get(0));
    }

    public static void main(String[] args) {
        System.out.println("21 ?= " + maxArrayValue(new int[]{2, 3, 7, 9, 3}));
        System.out.println("11 ?= " + maxArrayValue(new int[]{5, 3, 3}));
    }
}
