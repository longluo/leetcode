package com.longluo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491. 递增子序列
 * <p>
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * <p>
 * 示例 1：
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * <p>
 * 示例 2：
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 * <p>
 * https://leetcode.cn/problems/non-decreasing-subsequences/
 */
public class Problem491_nonDecreasingSubsequences {

    // Backtrack time: O(2^n) space: O(n)
    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        int len = nums.length;
        if (len < 2) {
            return ans;
        }

        boolean[] visited = new boolean[len];

        Set<List<Integer>> res = new HashSet<>();
        backtrack(res, new ArrayList<>(), nums, visited, 0);

        return new ArrayList<>(res);
    }

    private static void backtrack(Set<List<Integer>> res, List<Integer> path, int[] nums, boolean[] visited, int start) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }

        if (start == nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (path.size() > 0 && nums[i] < path.get(path.size() - 1)) {
                continue;
            }

            if (visited[i]) {
                continue;
            }

            path.add(nums[i]);
            visited[i] = true;

            backtrack(res, path, nums, visited, i + 1);

            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]] ?= " + findSubsequences(new int[]{4, 6, 7, 7}));
        System.out.println("[[4, 4]] ?= " + findSubsequences(new int[]{4, 4, 3, 2, 1}));
    }
}
