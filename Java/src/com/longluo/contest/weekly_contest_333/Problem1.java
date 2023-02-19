package com.longluo.contest.weekly_contest_333;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-333
 */
public class Problem1 {

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> ans = new ArrayList<>();

        Map<Integer, Integer> map1 = new HashMap<>();
        for (int[] x : nums1) {
            map1.put(x[0], x[1]);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int[] x : nums2) {
            map2.put(x[0], x[1]);
        }

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            if (map2.containsKey(key)) {
                val += map2.get(key);
            }

            ans.add(new int[]{key, val});
            map2.remove(key);
        }

        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            ans.add(new int[]{key, val});
        }

        Collections.sort(ans, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
