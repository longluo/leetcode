package com.longluo.contest.weekly_contest_514;

import java.util.*;

/**
 * 4015. 树的加权和
 * <p>
 * BFS
 * <p>
 * https://leetcode.cn/problems/weighted-sum-of-a-tree/description/
 */
public class Problem4015_weightedSumOfATree {

    public static long weightedSum(int[] parent, int[] nums) {
        int len = parent.length;

        int[] depths = new int[len];
        Arrays.fill(depths, 0);

        Map<Integer, List<Integer>> treeMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (treeMap.containsKey(parent[i])) {
                treeMap.get(parent[i]).add(i);
            } else {
                treeMap.put(parent[i], new LinkedList<>());
                treeMap.get(parent[i]).add(i);
            }
        }

        int height = 1;
        Queue<Integer> queue = new LinkedList<>();
        depths[0] = 1;
        queue.add(0);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            if (treeMap.containsKey(node)) {
                for (int i : treeMap.get(node)) {
                    depths[i] = depths[node] + 1;
                    height = Math.max(height, depths[i]);
                    queue.add(i);
                }
            }
        }

        long ans = 0;

        for (int i = 0; i < len; i++) {
            ans += (long) nums[i] * (height - depths[i] + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("37 ?= " + weightedSum(new int[]{-1, 0, 0, 0, 2, 2}, new int[]{5, 2, 3, 1, 4, 6}));
        System.out.println("20 ?= " + weightedSum(new int[]{-1, 0, 1, 2}, new int[]{1, 2, 3, 4}));
        System.out.println("399 ?= " + weightedSum(new int[]{-1, 0, 1, 0}, new int[]{47, 68, 8, 57}));
    }
}
