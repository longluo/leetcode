package com.longluo.leetcode.dp;

/**
 * 1884. 鸡蛋掉落-两枚鸡蛋
 * <p>
 * 给你 2 枚相同 的鸡蛋，和一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 * <p>
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都 会碎 ，从 f 楼层或比它低 的楼层落下的鸡蛋都 不会碎 。
 * <p>
 * 每次操作，你可以取一枚 没有碎 的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 * <p>
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：我们可以将第一枚鸡蛋从 1 楼扔下，然后将第二枚从 2 楼扔下。
 * 如果第一枚鸡蛋碎了，可知 f = 0；
 * 如果第二枚鸡蛋碎了，但第一枚没碎，可知 f = 1；
 * 否则，当两个鸡蛋都没碎时，可知 f = 2。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 100
 * 输出：14
 * 解释：
 * 一种最优的策略是：
 * - 将第一枚鸡蛋从 9 楼扔下。如果碎了，那么 f 在 0 和 8 之间。将第二枚从 1 楼扔下，然后每扔一次上一层楼，在 8 次内找到 f 。总操作次数 = 1 + 8 = 9 。
 * - 如果第一枚鸡蛋没有碎，那么再把第一枚鸡蛋从 22 层扔下。如果碎了，那么 f 在 9 和 21 之间。将第二枚鸡蛋从 10 楼扔下，然后每扔一次上一层楼，在 12 次内找到 f 。总操作次数 = 2 + 12 = 14 。
 * - 如果第一枚鸡蛋没有再次碎掉，则按照类似的方法从 34, 45, 55, 64, 72, 79, 85, 90, 94, 97, 99 和 100 楼分别扔下第一枚鸡蛋。
 * 不管结果如何，最多需要扔 14 次来确定 f 。
 * <p>
 * 提示：
 * 1 <= n <= 1000
 * <p>
 * https://leetcode.cn/problems/egg-drop-with-2-eggs-and-n-floors/
 */
public class Problem1884_eggDropWith2EggsAndNFloors {

    /**
     * Dynamic Programming Solution
     * @param n
     * @return
     */
    public static int twoEggDrop(int n) {
        int[][] dp = new int[2][n + 1];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = dp[1][0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= i; k++) {
                dp[1][i] = Math.min(dp[1][i], Math.max(dp[0][k - 1] + 1, dp[1][i - k] + 1));
            }
        }

        return dp[1][n];
    }

    /**
     * Math Solution
     *
     * @param n
     * @return
     */
    public static int twoEggDrop_math(int n) {
        return (int) Math.ceil((Math.sqrt(1 + 8 * n) - 1) / 2);
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + twoEggDrop(2));
        System.out.println("3 ?= " + twoEggDrop(4));
        System.out.println("4 ?= " + twoEggDrop(7));
        System.out.println("5 ?= " + twoEggDrop(13));
        System.out.println("7 ?= " + twoEggDrop(25));
        System.out.println("10 ?= " + twoEggDrop(55));
        System.out.println("12 ?= " + twoEggDrop(67));
        System.out.println("13 ?= " + twoEggDrop(82));
        System.out.println("14 ?= " + twoEggDrop(100));

        System.out.println("\n ============= \n");

        System.out.println("2 ?= " + twoEggDrop_math(2));
        System.out.println("3 ?= " + twoEggDrop_math(4));
        System.out.println("4 ?= " + twoEggDrop_math(7));
        System.out.println("5 ?= " + twoEggDrop_math(13));
        System.out.println("7 ?= " + twoEggDrop_math(25));
        System.out.println("10 ?= " + twoEggDrop_math(55));
        System.out.println("12 ?= " + twoEggDrop_math(67));
        System.out.println("13 ?= " + twoEggDrop_math(82));
        System.out.println("14 ?= " + twoEggDrop_math(100));
    }
}
