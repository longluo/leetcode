package com.longluo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * <p>
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * <p>
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * 提示:
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * <p>
 * https://leetcode.cn/problems/combination-sum-ii/
 */
public class Problem40_combinationSum_ii {

    // Backtracking time: O(O(2^n \times n) space: O(n)
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || target == 0) {
            return ans;
        }

        Arrays.sort(candidates);

        backtracking(ans, new ArrayList<>(), candidates, 0, target);

        return ans;
    }

    public static void backtracking(List<List<Integer>> res, List<Integer> path, int[] nums, int start, int remain) {
        if (remain < 0) {
            return;
        }

        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        int len = nums.length;

        for (int i = start; i < len; i++) {
            if (nums[i] > remain) {
                return;
            }

            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            backtracking(res, path, nums, i + 1, remain - nums[i]);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(" ?= " + combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
