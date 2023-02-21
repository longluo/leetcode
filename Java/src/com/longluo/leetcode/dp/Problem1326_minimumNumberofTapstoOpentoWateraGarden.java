package com.longluo.leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1326. 灌溉花园的最少水龙头数目
 * <p>
 * 在 x 轴上有一个一维的花园。花园长度为 n，从点 0 开始，到点 n 结束。
 * <p>
 * 花园里总共有 n + 1 个水龙头，分别位于 [0, 1, ..., n] 。
 * <p>
 * 给你一个整数 n 和一个长度为 n + 1 的整数数组 ranges ，其中 ranges[i] （下标从 0 开始）表示：如果打开点 i 处的水龙头，
 * 可以灌溉的区域为 [i -  ranges[i], i + ranges[i]] 。
 * <p>
 * 请你返回可以灌溉整个花园的 最少水龙头数目 。如果花园始终存在无法灌溉到的地方，请你返回 -1 。
 * <p>
 * 示例 1：
 * 输入：n = 5, ranges = [3,4,1,1,0,0]
 * 输出：1
 * 解释：
 * 点 0 处的水龙头可以灌溉区间 [-3,3]
 * 点 1 处的水龙头可以灌溉区间 [-3,5]
 * 点 2 处的水龙头可以灌溉区间 [1,3]
 * 点 3 处的水龙头可以灌溉区间 [2,4]
 * 点 4 处的水龙头可以灌溉区间 [4,4]
 * 点 5 处的水龙头可以灌溉区间 [5,5]
 * 只需要打开点 1 处的水龙头即可灌溉整个花园 [0,5] 。
 * <p>
 * 示例 2：
 * 输入：n = 3, ranges = [0,0,0,0]
 * 输出：-1
 * 解释：即使打开所有水龙头，你也无法灌溉整个花园。
 * <p>
 * 提示：
 * 1 <= n <= 10^4
 * ranges.length == n + 1
 * 0 <= ranges[i] <= 100
 * <p>
 * https://leetcode.cn/problems/minimum-number-of-taps-to-open-to-water-a-garden/
 */
public class Problem1326_minimumNumberofTapstoOpentoWateraGarden {

    // Greedy time: O(n) space: O(1)
    public static int minTaps(int n, int[] ranges) {
        int len = ranges.length;

        int[] futhest = new int[len];

        for (int i = 0; i < len; i++) {
            int rad = ranges[i];

            if (i > rad) {
                futhest[i - rad] = i + rad;
            } else {
                futhest[0] = Math.max(futhest[0], i + rad);
            }
        }

        int ans = 0;

        int cur = 0;
        int next = 0;

        for (int i = 0; i < n; i++) {
            next = Math.max(next, futhest[i]);
            if (i == cur) {
                if (i == next) {
                    return -1;
                }

                cur = next;
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("-1 ?= " + minTaps(3, new int[]{0, 0, 0, 0}));
        System.out.println("1 ?= " + minTaps(5, new int[]{3, 4, 1, 1, 0, 0}));
        System.out.println("1 ?= " + minTaps(8, new int[]{4, 0, 0, 0, 4, 0, 0, 0, 4}));
        System.out.println("2 ?= " + minTaps(9, new int[]{0, 5, 0, 3, 3, 3, 1, 4, 0, 4}));
    }
}
