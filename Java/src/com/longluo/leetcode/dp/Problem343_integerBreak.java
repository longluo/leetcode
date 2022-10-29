package com.longluo.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 343. 整数拆分
 * <p>
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 * <p>
 * 示例 1:
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * <p>
 * 示例 2:
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * <p>
 * 提示:
 * 2 <= n <= 58
 * <p>
 * https://leetcode.cn/problems/integer-break/
 */
public class Problem343_integerBreak {

    // BF DFS time: O(n^2) space: O(n)
    // TLE
    public static int integerBreak_bf(int n) {
        int maxProduct = 1;

        for (int i = 2; i <= n; i++) {
            List<List<Integer>> res = new ArrayList<>();

            dfs(res, new ArrayList<>(), i, 1, n);

            for (List<Integer> item : res) {

                int product = 1;
                for (int x : item) {
                    product *= x;
                }

                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> path, int segs, int start, int remain) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= remain - segs + 1; i++) {
            path.add(i);
            dfs(res, path, segs - 1, i, remain - i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + integerBreak_bf(2));
        System.out.println("6 ?= " + integerBreak_bf(5));
        System.out.println("36 ?= " + integerBreak_bf(10));
        System.out.println("6377292 ?= " + integerBreak_bf(43));
    }
}
