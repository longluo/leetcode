package com.longluo.contest.weekly_contest_308;

import java.util.Arrays;

/**
 * 2389. 和有限的最长子序列
 * <p>
 * 给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。
 * <p>
 * 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度  。
 * <p>
 * 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。
 * <p>
 * 示例 1：
 * 输入：nums = [4,5,2,1], queries = [3,10,21]
 * 输出：[2,3,4]
 * 解释：queries 对应的 answer 如下：
 * - 子序列 [2,1] 的和小于或等于 3 。可以证明满足题目要求的子序列的最大长度是 2 ，所以 answer[0] = 2 。
 * - 子序列 [4,5,1] 的和小于或等于 10 。可以证明满足题目要求的子序列的最大长度是 3 ，所以 answer[1] = 3 。
 * - 子序列 [4,5,2,1] 的和小于或等于 21 。可以证明满足题目要求的子序列的最大长度是 4 ，所以 answer[2] = 4 。
 * <p>
 * 示例 2：
 * 输入：nums = [2,3,4,5], queries = [1]
 * 输出：[0]
 * 解释：空子序列是唯一一个满足元素和小于或等于 1 的子序列，所以 answer[0] = 0 。
 * <p>
 * 提示：
 * n == nums.length
 * m == queries.length
 * 1 <= n, m <= 1000
 * 1 <= nums[i], queries[i] <= 10^6
 * <p>
 * https://leetcode.cn/problems/longest-subsequence-with-limited-sum/
 */
public class Problem2389_answerQueries {

    // Sort + BF time: O(mn) space: O(logn)
    public static int[] answerQueries(int[] nums, int[] queries) {
        int sum = Arrays.stream(nums).sum();

        Arrays.sort(nums);

        int n = nums.length;
        int m = queries.length;

        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int max = 0;
            int subSum = sum;

            for (int j = n - 1; j >= 0; j--) {
                if (subSum <= queries[i]) {
                    max = j + 1;
                    break;
                } else {
                    subSum -= nums[j];
                }
            }

            ans[i] = max;
        }

        return ans;
    }

    // PrefixSum time: O(nm) space: O(n)
    public static int[] answerQueries_prefixSum(int[] nums, int[] queries) {
        Arrays.sort(nums);

        int n = nums.length;
        int m = queries.length;

        int[] prefixSums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            if (prefixSums[n] <= queries[i]) {
                ans[i] = n;
                continue;
            }

            for (int j = 1; j <= n; j++) {
                if (prefixSums[j] <= queries[i]) {
                    continue;
                }

                ans[i] = j - 1;
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[2, 3, 4] ?= " + Arrays.toString(answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21})));
        System.out.println("[2, 3, 4] ?= " + Arrays.toString(answerQueries_prefixSum(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21})));
    }
}
