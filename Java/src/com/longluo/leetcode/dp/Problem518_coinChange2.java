package com.longluo.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 518. 零钱兑换 II
 * <p>
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * <p>
 * 示例 1:
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * 示例 2:
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * <p>
 * 示例 3:
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 * <p>
 * 注意:
 * 你可以假设：
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 * <p>
 * https://leetcode-cn.com/problems/coin-change-2/
 */
public class Problem518_coinChange2 {

    public static int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    public static int change_2(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }

        List<List<Integer>> ans = new ArrayList<>();
        backTrack(coins, ans, new ArrayList<>(), amount, 0);
        return ans.size();
    }

    public static void backTrack(int[] coins, List<List<Integer>> solution, List<Integer> one, int target, int money) {
        if (money > target) {
            return;
        }

        if (money == target) {
            for (List list : solution) {
                if (list.size() == one.size()) {
                    return;
                }
            }
            solution.add(new ArrayList<>(one));
            return;
        }

        for (int coin : coins) {
            if (money + coin > target) {
                return;
            }
            one.add(coin);
            backTrack(coins, solution, one, target, money + coin);
            one.remove(one.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + change(5, new int[]{1, 2, 5}));
        System.out.println("4 ?= " + change_2(5, new int[]{1, 2, 5}));
        System.out.println("0 ?= " + change(3, new int[]{2}));
        System.out.println("0 ?= " + change_2(3, new int[]{2}));
        System.out.println("1 ?= " + change(10, new int[]{10}));
        System.out.println("1 ?= " + change_2(10, new int[]{10}));
        System.out.println("12701 ?= " + change(500, new int[]{1, 2, 5}));
        System.out.println("12701 ?= " + change_2(500, new int[]{1, 2, 5}));
    }
}
