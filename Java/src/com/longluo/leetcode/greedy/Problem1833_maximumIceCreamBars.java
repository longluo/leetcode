package com.longluo.leetcode.greedy;

import java.util.Arrays;

/**
 * 1833. 雪糕的最大数量
 * <p>
 * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。
 * Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 * 注意：Tony 可以按任意顺序购买雪糕。
 * <p>
 * 示例 1：
 * 输入：costs = [1,3,2,4,1], coins = 7
 * 输出：4
 * 解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
 * <p>
 * 示例 2：
 * 输入：costs = [10,6,8,7,7,8], coins = 5
 * 输出：0
 * 解释：Tony 没有足够的钱买任何一支雪糕。
 * <p>
 * 示例 3：
 * 输入：costs = [1,6,3,1,2,5], coins = 20
 * 输出：6
 * 解释：Tony 可以买下所有的雪糕，总价为 1 + 6 + 3 + 1 + 2 + 5 = 18 。
 * <p>
 * 提示：
 * costs.length == n
 * 1 <= n <= 10^5
 * 1 <= costs[i] <= 10^5
 * 1 <= coins <= 10^8
 * <p>
 * https://leetcode.cn/problems/maximum-ice-cream-bars/
 */
public class Problem1833_maximumIceCreamBars {

    // Sort time: O(nlogn) space: O(logn)
    public static int maxIceCream(int[] costs, int coins) {
        int len = costs.length;

        Arrays.sort(costs);

        int ans = 0;

        for (int i = 0; i < len; i++) {
            if (coins >= costs[i]) {
                coins -= costs[i];
                ans++;
            } else {
                break;
            }
        }

        return ans;
    }

    public int maxIceCream_2(int[] costs, int coins) {
        int[] freq = new int[100001];
        for (int cost : costs) {
            freq[cost]++;
        }
        int count = 0;
        for (int i = 1; i <= 100000; i++) {
            if (coins >= i) {
                int curCount = Math.min(freq[i], coins / i);
                count += curCount;
                coins -= i * curCount;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));
        System.out.println("0 ?= " + maxIceCream(new int[]{10, 6, 8, 7, 7, 8}, 5));
        System.out.println("6 ?= " + maxIceCream(new int[]{1, 6, 3, 1, 2, 5}, 20));
    }
}
