package com.longluo.contest.biweekly_contest_84;

import java.util.*;

/**
 * https://leetcode.cn/contest/biweekly-contest-84/
 */

/**
 * https://leetcode.cn/problems/merge-similar-items/
 */
public class Problem1 {

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ans = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int[] x : items1) {
            int value = x[0];
            int weight = x[1];

            map.put(value, map.getOrDefault(value, 0) + weight);
        }

        for (int[] x : items2) {
            int value = x[0];
            int weight = x[1];

            map.put(value, map.getOrDefault(value, 0) + weight);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getKey();
            int weight = entry.getValue();

            List<Integer> item = new ArrayList<>();
            item.add(value);
            item.add(weight);

            ans.add(item);
        }

        Collections.sort(ans, (a, b) -> a.get(0) - b.get(0));

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[[1,6],[3,9],[4,5]] ?= " + mergeSimilarItems(new int[][]{{1, 1}, {4, 5}, {3, 8}}, new int[][]{{3, 1}, {1, 5}}));
    }
}
