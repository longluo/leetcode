package com.longluo.studyplan.ke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * <p>
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * 示例 1：
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 示例 2：
 * 输入：triangle = [[-10]]
 * 输出：-10
 * <p>
 * 提示：
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -10^4 <= triangle[i][j] <= 10^4
 * <p>
 * 进阶：
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 * <p>
 * https://leetcode.cn/problems/triangle/
 */
public class Problem120_triangle {

    /**
     * DP time: O(n^2) space: O(n^2)
     * <p>
     * 2
     * 3 4
     * 6 5 7
     * 4 1 8 3
     */
    public static int minimumTotal_dp(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int len = triangle.size();
        if (len == 1) {
            return triangle.get(0).get(0);
        }

        int min = Integer.MAX_VALUE;
        int[][] dp = new int[len][len];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1] + triangle.get(i).get(j), dp[i - 1][j] + triangle.get(i).get(j));
            }
        }

        for (int i = 0; i < len; i++) {
            min = Math.min(min, dp[len - 1][i]);
        }

        return min;
    }

    // DP Opt Space time: O(n^2) space: O(2*n)
    public static int minimumTotal_dp_opt(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[2][len];

        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i++) {
            int cur = i % 2;
            int prev = 1 - cur;

            dp[cur][0] = dp[prev][0] + triangle.get(i).get(0);
            dp[cur][i] = dp[prev][i - 1] + triangle.get(i).get(i);
            for (int j = 1; j < i; j++) {
                dp[cur][j] = Math.min(dp[prev][j - 1], dp[prev][j]) + triangle.get(i).get(j);
            }
        }

        int min = dp[(len - 1) % 2][0];
        for (int i = 1; i < len; i++) {
            min = Math.min(min, dp[(len + 1) % 2][i]);
        }

        return min;
    }

    // DP Top-Down time: O(n^2) space: O(n)
    public static int minimumTotal_dp_topdown(List<List<Integer>> triangle) {
        int len = triangle.size();

        int[] dp = new int[len];
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < len; i++) {
            dp[i] += dp[i - 1] + triangle.get(i).get(i);

            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }

            dp[0] += triangle.get(i).get(0);
        }

        int min = dp[0];
        for (int i = 1; i < len; i++) {
            min = Math.min(min, dp[i]);
        }

        return min;
    }

    // DP Bottom-Up Space time: O(n^2) space: O(n)
    public static int minimumTotal_dp_bottomup(List<List<Integer>> triangle) {
        int len = triangle.size();

        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = triangle.get(len - 1).get(i);
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> tst1 = new ArrayList<>();
        List<Integer> tst11 = new ArrayList<>();
        tst11.add(2);
        tst1.add(tst11);

        List<Integer> tst12 = new ArrayList<>();
        tst12.add(3);
        tst12.add(4);
        tst1.add(tst12);

        List<Integer> tst13 = new ArrayList<>();
        tst13.add(6);
        tst13.add(5);
        tst13.add(7);
        tst1.add(tst13);

        List<Integer> tst14 = new ArrayList<>();
        tst14.add(4);
        tst14.add(1);
        tst14.add(8);
        tst14.add(3);
        tst1.add(tst14);

        System.out.println(minimumTotal_dp(tst1));
        System.out.println(minimumTotal_dp_opt(tst1));
        System.out.println(minimumTotal_dp_topdown(tst1));
        System.out.println(minimumTotal_dp_bottomup(tst1));
    }
}
