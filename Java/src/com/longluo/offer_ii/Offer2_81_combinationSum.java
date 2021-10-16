package com.longluo.offer_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 081. 允许重复选择元素的组合
 * <p>
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 * <p>
 * 示例 1：
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 * <p>
 * 示例 2：
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * <p>
 * 示例 3：
 * 输入: candidates = [2], target = 1
 * 输出: []
 * <p>
 * 示例 4：
 * 输入: candidates = [1], target = 1
 * 输出: [[1]]
 * <p>
 * 示例 5：
 * 输入: candidates = [1], target = 2
 * 输出: [[1,1]]
 * <p>
 * 提示：
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * <p>
 * 注意：本题与主站 39 题相同： https://leetcode-cn.com/problems/combination-sum/
 * <p>
 * https://leetcode-cn.com/problems/Ygoe9J/
 */
public class Offer2_81_combinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrace(ans, new ArrayList<>(), candidates, 0, target);
        return ans;
    }

    public static void backtrace(List<List<Integer>> ans, List<Integer> oneList, int[] nums, int idx, int remain) {
        if (idx == nums.length || remain < 0) {
            return;
        }

        if (remain == 0) {
            ans.add(new ArrayList<>(oneList));
            return;
        }

        backtrace(ans, oneList, nums, idx + 1, remain);
        oneList.add(nums[idx]);
        backtrace(ans, oneList, nums, idx, remain - nums[idx]);
        oneList.remove(oneList.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println("[[7],[2,2,3]] ?= " + combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println("[[2,2,2,2],[2,3,3],[3,5]] ?= " + combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println("[] ?= " + combinationSum(new int[]{2}, 1));
    }
}
