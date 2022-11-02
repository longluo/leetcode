package com.longluo.contest.weekly_contest_293;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    // BF Backtrack
    // TLE
    public static int largestCombination_bf(int[] candidates) {
        int len = candidates.length;

        int ans = 1;

        for (int i = len; i >= 1; i--) {
            List<Integer> res = new ArrayList<>();
            boolean[] visited = new boolean[len];

            dfs(res, Integer.MAX_VALUE, candidates, visited, 0, i);

            for (int x : res) {
                if (x > 0) {
                    return i;
                }
            }
        }

        return ans;
    }

    private static void dfs(List<Integer> res, int bitwise, int[] nums, boolean[] visited, int start, int remain) {
        int len = nums.length;

        if (start == len) {
            if (remain == 0) {
                res.add(bitwise);
                return;
            }
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            int and = bitwise & nums[i];

            visited[i] = true;
            dfs(res, and, nums, visited, i + 1, remain - 1);
            visited[i] = false;

            dfs(res, bitwise, nums, visited, i + 1, remain);
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("4 ?= " + largestCombination_bf(new int[]{16, 17, 71, 62, 12, 24, 14}));
        System.out.println("2 ?= " + largestCombination_bf(new int[]{8, 8}));
    }
}
