package com.longluo.leetcode.dp;

/**
 * 887. 鸡蛋掉落
 * <p>
 * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 * <p>
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
 * <p>
 * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 * <p>
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 * <p>
 * 示例 1：
 * 输入：k = 1, n = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，肯定能得出 f = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，肯定能得出 f = 1 。
 * 如果它没碎，那么肯定能得出 f = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 f 是多少。
 * <p>
 * 示例 2：
 * 输入：k = 2, n = 6
 * 输出：3
 * <p>
 * 示例 3：
 * 输入：k = 3, n = 14
 * 输出：4
 * <p>
 * 提示：
 * 1 <= k <= 100
 * 1 <= n <= 10^4
 * <p>
 * https://leetcode.cn/problems/super-egg-drop/
 */
public class Problem887_superEggDrop {

    /**
     * DP Solution
     *
     * @param k
     * @param n
     * @return
     */
    public static int superEggDrop(int k, int n) {
        int[][] dp = new int[k][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                for (int m = 1; m <= j; m++) {
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i - 1][m - 1], dp[i][j - m]));
                }
            }
        }

        return dp[k - 1][n];
    }

    public static void main(String[] args) {
        System.out.println("=== DP === ");

        System.out.println("2 ?= " + superEggDrop(1, 2));
        System.out.println("3 ?= " + superEggDrop(2, 6));
        System.out.println("4 ?= " + superEggDrop(3, 14));

        System.out.println("OK");
    }
}
