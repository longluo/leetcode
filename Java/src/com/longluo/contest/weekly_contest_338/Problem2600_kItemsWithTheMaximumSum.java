package com.longluo.contest.weekly_contest_338;

/**
 * https://leetcode.cn/contest/weekly-contest-338
 */

/**
 * 2600. K 件物品的最大和
 * <p>
 * 袋子中装有一些物品，每个物品上都标记着数字 1 、0 或 -1 。
 * <p>
 * 给你四个非负整数 numOnes 、numZeros 、numNegOnes 和 k 。
 * <p>
 * 袋子最初包含：
 * numOnes 件标记为 1 的物品。
 * numZeroes 件标记为 0 的物品。
 * numNegOnes 件标记为 -1 的物品。
 * 现计划从这些物品中恰好选出 k 件物品。返回所有可行方案中，物品上所标记数字之和的最大值。
 * <p>
 * 示例 1：
 * 输入：numOnes = 3, numZeros = 2, numNegOnes = 0, k = 2
 * 输出：2
 * 解释：袋子中的物品分别标记为 {1, 1, 1, 0, 0} 。取 2 件标记为 1 的物品，得到的数字之和为 2 。
 * 可以证明 2 是所有可行方案中的最大值。
 * <p>
 * 示例 2：
 * 输入：numOnes = 3, numZeros = 2, numNegOnes = 0, k = 4
 * 输出：3
 * 解释：袋子中的物品分别标记为 {1, 1, 1, 0, 0} 。取 3 件标记为 1 的物品，1 件标记为 0 的物品，得到的数字之和为 3 。
 * 可以证明 3 是所有可行方案中的最大值。
 * <p>
 * 提示：
 * 0 <= numOnes, numZeros, numNegOnes <= 50
 * 0 <= k <= numOnes + numZeros + numNegOnes
 * <p>
 * https://leetcode.cn/problems/k-items-with-the-maximum-sum/
 */
public class Problem2600_kItemsWithTheMaximumSum {

    // Simulate time: O(1) space: O(1)
    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int ans = 0;

        if (k <= numOnes) {
            return k;
        }

        ans += numOnes;
        k -= numOnes;

        if (k <= numZeros) {
            return ans;
        }

        k -= numZeros;

        if (k <= numNegOnes) {
            return ans - k;
        }

        return ans - numNegOnes;
    }

    // Better time: O(1) space: O(1)
    public static int kItemsWithMaximumSum_opt(int numOnes, int numZeros, int numNegOnes, int k) {
        int ans = Math.min(numOnes, k);

        k -= numOnes;
        k -= numZeros;

        if (k <= 0) {
            return ans;
        }

        return ans - Math.min(k, numNegOnes);
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + kItemsWithMaximumSum(3, 2, 0, 2));
        System.out.println("3 ?= " + kItemsWithMaximumSum(3, 2, 0, 4));
        System.out.println("3 ?= " + kItemsWithMaximumSum_opt(3, 2, 0, 4));
    }
}
