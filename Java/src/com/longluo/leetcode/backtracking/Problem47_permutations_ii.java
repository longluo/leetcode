package com.longluo.leetcode.backtracking;

import java.util.*;

/**
 * 47. 全排列 II
 * <p>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * <p>
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class Problem47_permutations_ii {

    // Backtracking time: O(n×n!) space: O(2*n)=O(n)
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return ans;
        }

        // Sort is for pruning
        Arrays.sort(nums);

        boolean[] vis = new boolean[len];
        backtrack(ans, new ArrayList<>(), nums, vis, 0);
        return ans;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] visited, int len) {
        if (len == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // every number choose once.
            if (visited[i]) {
                continue;
            }

            // pruning:
            // i > 0 because i - 1 >=0
            // nums[i] == nums[i - 1] avoid duplicates
            // visited[i-1]=false is in tree level pruning
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            path.add(nums[i]);
            backtrack(res, path, nums, visited, len + 1);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        permuteUnique(new int[]{0});
        permuteUnique(new int[]{1, 2});
        permuteUnique(new int[]{1, 1, 2});
        permuteUnique(new int[]{1, 1});
        permuteUnique(new int[]{1, 2, 3});
    }
}
