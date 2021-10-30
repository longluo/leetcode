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

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(ans, new ArrayList<>(), nums, visited, 0);
        return ans;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] visited, int len) {
        if (len == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            visited[i] = true;
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
