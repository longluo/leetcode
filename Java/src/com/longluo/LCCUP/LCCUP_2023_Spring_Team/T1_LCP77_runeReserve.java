package com.longluo.LCCUP.LCCUP_2023_Spring_Team;


import java.util.Arrays;

/**
 * LCP 77. 符文储备
 * <p>
 * 远征队在出发前需要携带一些「符文」，作为后续的冒险储备。runes[i] 表示第 i 枚符文的魔力值。
 * <p>
 * 他们将从中选取若干符文进行携带，并对这些符文进行重新排列，以确保任意相邻的两块符文之间的魔力值相差不超过 1。
 * <p>
 * 请返回他们能够携带的符文 最大数量。
 * <p>
 * 示例 1：
 * 输入：runes = [1,3,5,4,1,7]
 * 输出：3
 * 解释：最佳的选择方案为[3,5,4]
 * 将其排列为 [3,4,5] 后，任意相邻的两块符文魔力值均不超过 1，携带数量为 3
 * 其他满足条件的方案为 [1,1] 和 [7]，数量均小于 3。
 * 因此返回可携带的最大数量 3。
 * <p>
 * 示例 2：
 * 输入：runes = [1,1,3,3,2,4]
 * 输出：6
 * 解释：排列为 [1,1,2,3,3,4]，可携带所有的符文
 * <p>
 * 提示：
 * 1 <= runes.length <= 10^4
 * 0 <= runes[i] <= 10^4
 * <p>
 * https://leetcode.cn/problems/W2ZX4X/
 */
public class T1_LCP77_runeReserve {

    public static int runeReserve(int[] runes) {
        int n = runes.length;

        Arrays.sort(runes);

        int ans = 1;

        for (int i = 0; i < n; i++) {
            int cnt = 1;

            for (int j = i - 1; j >= 0; j--) {
                int diff = Math.abs(runes[j] - runes[j + 1]);
                if (diff > 1) {
                    break;
                }

                cnt++;
            }

            for (int j = i + 1; j < runes.length; j++) {
                int diff = Math.abs(runes[j] - runes[j - 1]);
                if (diff > 1) {
                    break;
                }

                cnt++;
            }

            ans = Math.max(ans, cnt);
            if (ans == n) {
                return ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + runeReserve(new int[]{1, 3, 5, 4, 1, 7}));
        System.out.println("6 ?= " + runeReserve(new int[]{1, 1, 3, 3, 2, 4}));
    }
}
