package com.longluo.contest.weekly_contest_315;

import java.util.*;

public class Problem1 {

    public static int findMaxK(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(-x)) {
                res.add(Math.abs(x));
            }

            set.add(x);
        }

        Collections.sort(res);
        return res.size() == 0 ? -1 : res.get(res.size() - 1);
    }

    public static int findMaxK_opt(int[] nums) {
        int max = -1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(-nums[i])) {
                max = Math.max(max, Math.abs(nums[i]));
            }

            set.add(nums[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("7 ?= " + findMaxK(new int[]{-1, 10, 6, 7, -7, 1}));
        System.out.println("7 ?= " + findMaxK_opt(new int[]{-1, 10, 6, 7, -7, 1}));
    }
}
