package com.longluo.leetcode.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1498. 满足条件的子序列数目
 * <p>
 * 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。
 * <p>
 * 由于答案可能很大，请将结果对 10^9 + 7 取余后返回。
 * <p>
 * 示例 1：
 * 输入：nums = [3,5,6,7], target = 9
 * 输出：4
 * 解释：有 4 个子序列满足该条件。
 * [3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
 * [3,5] -> (3 + 5 <= 9)
 * [3,5,6] -> (3 + 6 <= 9)
 * [3,6] -> (3 + 6 <= 9)
 * <p>
 * 示例 2：
 * 输入：nums = [3,3,6,8], target = 10
 * 输出：6
 * 解释：有 6 个子序列满足该条件。（nums 中可以有重复数字）
 * [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
 * <p>
 * 示例 3：
 * 输入：nums = [2,3,3,4,6,7], target = 12
 * 输出：61
 * 解释：共有 63 个非空子序列，其中 2 个不满足条件（[6,7], [7]）
 * 有效序列总数为（63 - 2 = 61）
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 * 1 <= target <= 10^6
 * <p>
 * https://leetcode.cn/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
 */
public class Problem1498_numberofSubsequencesThatSatisfyTheGivenSumCondition {

    // BF

    static int ans = 0;
    static int MOD = 1_000_000_007;

    static List<List<Integer>> res = new ArrayList<>();

    public static int numSubseq_bf(int[] nums, int target) {
        int n = nums.length;

        Arrays.sort(nums);

        if (res != null && res.size() > 0) {
            res.clear();
        }

        ans = 0;

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n];
            backtrack(nums, visited, new ArrayList<>(), 0, target, i);
        }

        for (List<Integer> path : res) {
            System.out.println(path.toString());
        }

        return ans;
    }

    private static void backtrack(int[] nums, boolean[] visited, List<Integer> path, int idx, int target, int len) {
        if (path.size() == len) {
            Collections.sort(path);

            if ((path.size() == 1 && path.get(0) * 2 <= target)
                    || (path.size() > 1 && path.get(0) + path.get(path.size() - 1) <= target)) {
                ans++;
                ans %= MOD;

                res.add(new ArrayList<>(path));
            }

            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (visited[i] || nums[i] >= target) {
                continue;
            }

            path.add(nums[i]);
            visited[i] = true;

            backtrack(nums, visited, path, i + 1, target, len);

            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
//        System.out.println("4 ?= " + numSubseq_bf(new int[]{3, 5, 6, 7}, 9));
//        System.out.println("6 ?= " + numSubseq_bf(new int[]{3, 3, 6, 8}, 10));
//        System.out.println("61 ?= " + numSubseq_bf(new int[]{2, 3, 3, 4, 6, 7}, 12));
        System.out.println("56 ?= " + numSubseq_bf(new int[]{7, 10, 7, 3, 7, 5, 4}, 12));
    }
}
