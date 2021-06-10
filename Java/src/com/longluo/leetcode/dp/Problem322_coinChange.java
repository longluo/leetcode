package com.longluo.leetcode.dp;

/**
 * 322. 零钱兑换
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回-1。
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * <p>
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：coins = [1], amount = 1
 * 输出：1
 * <p>
 * 示例 5：
 * 输入：coins = [1], amount = 2
 * 输出：2
 * <p>
 * 提示：
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 * <p>
 * https://leetcode-cn.com/problems/coin-change/
 */
public class Problem322_coinChange {

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }

        return coinChange(coins, amount, new int[amount]);
    }

    public static int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }

        if (rem == 0) {
            return 0;
        }

        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }

        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + coinChange(new int[]{1, 2, 5}, 11));
        System.out.println("-1 ?= " + coinChange(new int[]{2}, 3));
        System.out.println("0 ?= " + coinChange(new int[]{1}, 0));
        System.out.println("1 ?= " + coinChange(new int[]{1}, 1));
        System.out.println("2 ?= " + coinChange(new int[]{1}, 2));
    }
}
