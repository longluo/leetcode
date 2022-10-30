package com.longluo.contest.weekly_contest_290;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * https://leetcode.cn/contest/weekly-contest-290/
 */
public class Problem1 {

    public static List<Integer> intersection(int[][] nums) {
        int len = nums.length;

        List<Integer> ans = new ArrayList<>();

        TreeMap<Integer, Integer> countMap = new TreeMap<>();

        for (int[] arr : nums) {
            for (int x : arr) {
                countMap.put(x, countMap.getOrDefault(x, 0) + 1);
            }
        }

        for (int key : countMap.keySet()) {
            if (countMap.get(key) == len) {
                ans.add(key);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[3, 4] ?= " + intersection(new int[][]{{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}}));
        System.out.println("[] " + intersection(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }
}
