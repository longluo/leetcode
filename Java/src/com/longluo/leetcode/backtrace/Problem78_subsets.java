package com.longluo.leetcode.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Problem78_subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

        }

        return ans;
    }

    private static void backtrace(List<List<Integer>> ans, int index, int[] nums, List<Integer> oneAns) {
        if (oneAns.size() > nums.length) {
            return;
        } else {
            ans.add(oneAns);
        }

        for (int i = 0; i < nums.length; i++) {
            oneAns.add(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {


            }
            backtrace(ans, i, nums, oneAns);
            oneAns.remove(oneAns.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] tst1 = {1, 2, 3};
        System.out.println(" " + subsets(tst1));
    }
}
