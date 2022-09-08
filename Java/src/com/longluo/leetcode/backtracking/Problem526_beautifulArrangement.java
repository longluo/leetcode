package com.longluo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 526. 优美的排列
 * <p>
 * 假设有从 1 到 n 的 n 个整数。用这些整数构造一个数组 perm（下标从 1 开始），只要满足下述条件 之一 ，
 * 该数组就是一个 优美的排列 ：
 * <p>
 * perm[i] 能够被 i 整除
 * i 能够被 perm[i] 整除
 * <p>
 * 给你一个整数 n ，返回可以构造的 优美排列 的 数量 。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：
 * 第 1 个优美的排列是 [1,2]：
 * - perm[1] = 1 能被 i = 1 整除
 * - perm[2] = 2 能被 i = 2 整除
 * 第 2 个优美的排列是 [2,1]:
 * - perm[1] = 2 能被 i = 1 整除
 * - i = 2 能被 perm[2] = 1 整除
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * <p>
 * 提示：
 * 1 <= n <= 15
 * <p>
 * https://leetcode.cn/problems/beautiful-arrangement-ii/
 */
public class Problem526_beautifulArrangement {

    // Backtrack time: O(2^n) space: O(n)
    public static int countArrangement(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        boolean[] visited = new boolean[n];
        backtrack(ans, new ArrayList<>(), visited, 1, n);

        return ans.size();
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> path, boolean[] visited, int idx, int len) {
        if (idx == len + 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 1; i <= len; i++) {
            if (!visited[i - 1]) {
                if (i % idx != 0 && idx % i != 0) {
                    continue;
                }

                visited[i - 1] = true;
                path.add(i);
                backtrack(res, path, visited, idx + 1, len);
                visited[i - 1] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + countArrangement(2));
    }
}
