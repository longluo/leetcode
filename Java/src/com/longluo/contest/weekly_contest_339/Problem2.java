package com.longluo.contest.weekly_contest_339;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-339
 */
public class Problem2 {

    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int freq = entry.getValue();

            for (int i = 0; i < freq; i++) {
                if (ans.size() <= i) {
                    ans.add(new ArrayList<>());
                }

                ans.get(i).add(key);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[[1, 3, 4, 2], [1, 3], [1]] ?= " + findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1}));
        System.out.println("[[4, 3, 2, 1]] ?= " + findMatrix(new int[]{1, 2, 3, 4}));
    }
}
