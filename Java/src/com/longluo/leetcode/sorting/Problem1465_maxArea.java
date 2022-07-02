package com.longluo.leetcode.sorting;

import java.util.Arrays;

/**
 * 1465. 切割后面积最大的蛋糕
 * <p>
 * 矩形蛋糕的高度为 h 且宽度为 w，给你两个整数数组 horizontalCuts 和 verticalCuts，其中：
 * <p>
 * horizontalCuts[i] 是从矩形蛋糕顶部到第  i 个水平切口的距离
 * verticalCuts[j] 是从矩形蛋糕的左侧到第 j 个竖直切口的距离
 * 请你按数组 horizontalCuts 和 verticalCuts 中提供的水平和竖直位置切割后，请你找出 面积最大 的那份蛋糕，并返回其 面积 。由于答案可能是一个很大的数字，因此需要将结果 对 109 + 7 取余 后返回。
 * <p>
 * 示例 1：
 * 输入：h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
 * 输出：4
 * 解释：上图所示的矩阵蛋糕中，红色线表示水平和竖直方向上的切口。切割蛋糕后，绿色的那份蛋糕面积最大。
 * <p>
 * 示例 2：
 * 输入：h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
 * 输出：6
 * 解释：上图所示的矩阵蛋糕中，红色线表示水平和竖直方向上的切口。切割蛋糕后，绿色和黄色的两份蛋糕面积最大。
 * <p>
 * 示例 3：
 * 输入：h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
 * 输出：9
 * <p>
 * 提示：
 * 2 <= h, w <= 10^9
 * 1 <= horizontalCuts.length <= min(h - 1, 10^5)
 * 1 <= verticalCuts.length <= min(w - 1, 10^5)
 * 1 <= horizontalCuts[i] < h
 * 1 <= verticalCuts[i] < w
 * 题目数据保证 horizontalCuts 中的所有元素各不相同
 * 题目数据保证 verticalCuts 中的所有元素各不相同
 * <p>
 * https://leetcode.cn/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 */
public class Problem1465_maxArea {

    // Sorting time: O(mn) space: O(max(logm, logn))
    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int MOD = 1_000_000_007;

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int max = 0;
        for (int i = 0; i <= horizontalCuts.length; i++) {
            long height = 0;
            if (i == 0) {
                height = horizontalCuts[0];
            } else if (i == horizontalCuts.length) {
                height = h - horizontalCuts[i - 1];
            } else {
                height = horizontalCuts[i] - horizontalCuts[i - 1];
            }

            for (int j = 0; j <= verticalCuts.length; j++) {
                long width = 0;
                if (j == 0) {
                    width = verticalCuts[0];
                } else if (j == verticalCuts.length) {
                    width = w - verticalCuts[j - 1];
                } else {
                    width = verticalCuts[j] - verticalCuts[j - 1];
                }

                int area = (int) ((height * width) % MOD);
                max = Math.max(max, area);
            }
        }

        return max;
    }

    // Greedy time: O(max(mlogm) space: O(logm)
    public static int maxArea_opt(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int MOD = 1_000_000_007;

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long horizonMax = 0;
        long verticalMax = 0;

        for (int i = 1; i < horizontalCuts.length; i++) {
            horizonMax = Math.max(horizonMax, horizontalCuts[i] - horizontalCuts[i - 1]);
        }

        horizonMax = Math.max(horizonMax, horizontalCuts[0]);
        horizonMax = Math.max(horizonMax, h - horizontalCuts[horizontalCuts.length - 1]);

        for (int j = 1; j < verticalCuts.length; j++) {
            verticalMax = Math.max(verticalMax, verticalCuts[j] - verticalCuts[j - 1]);
        }

        verticalMax = Math.max(verticalMax, verticalCuts[0]);
        verticalMax = Math.max(verticalMax, w - verticalCuts[verticalCuts.length - 1]);

        return (int) ((horizonMax * verticalMax) % MOD);
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + maxArea(5, 4, new int[]{1, 2, 4}, new int[]{1, 3}));
        System.out.println("9604 ?= " + maxArea(100, 100, new int[]{2}, new int[]{2}));
        System.out.println("81 ?= " + maxArea(1000000000, 1000000000, new int[]{2}, new int[]{2}));

        System.out.println("81 ?= " + maxArea_opt(1000000000, 1000000000, new int[]{2}, new int[]{2}));
    }
}
