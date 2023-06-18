package com.longluo.contest.weekly_contest_350;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/contest/weekly-contest-350
 */
public class Problem3 {

    public static int specialPerm(int[] nums) {
        int MOD = 1_000_000_007;

        int n = nums.length;
        if (n <= 1) {
            return 1;
        }

        List<List<Integer>> ans = new ArrayList<>();

        boolean[] vis = new boolean[n];

        backtrack(ans, new ArrayList<>(), nums, vis, 0);

        return ans.size() % MOD;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited, int idx) {
        int n = nums.length;

        if (idx == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            int size = list.size();

            if (size >= 1 && list.get(size - 1) % nums[i] != 0 && nums[i] % list.get(size - 1) != 0) {
                continue;
            }

            visited[i] = true;
            list.add(nums[i]);

            backtrack(res, list, nums, visited, idx + 1);

            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + specialPerm(new int[]{2, 3, 6}));
        System.out.println("2 ?= " + specialPerm(new int[]{1, 4, 3}));
    }
}
