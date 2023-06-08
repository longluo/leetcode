package com.longluo.contest.weekly_contest_348;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/contest/weekly-contest-348
 */

/**
 * 2718. 查询后矩阵的和
 * <p>
 * 给你一个整数 n 和一个下标从 0 开始的 二维数组 queries ，其中 queries[i] = [typei, indexi, vali] 。
 * <p>
 * 一开始，给你一个下标从 0 开始的 n x n 矩阵，所有元素均为 0 。每一个查询，你需要执行以下操作之一：
 * <p>
 * 如果 typei == 0 ，将第 indexi 行的元素全部修改为 vali ，覆盖任何之前的值。
 * 如果 typei == 1 ，将第 indexi 列的元素全部修改为 vali ，覆盖任何之前的值。
 * <p>
 * 请你执行完所有查询以后，返回矩阵中所有整数的和。
 * <p>
 * 示例 1：
 * 输入：n = 3, queries = [[0,0,1],[1,2,2],[0,2,3],[1,0,4]]
 * 输出：23
 * 解释：上图展示了每个查询以后矩阵的值。所有操作执行完以后，矩阵元素之和为 23 。
 * <p>
 * 示例 2：
 * 输入：n = 3, queries = [[0,0,4],[0,1,2],[1,0,1],[0,2,3],[1,2,1]]
 * 输出：17
 * 解释：上图展示了每一个查询操作之后的矩阵。所有操作执行完以后，矩阵元素之和为 17 。
 * <p>
 * 提示：
 * 1 <= n <= 10^4
 * 1 <= queries.length <= 5 * 10^4
 * queries[i].length == 3
 * 0 <= typei <= 1
 * 0 <= indexi < n
 * 0 <= vali <= 10^5
 * <p>
 * https://leetcode.cn/problems/sum-of-matrix-after-queries/
 */
public class Problem2718_sumOfMatrixAfterQueries {

    // BF time: O(mn+n^2) space: O(n^2)
    // TLE
    public static long matrixSumQueries_bf(int n, int[][] queries) {
        int[][] grid = new int[n][n];

        int index = 0;

        StringBuilder sb = new StringBuilder();

        for (int[] query : queries) {
            int type = query[0];
            int idx = query[1];
            int value = query[2];

            if (type == 0) {
                for (int i = 0; i < n; i++) {
                    grid[idx][i] = value;
                }
            } else {
                for (int i = 0; i < n; i++) {
                    grid[i][idx] = value;
                }
            }

            sb.append(index).append(",").append(count(grid)).append(" ");
            index++;
        }

        System.out.println(sb.toString());

        long ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += grid[i][j];
            }
        }

        return ans;
    }

    private static long count(int[][] grid) {
        int n = grid.length;

        long sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
            }
        }

        return sum;
    }

    // TODO: 2023/6/8  
    public static long matrixSumQueries_map(int n, int[][] queries) {
        Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, Integer> cols = new HashMap<>();

        long ans = 0;

        int lastRow = -1;
        int lastCol = -1;

        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            int idx = queries[i][1];
            int value = queries[i][2];

            if (type == 0) {
                int prev = rows.getOrDefault(idx, 0);

                ans += (long) (value - prev) * (n - cols.size());

                for (int x : cols.values()) {
                    if (idx == lastRow) {
                        ans += value - prev;
                    } else {
                        ans += value - x;
                    }
                }

                rows.put(idx, value);

                lastRow = idx;
            } else {
                int prev = cols.getOrDefault(idx, 0);

                ans += (long) (value - prev) * (n - rows.size());

                for (int x : rows.values()) {
                    if (idx == lastCol) {
                        ans += value - prev;
                    } else {
                        ans += value - x;
                    }
                }

                cols.put(idx, value);
                lastCol = idx;
            }

//            sb.append(i).append(",").append(ans).append(" ");
        }

//        System.out.println(sb.toString());

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("15 ?= " + matrixSumQueries_bf(4, new int[][]{{1, 1, 1}, {0, 1, 2}, {0, 1, 3}}));
        System.out.println("16 ?= " + matrixSumQueries_map(4, new int[][]{{1, 1, 1}, {0, 1, 2}, {0, 1, 3}}));

        System.out.println("326 ?= " + matrixSumQueries_bf(4, new int[][]{{0, 3, 2}, {1, 2, 9}, {1, 3, 4}, {1, 0, 8}, {1, 1, 3}, {0, 0, 1}, {0, 2, 3}, {1, 2, 6}}));
        System.out.println("326 ?= " + matrixSumQueries_map(4, new int[][]{{0, 3, 2}, {1, 2, 9}, {1, 3, 4}, {1, 0, 8}, {1, 1, 3}, {0, 0, 1}, {0, 2, 3}, {1, 2, 6}}));

        System.out.println("23 ?= " + matrixSumQueries_bf(3, new int[][]{{0, 0, 1}, {1, 2, 2}, {0, 2, 3}, {1, 0, 4}}));
        System.out.println("17 ?= " + matrixSumQueries_bf(3, new int[][]{{0, 0, 4}, {0, 1, 2}, {1, 0, 1}, {0, 2, 3}, {1, 2, 1}}));
        System.out.println("326 ?= " + matrixSumQueries_bf(8, new int[][]{{0, 6, 3}, {0, 7, 2}, {1, 2, 9}, {1, 3, 4}, {1, 0, 8}, {1, 1, 3}, {0, 0, 1}, {0, 4, 3}, {1, 4, 6}, {1, 5, 9}, {0, 5, 3}, {0, 1, 4}, {0, 2, 6}, {0, 3, 3}, {1, 7, 7}, {1, 6, 9}, {0, 5, 3}, {1, 0, 4}, {1, 1, 5}, {1, 2, 4}, {0, 6, 4}}));
        System.out.println("326 ?= " + matrixSumQueries_map(8, new int[][]{{0, 6, 3}, {0, 7, 2}, {1, 2, 9}, {1, 3, 4}, {1, 0, 8}, {1, 1, 3}, {0, 0, 1}, {0, 4, 3}, {1, 4, 6}, {1, 5, 9}, {0, 5, 3}, {0, 1, 4}, {0, 2, 6}, {0, 3, 3}, {1, 7, 7}, {1, 6, 9}, {0, 5, 3}, {1, 0, 4}, {1, 1, 5}, {1, 2, 4}, {0, 6, 4}}));

        System.out.println("23 ?= " + matrixSumQueries_map(3, new int[][]{{0, 0, 1}, {1, 2, 2}, {0, 2, 3}, {1, 0, 4}}));
        System.out.println("17 ?= " + matrixSumQueries_map(3, new int[][]{{0, 0, 4}, {0, 1, 2}, {1, 0, 1}, {0, 2, 3}, {1, 2, 1}}));
        System.out.println("2783119 ?= " + matrixSumQueries_map(8, new int[][]{{0, 6, 30094}, {0, 7, 99382}, {1, 2, 18599}, {1, 3, 49292}, {1, 0, 81549}, {1, 1, 38280}, {0, 0, 19405}, {0, 4, 30065}, {1, 4, 60826}, {1, 5, 9241}, {0, 5, 33729}, {0, 1, 41456}, {0, 2, 62692}, {0, 3, 30807}, {1, 7, 70613}, {1, 6, 9506}, {0, 5, 39344}, {1, 0, 44658}, {1, 1, 56485}, {1, 2, 48112}, {0, 6, 43384}}));
    }
}