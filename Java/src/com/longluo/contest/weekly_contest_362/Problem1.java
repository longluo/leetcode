package com.longluo.contest.weekly_contest_362;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-362
 */
public class Problem1 {

    public static int numberOfPoints(List<List<Integer>> nums) {
        Collections.sort(nums, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                if (a.get(0) == b.get(0)) {
                    return a.get(1) - b.get(1);
                }

                return a.get(0) - b.get(0);
            }
        });

        int ans = nums.get(0).get(1) - nums.get(0).get(0) + 1;
        int idx = nums.get(0).get(1) + 1;

        for (int i = 1; i < nums.size(); i++) {
            if (idx > nums.get(i).get(1)) {
                continue;
            }

            if (idx >= nums.get(i).get(0)) {
                ans += nums.get(i).get(1) - idx + 1;
                idx = nums.get(i).get(1) + 1;
            } else if (idx < nums.get(i).get(0)) {
                ans += nums.get(i).get(1) - nums.get(i).get(0) + 1;
                idx = nums.get(i).get(1) + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> tst1 = new ArrayList<>();
        List<Integer> t1 = new ArrayList<>();
        t1.add(4);
        t1.add(4);
        tst1.add(t1);

        List<Integer> t2 = new ArrayList<>();
        t2.add(9);
        t2.add(10);
        tst1.add(t2);

        List<Integer> t3 = new ArrayList<>();
        t3.add(9);
        t3.add(10);
        tst1.add(t3);

        List<Integer> t4 = new ArrayList<>();
        t4.add(3);
        t4.add(8);
        tst1.add(t4);

        System.out.println("8 ?= " + numberOfPoints(tst1));
    }
}
