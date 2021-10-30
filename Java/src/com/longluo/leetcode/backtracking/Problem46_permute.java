package com.longluo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. 全排列
 * <p>
 * 给定一个不含重复数字的数组 nums，返回其 所有可能的全排列。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * <p>
 * https://leetcode-cn.com/problems/permutations/
 */
public class Problem46_permute {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(ans, new ArrayList<>(), nums, visited, 0);
        return ans;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited, int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                backtrack(res, list, nums, visited, idx + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        permute(new int[]{1});
        permute(new int[]{1, 2});
        permute(new int[]{1, 2, 3});
    }
}
