package com.longluo.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 1155. 掷骰子的N种方法
 * <p>
 * 这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为 1 到 k 。
 * <p>
 * 给定三个整数 n ,  k 和 target ，返回可能的方式(从总共 kn 种方式中)滚动骰子的数量，使正面朝上的数字之和等于 target 。
 * <p>
 * 答案可能很大，你需要对 10^9 + 7 取模 。
 * <p>
 * 示例 1：
 * 输入：n = 1, k = 6, target = 3
 * 输出：1
 * 解释：你扔一个有6张脸的骰子。
 * 得到3的和只有一种方法。
 * <p>
 * 示例 2：
 * 输入：n = 2, k = 6, target = 7
 * 输出：6
 * 解释：你扔两个骰子，每个骰子有6个面。
 * 得到7的和有6种方法1+6 2+5 3+4 4+3 5+2 6+1。
 * <p>
 * 示例 3：
 * 输入：n = 30, k = 30, target = 500
 * 输出：222616187
 * 解释：返回的结果必须是对 10^9 + 7 取模。
 * <p>
 * 提示：
 * 1 <= n, k <= 30
 * 1 <= target <= 1000
 * <p>
 * <p>
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 */
public class Problem1155_numberOfDiceRollsWithTargetSum {

    // Backtrack time: O(n^k) space: O(n^k)
    // TLE
    public static int numRollsToTarget(int n, int k, int target) {
        if (n * k < target) {
            return 0;
        }

        if (n == 1 || k == 1 || target == n || n * k == target) {
            return 1;
        }

        int mod = 1_000_000_007;

        List<int[]> res = new ArrayList<>();

        int[] dices = new int[n];

//        backtrack(res, dices, n, 0, k, target);
        backtrack(n, 0, k, target);

//        return res.size() % mod;
        return ans;
    }

    private static void backtrack(List<int[]> res, int[] dices, int n, int idx, int k, int target) {
        if (idx == n) {
            if (target == 0) {
                res.add(dices.clone());
            }

            return;
        }

        for (int i = k; i >= 1; i--) {
            if (target - i < n - idx - 1) {
                continue;
            }

            dices[idx] = i;
            backtrack(res, dices, n, idx + 1, k, target - i);
            dices[idx] = 0;
        }
    }

    static int ans = 0;

    // Backtrack Opt
    private static void backtrack(int n, int idx, int k, int target) {
        if (idx == n) {
            if (target == 0) {
                ans++;
                ans %= 1_000_000_007;
            }

            return;
        }

        for (int i = k; i >= 1; i--) {
            if (target - i < n - idx - 1) {
                continue;
            }

            backtrack(n, idx + 1, k, target - i);
        }
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + numRollsToTarget(1, 6, 3));
        System.out.println("6 ?= " + numRollsToTarget(2, 6, 7));
        System.out.println("222616187 ?= " + numRollsToTarget(30, 30, 500));
    }
}
