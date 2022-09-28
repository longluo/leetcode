package com.longluo.lcci;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 面试题 17.09. 第 k 个数
 * <p>
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。
 * 例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 * <p>
 * 示例 1:
 * 输入: k = 5
 * 输出: 9
 * <p>
 * https://leetcode.cn/problems/get-kth-magic-number-lcci/
 */
public class Lcci_17_09_getKthMagicNumber {

    // BF time: O(k^3log(k^3)) space: O(k^3)
    public static int getKthMagicNumber_bf(int k) {
        int max = Integer.MAX_VALUE;

        List<Integer> numsList = new ArrayList<>();

        for (long p = 1, l = 0; p <= max && l < k; p *= 3, l++) {
            for (long q = 1, m = 0; p * q <= max && m < k; q *= 5, m++) {
                for (long r = 1, n = 0; p * q * r <= max && n < k; r *= 7, n++) {
                    int res = (int) (p * q * r);
                    if (res > 0) {
                        numsList.add(res);
                    }
                }
            }
        }

        Collections.sort(numsList);

        return numsList.get(k - 1);
    }

    // DP time: O(k) space: O(k)
    public static int getKthMagicNumber_dp(int k) {
        int[] dp = new int[k + 1];
        dp[0] = 1;
        int p3 = 0;
        int p5 = 0;
        int p7 = 0;

        for (int i = 1; i <= k; i++) {
            dp[i] = Math.min(dp[p3] * 3, Math.min(dp[p5] * 5, dp[p7] * 7));
            if (dp[i] == dp[p3] * 3) {
                p3++;
            }
            if (dp[i] == dp[p5] * 5) {
                p5++;
            }
            if (dp[i] == dp[p7] * 7) {
                p7++;
            }
        }

        return dp[k - 1];
    }

    public static void main(String[] args) {
        System.out.println("9 ?= " + getKthMagicNumber_bf(5));
        System.out.println("81 ?= " + getKthMagicNumber_bf(15));
        System.out.println("3215625 ?= " + getKthMagicNumber_bf(251));

        System.out.println("81 ?= " + getKthMagicNumber_dp(15));
        System.out.println("3215625 ?= " + getKthMagicNumber_dp(251));
    }
}
