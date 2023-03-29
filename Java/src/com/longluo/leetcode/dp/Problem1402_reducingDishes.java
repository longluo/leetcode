package com.longluo.leetcode.dp;

import java.util.Arrays;

/**
 * 1402. 做菜顺序
 * <p>
 * 一个厨师收集了他 n 道菜的满意程度 satisfaction ，这个厨师做出每道菜的时间都是 1 单位时间。
 * <p>
 * 一道菜的 「喜爱时间」系数定义为烹饪这道菜以及之前每道菜所花费的时间乘以这道菜的满意程度，也就是 time[i]*satisfaction[i] 。
 * <p>
 * 请你返回做完所有菜 「喜爱时间」总和的最大值为多少。
 * <p>
 * 你可以按 任意 顺序安排做菜的顺序，你也可以选择放弃做某些菜来获得更大的总和。
 * <p>
 * 示例 1：
 * 输入：satisfaction = [-1,-8,0,5,-9]
 * 输出：14
 * 解释：去掉第二道和最后一道菜，最大的喜爱时间系数和为 (-1*1 + 0*2 + 5*3 = 14) 。每道菜都需要花费 1 单位时间完成。
 * <p>
 * 示例 2：
 * 输入：satisfaction = [4,3,2]
 * 输出：20
 * 解释：按照原来顺序相反的时间做菜 (2*1 + 3*2 + 4*3 = 20)
 * <p>
 * 示例 3：
 * 输入：satisfaction = [-1,-4,-5]
 * 输出：0
 * 解释：大家都不喜欢这些菜，所以不做任何菜可以获得最大的喜爱时间系数。
 * <p>
 * 提示：
 * n == satisfaction.length
 * 1 <= n <= 500
 * -1000 <= satisfaction[i] <= 1000
 * <p>
 * https://leetcode.cn/problems/reducing-dishes/
 */
public class Problem1402_reducingDishes {

    // BF time: O(nlogn + n^2) space: O(logn)
    public static int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int n = satisfaction.length;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int cost = 1;
            for (int j = i; j < n; j++) {
                sum += satisfaction[j] * cost;
                cost++;
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("14 ?= " + maxSatisfaction(new int[]{-1, -8, 0, 5, -9}));
        System.out.println("20 ?= " + maxSatisfaction(new int[]{4, 3, 2}));
        System.out.println("0 ?= " + maxSatisfaction(new int[]{-1, -4, -5}));
    }
}
