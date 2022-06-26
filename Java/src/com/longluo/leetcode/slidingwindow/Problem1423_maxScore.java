package com.longluo.leetcode.slidingwindow;

import java.util.Arrays;

/**
 * 1423. 可获得的最大点数
 * <p>
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 * <p>
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 * <p>
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 * <p>
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 * <p>
 * 示例 1：
 * 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
 * 输出：12
 * 解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
 * <p>
 * 示例 2：
 * 输入：cardPoints = [2,2,2], k = 2
 * 输出：4
 * 解释：无论你拿起哪两张卡牌，可获得的点数总是 4 。
 * <p>
 * 示例 3：
 * 输入：cardPoints = [9,7,7,9,7,7,9], k = 7
 * 输出：55
 * 解释：你必须拿起所有卡牌，可以获得的点数为所有卡牌的点数之和。
 * <p>
 * 示例 4：
 * 输入：cardPoints = [1,1000,1], k = 1
 * 输出：1
 * 解释：你无法拿到中间那张卡牌，所以可以获得的最大点数为 1 。
 * <p>
 * 示例 5：
 * 输入：cardPoints = [1,79,80,1,1,1,200,1], k = 3
 * 输出：202
 * <p>
 * 提示：
 * 1 <= cardPoints.length <= 10^5
 * 1 <= cardPoints[i] <= 10^4
 * 1 <= k <= cardPoints.length
 * <p>
 * https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/
 */
public class Problem1423_maxScore {

    // SlidingWindow time: O(n) space: O(n)
    public static int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int[] prefixSums = new int[len + 1];
        for (int i = 0; i < len; i++) {
            prefixSums[i + 1] = prefixSums[i] + cardPoints[i];
        }

        if (k >= len) {
            return prefixSums[len];
        }

        int min = prefixSums[len];
        int segLen = len - k;
        for (int i = segLen; i <= len; i++) {
            min = Math.min(min, prefixSums[i] - prefixSums[i - segLen]);
        }

        return prefixSums[len] - min;
    }

    // SlidingWindow Opt time: O(n) space: O(1)
    public static int maxScore_opt(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int windowSize = len - k;
        int sum = 0;
        for (int i = 0; i < windowSize; i++) {
            sum += cardPoints[i];
        }

        int minSum = sum;
        for (int i = windowSize; i < len; i++) {
            sum = sum - cardPoints[i - windowSize] + cardPoints[i];
            minSum = Math.min(minSum, sum);
        }

        return Arrays.stream(cardPoints).sum() - minSum;
    }

    public static void main(String[] args) {
        System.out.println("12 ?= " + maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println("12 ?= " + maxScore_opt(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    }
}
