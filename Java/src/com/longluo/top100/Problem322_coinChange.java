package com.longluo.top100;

import kotlin.Pair;

import java.util.*;

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
 * https://leetcode.com/problems/coin-change/
 */
public class Problem322_coinChange {

    //
    public static int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
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

    // DFS
    // TLE
    static int minCount = Integer.MAX_VALUE;

    public static int coinChange_dfs(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }

        minCount = Integer.MAX_VALUE;
        dfs(coins, amount, 0);
        return minCount;
    }

    private static int dfs(int[] coins, int remain, int count) {
        if (remain < 0) {
            return -1;
        }

        if (remain == 0) {
            minCount = Math.min(minCount, count);
            return count;
        }

        for (int x : coins) {
            dfs(coins, remain - x, count + 1);
        }

        return -1;
    }

    // DP time: O(amount * n) space: O(amount)
    public static int coinChange_dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int x : coins) {
            if (x > amount) {
                continue;
            }
            dp[x] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            if (dp[i] > 0) {
                continue;
            }

            for (int x : coins) {
                if (i >= x && dp[i - x] > 0) {
                    dp[i] = dp[i] > 0 ? Math.min(dp[i], dp[i - x] + 1) : dp[i - x] + 1;
                }
            }
        }

        return dp[amount] == 0 ? -1 : dp[amount];
    }

    //
    public static int coinChange_dp_opt(int[] coins, int amount) {
        int max = amount + 1;

        int[] dp = new int[max];
        Arrays.fill(dp, max);

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int x : coins) {
                if (i >= x) {
                    dp[i] = Math.min(dp[i], dp[i - x] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    // BFS
    // TLE
    public static int coinChange_bfs(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }

        Arrays.sort(coins);

        int minAns = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (coin > amount) {
                break;
            } else if (coin == amount) {
                minAns = 1;
                break;
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{amount - coin, 1});
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                if (cur[0] == 0) {
                    minAns = Math.min(minAns, cur[1]);
                }

                for (int x : coins) {
                    if (x > cur[0]) {
                        break;
                    }

                    queue.offer(new int[]{cur[0] - x, cur[1] + 1});
                }
            }
        }

        return minAns == Integer.MAX_VALUE ? -1 : minAns;
    }

    // BFS Opt
    // TLE
    public static int coinChange_bfs_opt(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }

        int minAns = Integer.MAX_VALUE;
        int len = coins.length;
        Arrays.sort(coins);

        for (int i = len - 1; i >= 0; i--) {
            if (amount % coins[i] == 0) {
                minAns = Math.min(minAns, amount / coins[i]);
                break;
            }

            int divide = amount / coins[i];
            for (int j = divide; j >= 0; j--) {
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{amount - j * coins[i], j});
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    if (cur[0] == 0) {
                        minAns = Math.min(minAns, cur[1]);
                    }

                    for (int x : coins) {
                        if (x > cur[0]) {
                            break;
                        }

                        queue.offer(new int[]{cur[0] - x, cur[1] + 1});
                    }
                }
            }
        }

        return minAns == Integer.MAX_VALUE ? -1 : minAns;
    }

    // Recursion
    // TLE
    static int minAns = Integer.MAX_VALUE;

    public static int coinChange_rec(int[] coins, int amount) {
        Arrays.sort(coins);
        minAns = Integer.MAX_VALUE;
        coinChange(coins, amount, 0);
        return minAns == Integer.MAX_VALUE ? -1 : minAns;
    }

    public static void coinChange(int[] coins, int amount, int cnt) {
        if (cnt > minAns) {
            return;
        }

        if (amount == 0) {
            minAns = Math.min(minAns, cnt);
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) {
                break;
            }
            coinChange(coins, amount - coins[i], cnt + 1);
        }
    }

    // Backtrack time: O() space: O()
    // TLE
    public static int coinChange_bt(int[] coins, int amount) {
        Arrays.sort(coins);

        List<List<Integer>> res = new ArrayList<>();
        backtrack(coins, res, new ArrayList<>(), amount);

        if (res.size() == 0) {
            return -1;
        }

        int ans = amount;
        for (List path : res) {
            ans = Math.min(ans, path.size());
        }

        return ans;
    }

    private static void backtrack(int[] coins, List<List<Integer>> res, List<Integer> onePath, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(onePath));
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > target) {
                break;
            }

            onePath.add(coins[i]);
            backtrack(coins, res, onePath, target - coins[i]);
            onePath.remove(onePath.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("-1 ?= " + coinChange(new int[]{2}, 3));
        System.out.println("0 ?= " + coinChange(new int[]{1}, 0));
        System.out.println("1 ?= " + coinChange(new int[]{1}, 1));
        System.out.println("2 ?= " + coinChange(new int[]{1}, 2));


        System.out.println("3 ?= " + coinChange(new int[]{1, 2, 5}, 11));

        System.out.println("3 ?= " + coinChange_dfs(new int[]{1, 2, 5}, 11));

        System.out.println("3 ?= " + coinChange_dp(new int[]{1, 2, 5}, 11));

        System.out.println("3 ?= " + coinChange_dp_opt(new int[]{1, 2, 5}, 11));

        System.out.println("3 ?= " + coinChange_rec(new int[]{1, 2, 5}, 11));

        System.out.println("3 ?= " + coinChange_bt(new int[]{1, 2, 5}, 11));

        System.out.println("3 ?= " + coinChange_bfs(new int[]{1, 2, 5}, 11));

        System.out.println("3 ?= " + coinChange_bfs_opt(new int[]{1, 2, 5}, 11));
    }
}
