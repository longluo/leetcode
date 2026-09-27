package com.longluo.contest.weekly_contest_521;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-521
 */
public class Problem1 {

    public static int[] rearrangeArray(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        Map<Integer, Integer> map = new TreeMap<>();

        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int i = 0; i < 100; i++) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                if (value == 0) {
                    continue;
                }
                value--;
                ans.add(key);
                map.put(key, value);
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("[1,2,3,1,3,3] ?= " + Arrays.toString(rearrangeArray(new int[]{3, 1, 3, 2, 1, 3})));
        System.out.println("[4,7,4,7,4] ?= " + Arrays.toString(rearrangeArray(new int[]{7, 7, 4, 4, 4})));
    }
}
