package com.longluo.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 377. 组合总和 Ⅳ
 * <p>
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * <p>
 * 题目数据保证答案符合 32 位整数范围。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * <p>
 * 示例 2：
 * 输入：nums = [9], target = 3
 * 输出：0
 * <p>
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 * <p>
 * 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？
 * <p>
 * https://leetcode.cn/problems/combination-sum-iv/
 */
public class Problem377_combinationSum_iv {

    // Backtrack time: O() space: O()
    // MLE
    public static int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>(), target);
        return res.size();
    }

    private static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> onePath, int remain) {
        if (remain == 0) {
            res.add(new ArrayList<>(onePath));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > remain) {
                break;
            }

            onePath.add(nums[i]);
            backtrack(nums, res, onePath, remain - nums[i]);
            onePath.remove(onePath.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("7 ?= " + combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
