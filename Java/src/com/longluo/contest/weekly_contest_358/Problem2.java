package com.longluo.contest.weekly_contest_358;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-358
 */
public class Problem2 {

    public static long maxArrayValue(int[] nums) {
        List<Long> numsList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            numsList.add((long) nums[i]);
        }

        long max = 0;

        while (true) {
            boolean flag = true;

            for (int i = numsList.size() - 1; i > 0; i--) {
                max = Math.max(max, numsList.get(i));

                if (numsList.get(i) >= numsList.get(i - 1)) {
                    long sum = numsList.get(i) + numsList.get(i - 1);
                    numsList.set(i - 1, sum);
                    numsList.remove(i);
                    flag = false;
                    break;
                }
            }

            if (flag) {
                break;
            }
        }

        return Math.max(max, numsList.get(0));
    }

    public static void main(String[] args) {
        System.out.println("21 ?= " + maxArrayValue(new int[]{2, 3, 7, 9, 3}));
        System.out.println("11 ?= " + maxArrayValue(new int[]{5, 3, 3}));
    }
}
