package com.longluo.contest.biweekly_contest_92;

/**
 * https://leetcode.cn/contest/biweekly-contest-92
 */

/**
 * 2481. 分割圆的最少切割次数
 * <p>
 * 圆内一个 有效切割 ，符合以下二者之一：
 * 该切割是两个端点在圆上的线段，且该线段经过圆心。
 * 该切割是一端在圆心另一端在圆上的线段。
 * 一些有效和无效的切割如下图所示。
 * <p>
 * 给你一个整数 n ，请你返回将圆切割成相等的 n 等分的 最少 切割次数。
 * <p>
 * 示例 1：
 * 输入：n = 4
 * 输出：2
 * 解释：
 * 上图展示了切割圆 2 次，得到四等分。
 * <p>
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：
 * 最少需要切割 3 次，将圆切成三等分。
 * 少于 3 次切割无法将圆切成大小相等面积相同的 3 等分。
 * 同时可以观察到，第一次切割无法将圆切割开。
 * <p>
 * 提示：
 * 1 <= n <= 100
 * <p>
 * https://leetcode.cn/problems/minimum-cuts-to-divide-a-circle/
 */
public class Problem2481_minimumCutsToDivideACircle {

    // BF time: O(1) space: O(1)
    public static int numberOfCuts(int n) {
        if (n <= 1) {
            return 0;
        }

        if (n % 2 == 1) {
            return n;
        }

        return n / 2;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + numberOfCuts(1));
        System.out.println("1 ?= " + numberOfCuts(2));
        System.out.println("3 ?= " + numberOfCuts(3));
        System.out.println("2 ?= " + numberOfCuts(4));
        System.out.println("3 ?= " + numberOfCuts(6));
        System.out.println("4 ?= " + numberOfCuts(8));
        System.out.println("4 ?= " + numberOfCuts(12));
    }
}
