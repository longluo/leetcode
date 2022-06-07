package com.longluo.top100;

import com.longluo.datastructure.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 * <p>
 * https://leetcode.com/problems/subsets/
 */
public class Problem78_subsets {

    // Backtrack time: O(2^n) space: O(n)
    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    public static void backtrack(List<List<Integer>> ans, List<Integer> oneList, int[] numbers, int index) {
        if (index == numbers.length) {
            ans.add(new ArrayList<>(oneList));
            return;
        }

        oneList.add(numbers[index]);
        backtrack(ans, oneList, numbers, index + 1);
        oneList.remove(oneList.size() - 1);
        backtrack(ans, oneList, numbers, index + 1);
    }

    public static void main(String[] args) {
        System.out.println("[[],[1],[1,2],[1,2,2],[2],[2,2]] ?= " + ArrayUtils.print2DList(subsets(new int[]{1, 2, 2})));
        System.out.println("[[],[0]] ?= " + ArrayUtils.print2DList(subsets(new int[]{0})));
    }
}
