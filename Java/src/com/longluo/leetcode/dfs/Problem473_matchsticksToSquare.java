package com.longluo.leetcode.dfs;

import java.util.Arrays;

/**
 * 473. 火柴拼正方形
 * <p>
 * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。
 * 你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 * <p>
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 * <p>
 * 示例 1:
 * 输入: matchsticks = [1,1,2,2,2]
 * 输出: true
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * <p>
 * 示例 2:
 * 输入: matchsticks = [3,3,3,3,4]
 * 输出: false
 * 解释: 不能用所有火柴拼成一个正方形。
 * <p>
 * 提示:
 * 1 <= matchsticks.length <= 15
 * 1 <= matchsticks[i] <= 10^8
 * <p>
 * https://leetcode.cn/problems/matchsticks-to-square/
 */
public class Problem473_matchsticksToSquare {

    // Backtrack time: O(4^n) space: O(n)
    // TLE
    public static boolean makesquare(int[] matchsticks) {
        int len = matchsticks.length;
        int sum = Arrays.stream(matchsticks).sum();
        if (len < 4 || sum % 4 != 0) {
            return false;
        }

        Arrays.sort(matchsticks);

        int[] edges = new int[4];

        return backtrack(0, matchsticks, edges, sum / 4);
    }

    // Backtrack time: O(4^n) space: O(n)
    // AC
    public static boolean makesquare_opt(int[] matchsticks) {
        int len = matchsticks.length;
        int sum = Arrays.stream(matchsticks).sum();
        if (len < 4 || sum % 4 != 0) {
            return false;
        }

        Arrays.sort(matchsticks);

        for (int i = 0, j = len - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        int[] edges = new int[4];

        return backtrack(0, matchsticks, edges, sum / 4);
    }

    private static boolean backtrack(int index, int[] matchsticks, int[] edges, int len) {
        if (index == matchsticks.length) {
            return true;
        }

        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= len && backtrack(index + 1, matchsticks, edges, len)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + makesquare(new int[]{1, 1, 2, 2, 2}));
        System.out.println("true ?= " + makesquare_opt(new int[]{1, 1, 2, 2, 2}));
    }
}
