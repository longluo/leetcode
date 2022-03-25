package com.longluo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class Problem39_combinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || target == 0) {
            return ans;
        }

        // for trim
        Arrays.sort(candidates);
        backtrack(ans, new ArrayList<>(), candidates, 0, target);
        return ans;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> list, int[] candidates, int begin, int remain) {
        if (remain < 0) {
            return;
        }

        if (remain == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        int len = candidates.length;
        for (int i = begin; i < len; i++) {
            int num = candidates[i];
            list.add(num);
            backtrack(res, list, candidates, i, remain - num);
            list.remove(list.size() - 1);
        }
    }

    public static void backtrack_trim(List<List<Integer>> res, List<Integer> list, int[] candidates, int begin, int remain) {
        if (remain < 0) {
            return;
        }

        if (remain == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        int len = candidates.length;
        for (int i = begin; i < len; i++) {
            int num = candidates[i];
            if (remain - num < 0) {
                break;
            }
            list.add(num);
            backtrack_trim(res, list, candidates, i, remain - num);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
